package insanusnatura.world;

import insanusnatura.init.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeMysticalPlains extends Biome {
    public BiomeMysticalPlains() {
        super(new Biome.BiomeProperties("Mystical Plains").setRainfall(0.5F).setBaseHeight(0.1F).setHeightVariation(0.2F).setTemperature(0.5F));
        topBlock = ModBlocks.MYSTIC_GRASS.getDefaultState();
        fillerBlock = ModBlocks.MYSTIC_DIRT.getDefaultState();
        decorator.generateFalls = false;
        decorator.treesPerChunk = 3;
        decorator.flowersPerChunk = 4;
        decorator.grassPerChunk = 4;
        decorator.deadBushPerChunk = 0;
        decorator.mushroomsPerChunk = 0;
        decorator.bigMushroomsPerChunk = 0;
        decorator.reedsPerChunk = 0;
        decorator.cactiPerChunk = 0;
        decorator.sandPatchesPerChunk = 0;
        decorator.gravelPatchesPerChunk = 0;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return super.getRandomTreeFeature(rand);
    }
}
