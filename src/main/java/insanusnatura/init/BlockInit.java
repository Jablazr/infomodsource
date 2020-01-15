package insanusnatura.init;

import insanusnatura.objects.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block MAGICAL_BLOCK = new BlockBase("magical_block", Material.PORTAL);
}
