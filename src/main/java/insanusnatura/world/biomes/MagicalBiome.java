package insanusnatura.world.biomes;

import insanusnatura.init.BlockInit;
import insanusnatura.world.gen.BiomeDecoratorMagical;
import insanusnatura.world.gen.WorldGenTreesMagical;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.List;
import java.util.Random;

public class MagicalBiome extends Biome {

    protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
    public static final IBlockState DIRT = BlockInit.MAGICAL_DIRT.getDefaultState();
    public static final IBlockState GRASS = BlockInit.MAGICAL_GRASS.getDefaultState();

    protected static final WorldGenAbstractTree TREE = new WorldGenTreesMagical(false);

    public MagicalBiome() {

        super(new BiomeProperties("Magical Mountains")
                .setBaseHeight(0.4F)
                .setHeightVariation(1.0F)
                .setRainDisabled()
                .setTemperature(1.0F)
                .setWaterColor(12714239)
        );

        topBlock = BlockInit.MAGICAL_GRASS.getDefaultState();
        fillerBlock = BlockInit.MAGICAL_DIRT.getDefaultState();

        setSpawnables();
        addFlowers();

        this.decorator.dirtGen = new WorldGenMinable(Blocks.DIRT.getDefaultState(), 10);
        this.decorator.gravelOreGen = new WorldGenMinable(Blocks.GRAVEL.getDefaultState(), 17);
        this.decorator.graniteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), 5);
        this.decorator.dioriteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), 5);
        this.decorator.andesiteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), 5);
        this.decorator.coalGen = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), 10);
        this.decorator.ironGen = new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), 7);
        this.decorator.goldGen = new WorldGenMinable(Blocks.GOLD_ORE.getDefaultState(), 4);
        this.decorator.redstoneGen = new WorldGenMinable(Blocks.REDSTONE_ORE.getDefaultState(), 12);
        this.decorator.diamondGen = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), 8);
        this.decorator.lapisGen = new WorldGenMinable(Blocks.LAPIS_ORE.getDefaultState(), 7);

        this.decorator.waterlilyPerChunk = 0;
        this.decorator.treesPerChunk = 5;
        this.decorator.extraTreeChance = 0.1F;
        this.decorator.flowersPerChunk = 0;
        this.decorator.grassPerChunk = 0;
        this.decorator.deadBushPerChunk = 0;
        this.decorator.mushroomsPerChunk = 0;
        this.decorator.reedsPerChunk = 0;
        this.decorator.cactiPerChunk = 0;
        this.decorator.gravelPatchesPerChunk = 1;
        this.decorator.sandPatchesPerChunk = 0;
        this.decorator.clayPerChunk = 0;
        this.decorator.bigMushroomsPerChunk = 0;
        this.decorator.generateFalls = true;


    }





    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return TREE;
    }

    private void addFlowers() {
        flowers.clear();
    }

    private void setSpawnables() {
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCaveCreatureList.clear();
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 12, 4, 4));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 10, 4, 4));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityCow.class, 8, 4, 4));
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySpider.class, 100, 4, 4));
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 95, 4, 4));
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 5, 1, 1));
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCreeper.class, 100, 4, 4));
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySlime.class, 100, 4, 4));
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEnderman.class, 10, 1, 4));
        spawnableMonsterList.add(new Biome.SpawnListEntry(EntityWitch.class, 5, 1, 1));
        spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntitySquid.class, 10, 4, 4));
        spawnableCaveCreatureList.add(new Biome.SpawnListEntry(EntityBat.class, 10, 8, 8));
    }

   /* @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        int seaLevel = worldIn.getSeaLevel();
        IBlockState surfaceBlock = topBlock;
        IBlockState mainBlock = fillerBlock;
        int j = -1;
        int noise = (int) (noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int chunkX = x & 15;
        int chunkZ = z & 15;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int primerY = 255; primerY >= 0; --primerY) {
            // lay down bedrock layer
            if (primerY <= rand.nextInt(5)) {
                chunkPrimerIn.setBlockState(chunkX, primerY, chunkZ, BEDROCK);
            } else {
                IBlockState blockAtPosition = chunkPrimerIn.getBlockState(chunkX, primerY, chunkZ);

                if (blockAtPosition.getMaterial() == Material.AIR) {
                    j = -1;
                } else if (blockAtPosition.getBlock() == fillerBlock) {
                    if (j == -1) {
                        // create area for ocean
                        if (noise <= 0) {
                            surfaceBlock = AIR;
                            mainBlock = fillerBlock;
                        }
                        // handle near sea level
                        else if (primerY >= seaLevel - 4 && primerY <= seaLevel + 1) {
                            surfaceBlock = topBlock;
                            mainBlock = fillerBlock;
                        }

                        // area exposed to air will be ocean
                        if (primerY < seaLevel && (surfaceBlock == null || surfaceBlock.getMaterial() == Material.AIR)) {
                            if (getTemperature(pos.setPos(x, primerY, z)) < 0.15F) {
                                surfaceBlock = ICE;
                            } else {
                                surfaceBlock = WATER;
                            }
                        }

                        j = noise;

                        if (primerY >= seaLevel - 1) {
                            chunkPrimerIn.setBlockState(chunkX, primerY, chunkZ, surfaceBlock);
                        }
                        // fill in ocean bottom
                        else if (primerY < seaLevel - 7 - noise) {
                            surfaceBlock = AIR;
                            mainBlock = fillerBlock;
                            chunkPrimerIn.setBlockState(chunkX, primerY, chunkZ, fillerBlock);
                        } else {
                            chunkPrimerIn.setBlockState(chunkX, primerY, chunkZ, mainBlock);
                        }
                    } else if (j > 0) // fill in terrain with main block
                    {
                        --j;
                        chunkPrimerIn.setBlockState(chunkX, primerY, chunkZ, mainBlock);
                    }
                }
            }
        }
    }*/

   
}
