package net.mcreator.insanusnatura;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import java.util.Random;

@Elementsinsanusnatura.ModElement.Tag
public class MCreatorMysticBedrock extends Elementsinsanusnatura.ModElement {
	@GameRegistry.ObjectHolder("insanusnatura:mysticbedrock")
	public static final Block block = null;

	public MCreatorMysticBedrock(Elementsinsanusnatura instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("insanusnatura:mysticbedrock",
				"inventory"));
	}

	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setRegistryName("mysticbedrock");
			setUnlocalizedName("mysticbedrock");
			setSoundType(SoundType.GLASS);
			setHardness(10000F);
			setResistance(10000F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(MCreatorInsanusNaturaTab.tab);
			setBlockUnbreakable();
		}

		@Override
		public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
			return false;
		}

		@Override
		public int quantityDropped(Random random) {
			return 0;
		}
	}
}
