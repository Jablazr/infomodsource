package insanusnatura.init;

import insanusnatura.objects.blocks.*;
import net.minecraft.block.Block;

import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block MAGICAL_BLOCK = new OreCustom("magical_block");
    public static final Block MAGICAL_DIRT = new DirtCustom("magical_dirt");

    public static final Block MAGICAL_SAPLING = new BlockSaplingMagical("magical_sapling");
    public static final Block MAGICAL_LEAVES = new MagicalLeaves("magical_leaves");
    public static final Block MAGICAL_LOG = new MagicalLog("magical_log");
    public static final Block MAGICAL_PLANK = new MagicalPlanks("magical_planks");

    public static final Block MYSTIC_DIRT = new MysticDirt();
    public static final Block MYSTIC_GRASS = new MysticGrass();
    public static final Block MYSTIC_STONE = new MysticStone();
    public static final Block MYSTIC_COBBLESTONE = new MysticCobblestone();
    public static final Block MYSTIC_BEDROCK = new MysticBedrock();
    public static final Block MYSTICAL_WORKBENCH = new MysticalWorkbench();
}
