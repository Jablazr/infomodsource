package insanusnatura.objects.items;

import insanusnatura.Main;
import insanusnatura.init.ItemInit;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class MysticalDust extends Item implements IHasModel {
    public MysticalDust() {
        setUnlocalizedName("mysticaldust");
        setRegistryName("mysticaldust");
        setCreativeTab(Main.tab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
