package insanusnatura.init;

import insanusnatura.world.biomes.MagicalBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
    public static final Biome MAGIC = new MagicalBiome();
    public static void registerBiomes()
    {
        initBiome(MAGIC, "Magic", BiomeManager.BiomeType.WARM, Type.FOREST, Type.FOREST, Type.MAGICAL);
    }

    private static Biome initBiome(Biome biome, String name, BiomeManager.BiomeType biomeType, Type... types)
    {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, 100));
        BiomeManager.addSpawnBiome(biome);
        return biome;
    }
}
