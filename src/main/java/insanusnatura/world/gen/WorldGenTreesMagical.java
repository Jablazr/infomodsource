package insanusnatura.world.gen;

import insanusnatura.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class WorldGenTreesMagical extends WorldGenAbstractTree {


    private IBlockState blockStateWood = BlockInit.MAGICAL_LOG.getDefaultState();
    private IBlockState blockStateLeaves = BlockInit.MAGICAL_LEAVES.getDefaultState();
    private final int minTreeHeight = 30;


    public WorldGenTreesMagical(boolean parShouldNotify) {
        super(parShouldNotify);
    }

    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos) {
        int minHeight = parRandom.nextInt(4) + minTreeHeight;

        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= parWorld.getHeight()) {
            if (!isSuitableLocation(parWorld, parBlockPos, minHeight)) {
                return false;
            } else {
                IBlockState state = parWorld.getBlockState(parBlockPos.down());

                if (state.getBlock().canSustainPlant(state, parWorld, parBlockPos.down(), EnumFacing.UP, (IPlantable) Blocks.SAPLING) && parBlockPos.getY() < parWorld.getHeight() - minHeight - 1) {
                    state.getBlock().onPlantGrow(state, parWorld, parBlockPos.down(), parBlockPos);

                    generateTree(parWorld,parBlockPos,minHeight,parRandom);
                }else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
        return false;
    }

    private boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, int minHeight) {
        boolean isSuitableLocation = true;

        for (int checkY = parBlockPos.getY(); checkY <= parBlockPos.getY() + 1 + minHeight; ++checkY) {
            // Handle increasing space towards top of tree
            int extraSpaceNeeded = 1;
            // Handle base location
            if (checkY == parBlockPos.getY()) {
                extraSpaceNeeded = 0;
            }
            // Handle top location
            if (checkY >= parBlockPos.getY() + 1 + minHeight - 2) {
                extraSpaceNeeded = 2;
            }

            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for (int checkX = parBlockPos.getX() - extraSpaceNeeded; checkX <= parBlockPos.getX() + extraSpaceNeeded && isSuitableLocation; ++checkX) {
                for (int checkZ = parBlockPos.getZ() - extraSpaceNeeded; checkZ <= parBlockPos.getZ() + extraSpaceNeeded && isSuitableLocation; ++checkZ) {
                    isSuitableLocation = isReplaceable(parWorld, blockPos.setPos(checkX, checkY, checkZ));
                }
            }
        }

        return isSuitableLocation;

    }




    private void generateTree(World parWorld, BlockPos parBlockPos, int height, Random parRandom)
    {
        int changeX = 0;
        int changeZ = 0;

        BlockPos blockPos;
        IBlockState state;

        for(int stage = 0;stage <=height;stage++)
        {
             changeX = parRandom.nextInt(2)-1;
             changeZ = parRandom.nextInt(2)-1;

            blockPos = new BlockPos(parBlockPos.getX()+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()+changeZ);
            state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateWood);
            }
            for(int a = -1;a<2;a++){
                 for(int b = -1;b<2;b++){
                     blockPos = new BlockPos(parBlockPos.getX()+changeX+a,parBlockPos.getY()+stage,parBlockPos.getZ()+changeZ+b);
                      state = parWorld.getBlockState(blockPos);

                     if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                         setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
                     }
                  }
            }
            changeX = parRandom.nextInt(2)-1;
            changeZ = parRandom.nextInt(2)-1;
        }
        for(int a = -1;a<2;a++){
            for(int b = -1;b<2;b++){
                blockPos = new BlockPos(parBlockPos.getX()+changeX+a,parBlockPos.getY()+height+1,parBlockPos.getZ()+changeZ+b);
                state = parWorld.getBlockState(blockPos);

                if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                    setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
                }
            }
        }
    }
}

