package insanusnatura.world.gen;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class WorldGenTreesMagical extends WorldGenAbstractTree {

    private IBlockState blockStateWood = Blocks.LOG.getDefaultState();
    private IBlockState blockStateLeaves = Blocks.LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    private final int minTreeHeight = 10;


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
                    //generateLeaves(parWorld, parBlockPos, minHeight, parRandom);
                    //generateTrunk(parWorld, parBlockPos, minHeight);
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

    private void generateTrunk(World parWorld, BlockPos parBlockPos, int minHeight) {
        for (int height = 0; height < minHeight; ++height) {
            BlockPos upN = parBlockPos.up(height);
            IBlockState state = parWorld.getBlockState(upN);

            if (state.getBlock().isAir(state, parWorld, upN) || state.getBlock().isLeaves(state, parWorld, upN)) {
                setBlockAndNotifyAdequately(parWorld, parBlockPos.up(height), blockStateWood.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
            }
        }
    }

    private void generateLeaves(World parWorld, BlockPos parBlockPos, int height, Random parRandom) {
        for (int foliageY = parBlockPos.getY() - 3 + height; foliageY <= parBlockPos.getY() + height; ++foliageY) {
            int foliageLayer = foliageY - (parBlockPos.getY() + height);
            int foliageLayerRadius = 0;

            if (foliageY==parBlockPos.getY()+ height)
            {
                 foliageLayerRadius = 1;
            }
            if (foliageY==parBlockPos.getY()+ height-1)
            {
                 foliageLayerRadius = 3;
            }if (foliageY==parBlockPos.getY()+ height-2)
            {
                 foliageLayerRadius = 4;
                 int lastFoliageLayerRadius = 4;
            }



            for (int foliageX = parBlockPos.getX() - foliageLayerRadius; foliageX <= parBlockPos.getX() + foliageLayerRadius; ++foliageX) {
                int foliageRelativeX = foliageX - parBlockPos.getX();

                for (int foliageZ = parBlockPos.getZ() - foliageLayerRadius; foliageZ <= parBlockPos.getZ() + foliageLayerRadius; ++foliageZ) {
                    int foliageRelativeZ = foliageZ - parBlockPos.getZ();

                    // Fill in layer with some randomness
                    if (Math.abs(foliageRelativeX) != foliageLayerRadius || Math.abs(foliageRelativeZ) != foliageLayerRadius || parRandom.nextInt(2) != 0 && foliageLayer != 0) {
                        BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
                        IBlockState state = parWorld.getBlockState(blockPos);

                        if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                            setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
                        }
                    }
                }
            }
        }
        //////
        int place = (int) ((Math.random()*4)-2);

                int startY = parBlockPos.getY() + height - 3;
                int randHeight = (int) (Math.random()*+5);

        for(int i = startY;i>startY-randHeight;i--){
            BlockPos blockPos = new BlockPos(parBlockPos.getX()+4,i,parBlockPos.getZ()+place);
            IBlockState state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }
        }





    }


    private void generateTree(World parWorld, BlockPos parBlockPos, int height, Random parRandom)
    {
        int changeX = 0;
        int changeZ = 0;

        for(int stage = 0;stage <height;stage++)
        {
             changeX = parRandom.nextInt(2)-1;
             changeZ = parRandom.nextInt(2)-1;


            BlockPos blockPos = new BlockPos(parBlockPos.getX()+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()+changeZ);
            IBlockState state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateWood);
            }

            blockPos = new BlockPos(parBlockPos.getX()+1+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()+changeZ);
            state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }

            blockPos = new BlockPos(parBlockPos.getX()+1+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()+1+changeZ);
            state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }

            blockPos = new BlockPos(parBlockPos.getX()+1+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()-1+changeZ);
            state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }

            blockPos = new BlockPos(parBlockPos.getX()+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()+1+changeZ);
            state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }

            blockPos = new BlockPos(parBlockPos.getX()+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()-1+changeZ);
            state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }

            blockPos = new BlockPos(parBlockPos.getX()-1+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()+1+changeZ);
            state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }

            blockPos = new BlockPos(parBlockPos.getX()-1+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()-1+changeZ);
            state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }

            blockPos = new BlockPos(parBlockPos.getX()-1+changeX,parBlockPos.getY()+stage,parBlockPos.getZ()+changeZ);
            state = parWorld.getBlockState(blockPos);

            if (state.getBlock().isAir(state, parWorld, blockPos) || state.getBlock().isLeaves(state, parWorld, blockPos)) {
                setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }

            changeX = parRandom.nextInt(2)-1;
            changeZ = parRandom.nextInt(2)-1;

        }
    }
}
