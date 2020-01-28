package insanusnatura.objects.blocks;

import insanusnatura.Main;
import insanusnatura.init.BlockInit;
import insanusnatura.init.ItemInit;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class MagicalGrass extends Block implements IHasModel {
    public MagicalGrass(String name) {
        super(Material.GROUND);
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.GROUND);
        setHarvestLevel("shovel", 1);
        setHardness(0.6F);
        setResistance(3F);
        setLightLevel(0F);
        setLightOpacity(255);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
