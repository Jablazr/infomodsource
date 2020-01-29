package insanusnatura.objects.recipes;

import insanusnatura.init.ItemInit;
import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

public class MysticalWorkbenchRecipes {
    private class RecipeGroup {
        public ItemStack print;
        public ItemStack instrument;
        public ItemStack primary;
        public ItemStack secondary;
        public ItemStack result;

        public RecipeGroup(ItemStack print, ItemStack instrument, ItemStack primary, ItemStack secondary,
                ItemStack result) {
            this.print = print;
            this.instrument = instrument;
            this.primary = primary;
            this.secondary = secondary;
            this.result = result;
        }
    }

    private static final MysticalWorkbenchRecipes INSTANCE = new MysticalWorkbenchRecipes();
    private final List<RecipeGroup> craftingList = new LinkedList<>();

    public static MysticalWorkbenchRecipes getInstance() {
        return INSTANCE;
    }

    private MysticalWorkbenchRecipes() {
        addMysticalWorkbenchRecipe(new ItemStack(ItemInit.MUSICAL_PRINT), new ItemStack(ItemInit.FLUTE),
                new ItemStack(ItemInit.MAGENTA_FEATHER), new ItemStack(ItemInit.VINE_BRACELET),
                new ItemStack(ItemInit.MYSTICAL_FLUTE));
    }

    public ItemStack getMysticalWorkbenchResult(ItemStack print, ItemStack instrument, ItemStack primary,
            ItemStack secondary) {
        for (int index = 0; index < this.craftingList.size(); index++) {
            if (ItemStack.areItemsEqual(this.craftingList.get(index).print, print)
                    && ItemStack.areItemsEqual(this.craftingList.get(index).instrument, instrument)
                    && ItemStack.areItemsEqual(this.craftingList.get(index).primary, primary)
                    && ItemStack.areItemsEqual(this.craftingList.get(index).secondary, secondary)) {
                return this.craftingList.get(index).result;
            }
        }
        return ItemStack.EMPTY;
    }

    public void addMysticalWorkbenchRecipe(ItemStack print, ItemStack instrument, ItemStack primary,
            ItemStack secondary, ItemStack result) {
        if (getMysticalWorkbenchResult(print, instrument, primary, secondary) == ItemStack.EMPTY) {
            this.craftingList.add(new RecipeGroup(print, instrument, primary, secondary, result));
        }
    }

    public List<RecipeGroup> getCraftingList() {
        return this.craftingList;
    }

    public ItemStack getCraftingListResultByIndex(int index) {
        return this.craftingList.get(index).result;
    }

    public ItemStack getCraftingListInstrumentByIndex(int index) {
        return this.craftingList.get(index).instrument;
    }

    public ItemStack getCraftingListPrimaryByIndex(int index) {
        return this.craftingList.get(index).primary;
    }

    public ItemStack getCraftingListSecondaryByIndex(int index) {
        return this.craftingList.get(index).secondary;
    }

    public ItemStack getCraftingListPrintByIndex(int index) {
        return this.craftingList.get(index).print;
    }
}