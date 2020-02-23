package insanusnatura.world;

import insanusnatura.world.layers.GenLayerInsanusNaturaBiomes;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.init.Biomes;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraft.world.gen.layer.IntCache;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BiomeProviderInsanusNatura extends BiomeProvider {
    private GenLayer genBiomes;
    private GenLayer biomeIndexLayer;
    private BiomeCache biomeCache;

    public BiomeProviderInsanusNatura() {
        this.biomeCache = new BiomeCache(this);
    }

    public BiomeProviderInsanusNatura(long seed) {
        this.biomeCache = new BiomeCache(this);
        GenLayer[] agenlayer = makeTheWorld(seed);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }

    private GenLayer[] makeTheWorld(long seed) {
        GenLayer biomes = new GenLayerInsanusNaturaBiomes(1);
        biomes = new GenLayerZoom(1000, biomes);
        biomes = new GenLayerZoom(1001, biomes);
        biomes = new GenLayerZoom(1002, biomes);
        biomes = new GenLayerZoom(1003, biomes);
        biomes = new GenLayerZoom(1004, biomes);
        biomes = new GenLayerZoom(1005, biomes);
        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10, biomes);
        biomes.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        return new GenLayer[]{biomes, genlayervoronoizoom};
    }

    public BiomeProviderInsanusNatura(World world) {
        this(world.getSeed());
    }

    @Override
    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }

    @Override
    public Biome getBiome(BlockPos pos) {
        return this.getBiome(pos, null);
    }

    @Override
    public Biome getBiome(BlockPos pos, Biome defaultBiome) {
        return this.biomeCache.getBiome(pos.getX(), pos.getZ(), defaultBiome);
    }

    @Override
    public Biome[] getBiomes(Biome[] oldBiomeList, int x, int z, int width, int depth) {
        return this.getBiomes(oldBiomeList, x, z, width, depth, true);
    }

    @Override
    /**
     * Returns an array of biomes for the location input.
     */
    public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height) {
        IntCache.resetIntCache();
        if (biomes == null || biomes.length < width * height) {
            biomes = new Biome[width * height];
        }
        int[] aint = this.genBiomes.getInts(x, z, width, height);
        try {
            for (int i = 0; i < width * height; ++i) {
                biomes[i] = Biome.getBiome(aint[i], Biomes.DEFAULT);
            }
            return biomes;
        } catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
            crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(biomes.length));
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("w", Integer.valueOf(width));
            crashreportcategory.addCrashSection("h", Integer.valueOf(height));
            throw new ReportedException(crashreport);
        }
    }

    @Override
    /**
     * Gets a list of biomes for the specified blocks.
     */
    public Biome[] getBiomes(@Nullable Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag) {
        IntCache.resetIntCache();
        if (listToReuse == null || listToReuse.length < width * length) {
            listToReuse = new Biome[width * length];
        }
        if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (z & 15) == 0) {
            Biome[] abiome = this.biomeCache.getCachedBiomes(x, z);
            System.arraycopy(abiome, 0, listToReuse, 0, width * length);
            return listToReuse;
        } else {
            int[] aint = this.biomeIndexLayer.getInts(x, z, width, length);
            for (int i = 0; i < width * length; ++i) {
                listToReuse[i] = Biome.getBiome(aint[i], Biomes.DEFAULT);
            }
            return listToReuse;
        }
    }

    @Override
    /**
     * checks given Chunk's Biomes against List of allowed ones
     */
    public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed) {
        IntCache.resetIntCache();
        int i = x - radius >> 2;
        int j = z - radius >> 2;
        int k = x + radius >> 2;
        int l = z + radius >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genBiomes.getInts(i, j, i1, j1);
        try {
            for (int k1 = 0; k1 < i1 * j1; ++k1) {
                Biome biome = Biome.getBiome(aint[k1]);
                if (!allowed.contains(biome)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable throwable) {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
            crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
            crashreportcategory.addCrashSection("allowed", allowed);
            throw new ReportedException(crashreport);
        }
    }

    @Override
    @Nullable
    public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
        IntCache.resetIntCache();
        int i = x - range >> 2;
        int j = z - range >> 2;
        int k = x + range >> 2;
        int l = z + range >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genBiomes.getInts(i, j, i1, j1);
        BlockPos blockpos = null;
        int k1 = 0;
        for (int l1 = 0; l1 < i1 * j1; ++l1) {
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            Biome biome = Biome.getBiome(aint[l1]);
            if (biomes.contains(biome) && (blockpos == null || random.nextInt(k1 + 1) == 0)) {
                blockpos = new BlockPos(i2, 0, j2);
                ++k1;
            }
        }
        return blockpos;
    }
}