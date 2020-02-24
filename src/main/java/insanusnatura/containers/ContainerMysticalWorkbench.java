package insanusnatura.containers;

import insanusnatura.slots.SlotMysticalWorkbenchResult;
import insanusnatura.tileentities.TileEntityMysticalWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMysticalWorkbench extends Container {
    private int hotbar_slots = 9;
    private int inventory_rows = 3;
    private int inventory_slots_per_row = 9;

    private final TileEntityMysticalWorkbench tileEntity;

    public ContainerMysticalWorkbench(InventoryPlayer inventoryPlayer, TileEntityMysticalWorkbench tileEntity) {
        this.tileEntity = tileEntity;

        // Custom slots
        this.addSlotToContainer(new Slot(tileEntity, 0, 36, 24));
        this.addSlotToContainer(new Slot(tileEntity, 1, 64, 20));
        this.addSlotToContainer(new Slot(tileEntity, 2, 32, 52));
        this.addSlotToContainer(new Slot(tileEntity, 3, 62, 50));
        this.addSlotToContainer(new SlotMysticalWorkbenchResult(tileEntity, tileEntity, 4, 123, 35));

        // Hotbar slots
        for(int x = 0; x < hotbar_slots; x++)
            this.addSlotToContainer(new Slot(inventoryPlayer, x, 8 + x * 18, 155));

        // Inventory slots
        for(int y = 0; y < inventory_rows; y++)
            for(int x = 0; x < inventory_slots_per_row; x++)
                this.addSlotToContainer(new Slot(inventoryPlayer, x + hotbar_slots + y * 9, 8 + x * 18, 97 + y * 18));
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileEntity.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
        if(clickTypeIn == ClickType.QUICK_MOVE){
            return ItemStack.EMPTY;
        } else {
            return super.slotClick(slotId, dragType, clickTypeIn, player);
        }
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        if (!this.tileEntity.getWorld().isRemote)
        {
            this.clearContainer(playerIn, this.tileEntity.getWorld(), this.tileEntity);
        }
    }

    @Override
    protected void clearContainer(EntityPlayer playerIn, World worldIn, IInventory inventoryIn) {
        super.clearContainer(playerIn, worldIn, inventoryIn);
    }
}