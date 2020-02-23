package insanusnatura.init;

import insanusnatura.world.BiomeMagic;
import insanusnatura.world.BiomeMysticalPlains;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {
    public static final Biome MAGIC = new BiomeMagic();
    public static final Biome MYSTICALPLAINS = new BiomeMysticalPlains();
    public static void registerBiomes()
    {
        initBiome(MAGIC, "magic", 10, BiomeManager.BiomeType.WARM, Type.FOREST, Type.MAGICAL);
        initBiome(MYSTICALPLAINS, "mysticalplains", 20, BiomeManager.BiomeType.WARM, Type.PLAINS, Type.MAGICAL);
    }

    private static Biome initBiome(Biome biome, String name, int weight, BiomeManager.BiomeType biomeType, Type... types)
    {
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));
        BiomeManager.addSpawnBiome(biome);
        return biome;
    }
}
