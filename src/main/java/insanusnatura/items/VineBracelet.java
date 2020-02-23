package insanusnatura.items;

import insanusnatura.Main;
import insanusnatura.init.ModItems;
import insanusnatura.init.ModCreativeTabs;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class VineBracelet extends Item implements IHasModel {
    public VineBracelet() {
        setUnlocalizedName("vine_bracelet");
        setRegistryName("vine_bracelet");
        setCreativeTab(ModCreativeTabs.MOD_TAB);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}