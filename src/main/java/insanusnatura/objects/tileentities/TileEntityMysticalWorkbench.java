package insanusnatura.objects.tileentities;

import insanusnatura.init.ItemInit;
import insanusnatura.objects.blocks.MysticalWorkbench;
import insanusnatura.objects.recipes.MysticalWorkbenchRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

public class TileEntityMysticalWorkbench extends TileEntity implements IInventory, ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
    private String customName;

    @Override
    public int getSizeInventory() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack stack : this.inventory) {
            if(!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.inventory.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemStack = this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack);
        this.inventory.set(index, stack);

        if(stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if(index == 3) return false;
        else return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) { }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.mysticalworkbench";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getGuiID() {
        return "insanusnatura:mysticalworkbench";
    }

    private boolean canCraft() {
        if(MysticalWorkbenchRecipes.getInstance()
                .getMysticalWorkbenchResult(this.inventory.get(0), this.inventory.get(1), this.inventory.get(2)) != ItemStack.EMPTY) {
            return true;
        }
        return false;
    }

    public void craftItem() {
        if(this.inventory.get(3).isEmpty()) {
            this.inventory.set(3, MysticalWorkbenchRecipes.getInstance()
                    .getMysticalWorkbenchResult(this.inventory.get(0), this.inventory.get(1), this.inventory.get(2)));
        }
        this.inventory.get(0).shrink(1);
        this.inventory.get(1).shrink(1);
        this.inventory.get(2).shrink(1);
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
    }

    @Override
    public void update() {
        if(!this.world.isRemote) {
            if(this.canCraft()) {
                this.craftItem();
            }
        }
    }
}
