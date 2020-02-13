package insanusnatura.objects.blocks;

import insanusnatura.Main;
import insanusnatura.commands.util.Teleport;
import insanusnatura.init.BlockInit;
import insanusnatura.init.ItemInit;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OreCustom extends Block implements IHasModel {
    public OreCustom(String name){
        super(Material.ROCK);
        setRegistryName(name);
        setUnlocalizedName(name);
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 3);
        setHardness(2F);
        setResistance(3F);
        setLightLevel(0F);
        setLightOpacity(255);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote){
            Teleport.teleportToDimension(playerIn, 66, playerIn.getPosition().getX(),playerIn.getPosition().getY()+5,playerIn.getPosition().getZ());
            return true;
        }else return false;
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
