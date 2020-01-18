package insanusnatura.objects.blocks;

import insanusnatura.Main;
import insanusnatura.init.BlockInit;
import insanusnatura.init.ItemInit;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class MysticCobblestone extends Block implements IHasModel {
    public MysticCobblestone() {
        super(Material.ROCK);
        setRegistryName("mysticcobblestone");
        setUnlocalizedName("mysticcobblestone");
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 1);
        setHardness(2F);
        setResistance(30F);
        setLightLevel(0F);
        setLightOpacity(0);
        setCreativeTab(Main.tab);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
