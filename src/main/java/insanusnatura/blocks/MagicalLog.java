package insanusnatura.blocks;

import insanusnatura.Main;
import insanusnatura.init.ModBlocks;
import insanusnatura.init.ModItems;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class MagicalLog extends Block implements IHasModel {


    public MagicalLog(String name) {
        super(Material.WOOD);

        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.WOOD);
        setHarvestLevel("axe", 0);
        setHardness(2F);
        setResistance(10F);
        setLightLevel(0F);
        setLightOpacity(255);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {

        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");


    }

    @Override
    public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return true;
    }
}
