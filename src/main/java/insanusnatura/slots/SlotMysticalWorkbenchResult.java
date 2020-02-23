package insanusnatura.slots;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMysticalWorkbenchResult extends Slot {
    private final EntityPlayer player;
    private int removeCount;

    public SlotMysticalWorkbenchResult(EntityPlayer player, IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
        this.player = player;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
        this.onCrafting(stack);
        this.onTake(thePlayer, stack);
        return stack;
    }

    @Override
    public ItemStack decrStackSize(int amount) {
        if(this.getHasStack()) this.removeCount += Math.min(amount, this.getStack().getCount());
        return super.decrStackSize(amount);
    }
}
