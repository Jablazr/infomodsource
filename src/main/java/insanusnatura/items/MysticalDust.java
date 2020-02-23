package insanusnatura.items;

import insanusnatura.Main;
import insanusnatura.init.ModItems;
import insanusnatura.init.ModCreativeTabs;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class MysticalDust extends Item implements IHasModel {
    public MysticalDust() {
        setUnlocalizedName("mysticaldust");
        setRegistryName("mysticaldust");
        setCreativeTab(ModCreativeTabs.MOD_TAB);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
