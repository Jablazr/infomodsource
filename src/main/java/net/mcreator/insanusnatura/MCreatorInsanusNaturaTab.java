package net.mcreator.insanusnatura;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

@Elementsinsanusnatura.ModElement.Tag
public class MCreatorInsanusNaturaTab extends Elementsinsanusnatura.ModElement {
	public MCreatorInsanusNaturaTab(Elementsinsanusnatura instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabinsanusnaturatab") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(MCreatorMysticBedrock.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
