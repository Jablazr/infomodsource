package insanusnatura.init;

import insanusnatura.blocks.*;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block MAGICAL_BLOCK = new OreCustom("magical_block");
    public static final Block MAGICAL_DIRT = new DirtCustom("magical_dirt");
    public static final Block MAGICAL_GRASS = new MagicalGrass("magical_grass");
    public static final Block MAGICAL_STONE = new DirtCustom("magical_stone");
    public static final Block MAGICAL_COBBLESTONE = new DirtCustom("magical_cobblestone");

    public static final Block MAGICAL_SAPLING = new BlockSaplingMagical("magical_sapling");
    public static final Block MAGICAL_LEAVES = new MagicalLeaves("magical_leaves");
    public static final Block MAGICAL_LOG = new MagicalLog("magical_log");
    public static final Block MAGICAL_PLANK = new MagicalPlanks("magical_planks");

    public static final Block SHINY_ORE = new ShinyOre("shiny_ore");

    public static final MysticDirt MYSTIC_DIRT = new MysticDirt();
    public static final MysticGrass MYSTIC_GRASS = new MysticGrass();
    public static final MysticStone MYSTIC_STONE = new MysticStone();
    public static final MysticCobblestone MYSTIC_COBBLESTONE = new MysticCobblestone();
    public static final MysticalWorkbench MYSTICAL_WORKBENCH = new MysticalWorkbench();
}
