package insanusnatura.mechanics;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// WIP
public class FloorCrafting implements ITickable {
    public FloorCrafting() {

    }

    public boolean canCraft(World world, BlockPos blockPos, Block block, ItemStack... itemStacks) {
        IBlockState state = world.getBlockState(blockPos.down());
        Block blockUnder = state.getBlock();
        if(Block.isEqualTo(blockUnder, block)) {
            if(FloorCraftingRecipes.getInstance()
                    .getFloorCraftingResult(itemStacks) != ItemStack.EMPTY) {
                return true;
            }
        }
        return false;
    }

    public void craftItem(World world, BlockPos blockPos, ItemStack result, ItemStack... itemStacks) {


    }

    @Override
    public void update() {

    }
}