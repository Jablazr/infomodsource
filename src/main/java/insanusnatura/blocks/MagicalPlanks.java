package insanusnatura.blocks;

import insanusnatura.Main;
import insanusnatura.init.ModBlocks;
import insanusnatura.init.ModItems;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class MagicalPlanks extends Block implements IHasModel {
    public MagicalPlanks(String name) {
        super(Material.WOOD);

        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.WOOD);
        setHarvestLevel("axe", 0);
        setHardness(2F);
        setResistance(15F);
        setLightLevel(0F);
        setLightOpacity(255);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

    }
}
