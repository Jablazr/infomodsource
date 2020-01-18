package insanusnatura.world.gen;

import insanusnatura.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenCustomOres implements IWorldGenerator {

    private WorldGenerator ore_magical;

    public WorldGenCustomOres()
    {
        ore_magical = new WorldGenMinable(BlockInit.MAGICAL_BLOCK.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimension())
        {
            case 0:
                runGenerator(ore_magical, world, random, chunkX, chunkZ, 90, 0, 100);

                break;
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
    {
        if(minHeight>maxHeight || minHeight<0 || maxHeight>256) throw new IllegalArgumentException("Ore generated out of bounds");
        int heightDiff = maxHeight - minHeight + 1;

        for(int i = 0;i<chance;i++)
        {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            if(world.getBiome(new BlockPos(x,y,z))==Biome.getBiome(2)){
                gen.generate(world,rand,new BlockPos(x,y,z));
            }



        }
    }
}
