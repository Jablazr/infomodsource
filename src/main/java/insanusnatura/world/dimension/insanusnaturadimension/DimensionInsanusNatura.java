package insanusnatura.world.dimension.insanusnaturadimension;

import insanusnatura.init.BiomeInit;
import insanusnatura.init.DimensionInit;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionInsanusNatura extends WorldProvider
{
    public DimensionInsanusNatura()
    {
        this.biomeProvider = new BiomeProviderSingle(BiomeInit.MAGIC);

    }

    @Override
    public DimensionType getDimensionType() {
        return DimensionInit.INSANUSNATURA_DIM_TYPE;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorInsanusNatura(world,world.getSeed(),true, "yes");
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }
}
