package insanusnatura.objects.blocks;

import insanusnatura.Main;
import insanusnatura.init.BlockInit;
import insanusnatura.init.ItemInit;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class MysticGrass extends Block implements IHasModel {
    public MysticGrass() {
        super(Material.GRASS);
        setRegistryName("mysticgrass");
        setUnlocalizedName("mysticgrass");
        setSoundType(SoundType.GROUND);
        setHarvestLevel("shovel", 0);
        setHardness(0.6F);
        setResistance(3F);
        setLightLevel(0F);
        setLightOpacity(0);
        setCreativeTab(Main.tab);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
                                   net.minecraftforge.common.IPlantable plantable) {
        return true;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.add(new ItemStack(BlockInit.MYSTIC_DIRT, 1));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
