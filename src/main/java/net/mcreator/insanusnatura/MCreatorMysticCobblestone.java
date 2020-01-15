package net.mcreator.insanusnatura;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

@Elementsinsanusnatura.ModElement.Tag
public class MCreatorMysticCobblestone extends Elementsinsanusnatura.ModElement {
	@GameRegistry.ObjectHolder("insanusnatura:mysticcobblestone")
	public static final Block block = null;

	public MCreatorMysticCobblestone(Elementsinsanusnatura instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom());
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("insanusnatura:mysticcobblestone",
				"inventory"));
	}

	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setRegistryName("mysticcobblestone");
			setUnlocalizedName("mysticcobblestone");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 1);
			setHardness(2F);
			setResistance(30F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(MCreatorInsanusNaturaTab.tab);
		}
	}
}
