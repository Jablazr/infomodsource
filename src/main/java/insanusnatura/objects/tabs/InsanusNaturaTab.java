package insanusnatura.objects.tabs;

import insanusnatura.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InsanusNaturaTab extends CreativeTabs {
    public InsanusNaturaTab() {
        super("insanusnatura");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(BlockInit.MAGICAL_BLOCK);
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }
}