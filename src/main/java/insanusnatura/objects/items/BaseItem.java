package insanusnatura.objects.items;

import insanusnatura.Main;
import insanusnatura.init.ItemInit;
import insanusnatura.objects.tabs.InsanusNaturaTab;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BaseItem extends Item implements IHasModel {
    public BaseItem(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
