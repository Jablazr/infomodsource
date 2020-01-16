package insanusnatura.init;

import insanusnatura.objects.blocks.BaseBlock;
import insanusnatura.objects.blocks.MysticDirt;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block MAGICAL_BLOCK = new BaseBlock("magical_block", Material.PORTAL);
    public static final MysticDirt MYSTIC_DIRT = new MysticDirt();
}
