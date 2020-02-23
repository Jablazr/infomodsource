package insanusnatura.blocks;

import insanusnatura.Main;
import insanusnatura.init.ModBlocks;
import insanusnatura.init.ModItems;
//import insanusnatura.containers.MysticalBenchContainer;
import insanusnatura.containers.MysticalBenchContainer;
import insanusnatura.init.ModCreativeTabs;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class MysticalBench extends BlockWorkbench implements IHasModel {
    public MysticalBench() {
        setUnlocalizedName("mysticalbench");
        setRegistryName("mysticalbench");
        setHardness(2.5F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(ModCreativeTabs.MOD_TAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            playerIn.displayGui(new MysticalBench.InterfaceCraftingTable(worldIn, pos));
            return true;
        }
    }

    public static class InterfaceCraftingTable implements IInteractionObject
    {
        private final World world;
        private final BlockPos position;

        public InterfaceCraftingTable(World worldIn, BlockPos pos)
        {
            this.world = worldIn;
            this.position = pos;
        }

        /**
         * Get the name of this object. For players this returns their username
         */
        public String getName()
        {
            return "mysticalbench";
        }

        /**
         * Returns true if this thing is named
         */
        public boolean hasCustomName()
        {
            return false;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public ITextComponent getDisplayName()
        {
            return new TextComponentTranslation(ModBlocks.MYSTICAL_WORKBENCH.getUnlocalizedName() + ".name", new Object[0]);
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new MysticalBenchContainer(playerInventory, this.world, this.position);
        }

        public String getGuiID()
        {
            return "insanusnatura:mysticalbench";
        }
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
