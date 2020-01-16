package insanusnatura.objects.blocks;

import insanusnatura.Main;
import insanusnatura.init.BlockInit;
import insanusnatura.init.ItemInit;
import insanusnatura.objects.tabs.InsanusNaturaTab;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class MysticDirt extends Block implements IHasModel {
    public MysticDirt() {
        super(Material.GROUND);
        setRegistryName("mysticdirt");
        setUnlocalizedName("mysticdirt");
        setSoundType(SoundType.GROUND);
        setHarvestLevel("shovel", 0);
        setHardness(0.5F);
        setResistance(2.5F);
        setLightLevel(0F);
        setLightOpacity(0);
        setCreativeTab(Main.tab);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
