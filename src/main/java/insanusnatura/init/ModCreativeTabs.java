package insanusnatura.init;

import insanusnatura.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModCreativeTabs {
    // instantiate creative tabs
    public static final CustomCreativeTab MOD_TAB = new CustomCreativeTab();

    /**
     * This class is used for an extra tab in the creative inventory. Many
     * mods like to group their special items and blocks in a dedicated tab
     * although it is also perfectly acceptable to put them in the vanilla tabs
     * where it makes sense.
     * */
    public static class CustomCreativeTab extends CreativeTabs
    {
        /**
         * Instantiates a new custom creative tab.
         */
        public CustomCreativeTab()
        {
            // pass a string for the tab label, if you only have one it is common
            // to pass the modid and then in your lang file you can put name of your mod.
            // The unlocalized name of a tab automatically has "itemGroup." prepended.
            super(Reference.MOD_ID);
        }

        /* (non-Javadoc)
         * @see net.minecraft.creativetab.CreativeTabs#getTabIconItem()
         */
        @SideOnly(Side.CLIENT)
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ModBlocks.MYSTIC_GRASS, 1);
        }

        /* (non-Javadoc)
         * @see net.minecraft.creativetab.CreativeTabs#displayAllRelevantItems(net.minecraft.util.NonNullList)
         */
        @SideOnly(Side.CLIENT)
        @Override
        public void displayAllRelevantItems(final NonNullList<ItemStack> items)
        {
            super.displayAllRelevantItems(items);
        }
    }
}
