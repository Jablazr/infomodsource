package insanusnatura.objects.containers;

import insanusnatura.objects.slots.SlotMysticalWorkbenchResult;
import insanusnatura.objects.tileentities.TileEntityMysticalWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class ContainerMysticalWorkbench extends Container {
    private final TileEntityMysticalWorkbench tileEntity;

    public ContainerMysticalWorkbench(InventoryPlayer inventoryPlayer, TileEntityMysticalWorkbench tileEntity) {
        this.tileEntity = tileEntity;

        this.addSlotToContainer(new Slot(tileEntity, 0, 30, 31));
        this.addSlotToContainer(new Slot(tileEntity, 1, 48, 31));
        this.addSlotToContainer(new Slot(tileEntity, 2, 66, 31));
        this.addSlotToContainer(new SlotMysticalWorkbenchResult(inventoryPlayer.player, tileEntity, 3, 124, 31));

        for(int y = 0; y < 3; y++)
            for(int x = 0; x < 9; x++)
                this.addSlotToContainer(new Slot(inventoryPlayer, x + y * 9 + 9, 8 + x * 18, 72 + y * 18));

        for(int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(inventoryPlayer, x, 8 + x * 18, 130));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileEntity.isUsableByPlayer(playerIn);
    }
}
