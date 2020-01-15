package net.mcreator.insanusnatura;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

@Elementsinsanusnatura.ModElement.Tag
public class MCreatorMysticPlains extends Elementsinsanusnatura.ModElement {
	@GameRegistry.ObjectHolder("insanusnatura:mysticplains")
	public static final BiomeGenCustom biome = null;

	public MCreatorMysticPlains(Elementsinsanusnatura instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.PLAINS);
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 10));
	}

	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Mystic Plains").setRainfall(0.1F).setBaseHeight(0.1F).setWaterColor(-12288001).setHeightVariation(0.2F)
					.setTemperature(0.5F));
			setRegistryName("mysticplains");
			topBlock = MCreatorMysticGrass.block.getDefaultState();
			fillerBlock = MCreatorMysticDirt.block.getDefaultState();
			decorator.generateFalls = true;
			decorator.treesPerChunk = 1;
			decorator.flowersPerChunk = 2;
			decorator.grassPerChunk = 4;
			decorator.deadBushPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -13261999;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -13261999;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -5916161;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return new WorldGenSavannaTree(false);
		}
	}
}
