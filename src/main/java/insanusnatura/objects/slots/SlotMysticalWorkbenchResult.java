package insanusnatura.objects.slots;

import insanusnatura.objects.tileentities.TileEntityMysticalWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMysticalWorkbenchResult extends Slot {
    private TileEntityMysticalWorkbench tileEntity;

    public SlotMysticalWorkbenchResult(TileEntityMysticalWorkbench tileEntity, IInventory inventoryIn, int index,
            int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
        this.tileEntity = tileEntity;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
        tileEntity.inventory.get(0).shrink(1);
        tileEntity.inventory.get(1).shrink(1);
        tileEntity.inventory.get(2).shrink(1);
        tileEntity.inventory.get(3).shrink(1);
        this.onSlotChanged();
        return stack;
    }
}
