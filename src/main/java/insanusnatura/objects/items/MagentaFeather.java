package insanusnatura.objects.items;

import insanusnatura.Main;
import insanusnatura.init.ItemInit;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class MagentaFeather extends Item implements IHasModel {
    public MagentaFeather() {
        setUnlocalizedName("magentafeather");
        setRegistryName("magentafeather");
        setCreativeTab(Main.tab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
