package insanusnatura.objects.blocks;

import insanusnatura.Main;
import insanusnatura.init.BlockInit;
import insanusnatura.init.ItemInit;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class MagicalLeaves extends Block implements IHasModel {


    public MagicalLeaves(String name) {
        super(Material.PLANTS);

        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.PLANT);
        setHarvestLevel("shears", 0);
        setHardness(0.2F);
        setResistance(1F);
        setLightLevel(0F);
        setLightOpacity(255);
        setCreativeTab(CreativeTabs.DECORATIONS);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {

            Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");


    }
}
