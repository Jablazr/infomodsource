package insanusnatura.trees;

import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class hangingLeavesTree {
    private void generateTrunk(World parWorld, BlockPos parBlockPos, int minHeight) {
        for (int height = 0; height < minHeight; ++height) {
            BlockPos upN = parBlockPos.up(height);
            IBlockState state = parWorld.getBlockState(upN);

            if (state.getBlock().isAir(state, parWorld, upN) || state.getBlock().isLeaves(state, parWorld, upN)) {
                //setBlockAndNotifyAdequately(parWorld, parBlockPos.up(height), blockStateWood.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
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
                            //setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
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
                //setBlockAndNotifyAdequately(parWorld, blockPos, blockStateLeaves);
            }
        }
    }
}
