package insanusnatura.init;


import insanusnatura.objects.blocks.BlockSaplingMagical;
import insanusnatura.objects.blocks.DirtCustom;
import insanusnatura.objects.blocks.OreCustom;
import net.minecraft.block.Block;
import insanusnatura.objects.blocks.MysticDirt;




import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();


    public static final Block MAGICAL_BLOCK = new OreCustom("magical_block");
    public static final Block MAGICAL_DIRT = new DirtCustom("magical_dirt");

    public static final Block MAGICAL_SAPLING = new BlockSaplingMagical("magical_sapling");





    public static final MysticDirt MYSTIC_DIRT = new MysticDirt();

}
