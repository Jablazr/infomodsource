package insanusnatura.mechanics;

import insanusnatura.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

// WIP
public class FloorCraftingRecipes {
    private class RecipeGroup {
        ItemStack[] itemStacks;
        public RecipeGroup(ItemStack[] itemStacks) {
            this.itemStacks = itemStacks;
        }
    }

    private static final FloorCraftingRecipes INSTANCE = new FloorCraftingRecipes();
    private final List<RecipeGroup> craftingList = new LinkedList<>();

    public static FloorCraftingRecipes getInstance() {
        return INSTANCE;
    }

    public FloorCraftingRecipes() {
        addFloorCraftingRecipe(new ItemStack(ItemInit.MUSICAL_PRINT), new ItemStack(ItemInit.BLANK_PRINT), new ItemStack(Item.getItemById(2256)));
    }

    public ItemStack getFloorCraftingResult(ItemStack... itemStacks) {
        boolean flag = true;
        for(int index = 0; index < this.craftingList.size(); index++) {
            if(this.craftingList.get(index).itemStacks.length ==
                    itemStacks.length + 1) {
                for(int jindex = 0; jindex < itemStacks.length; jindex++) {
                    if(ItemStack.areItemsEqual(this.craftingList.get(index).itemStacks[jindex + 1], itemStacks[jindex])) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            } else {
                continue;
            }
            if(flag) {
                return this.craftingList.get(index).itemStacks[0];
            }
        }
        return ItemStack.EMPTY;
    }

    public void addFloorCraftingRecipe(ItemStack... itemStacks) {
        if(getFloorCraftingResult(itemStacks) == ItemStack.EMPTY) {
            this.craftingList.add(new RecipeGroup(itemStacks));
        }
    }
}
