package insanusnatura.blocks;

import insanusnatura.Main;
import insanusnatura.init.ModBlocks;
import insanusnatura.init.ModItems;
import insanusnatura.init.ModCreativeTabs;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class MysticBedrock extends Block implements IHasModel {
    public MysticBedrock() {
        super(Material.ROCK);
        setRegistryName("mysticbedrock");
        setUnlocalizedName("mysticbedrock");
        setSoundType(SoundType.GLASS);
        setHardness(10000F);
        setResistance(10000F);
        setLightLevel(0F);
        setLightOpacity(0);
        setCreativeTab(ModCreativeTabs.MOD_TAB);
        setBlockUnbreakable();

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return false;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
