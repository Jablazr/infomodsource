package insanusnatura.blocks;

import insanusnatura.Main;
import insanusnatura.init.ModBlocks;
import insanusnatura.init.ModItems;
import insanusnatura.init.ModCreativeTabs;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

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
        setCreativeTab(ModCreativeTabs.MOD_TAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
                                   net.minecraftforge.common.IPlantable plantable) {
        return true;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
