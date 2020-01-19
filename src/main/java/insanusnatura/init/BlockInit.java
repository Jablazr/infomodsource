package insanusnatura.init;

import insanusnatura.objects.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block MAGICAL_BLOCK = new BaseBlock("magical_block", Material.PORTAL);
    public static final MysticDirt MYSTIC_DIRT = new MysticDirt();
    public static final MysticGrass MYSTIC_GRASS = new MysticGrass();
    public static final MysticStone MYSTIC_STONE = new MysticStone();
    public static final MysticCobblestone MYSTIC_COBBLESTONE = new MysticCobblestone();
    public static final MysticBedrock MYSTIC_BEDROCK = new MysticBedrock();
    public static final MysticalWorkbench MYSTICAL_WORKBENCH = new MysticalWorkbench();
}
