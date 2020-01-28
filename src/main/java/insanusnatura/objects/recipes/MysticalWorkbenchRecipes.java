package insanusnatura.objects.recipes;

import insanusnatura.init.ItemInit;
import net.minecraft.item.ItemStack;

import java.util.LinkedList;
import java.util.List;

public class MysticalWorkbenchRecipes {
    private class RecipeGroup {
        public ItemStack instrument;
        public ItemStack object;
        public ItemStack print;
        public ItemStack result;
        public RecipeGroup(ItemStack instrument, ItemStack object, ItemStack print, ItemStack result) {
            this.instrument = instrument;
            this.object = object;
            this.print = print;
            this.result = result;
        }

        public RecipeGroup getNode() {
            return this;
        }
    }

    private static final MysticalWorkbenchRecipes INSTANCE = new MysticalWorkbenchRecipes();
    private final List<RecipeGroup> craftingList = new LinkedList<>();

    public static MysticalWorkbenchRecipes getInstance() {
        return INSTANCE;
    }

    private MysticalWorkbenchRecipes() {
        addMysticalWorkbenchRecipe(new ItemStack(ItemInit.FLUTE), new ItemStack(ItemInit.MAGENTA_FEATHER), new ItemStack(ItemInit.MUSICAL_PRINT), new ItemStack(ItemInit.MYSTICAL_FLUTE));
    }

    public ItemStack getMysticalWorkbenchResult(ItemStack instrument, ItemStack object, ItemStack print) {
        for(int index = 0; index < this.craftingList.size(); index++) {
            if (ItemStack.areItemsEqual(this.craftingList.get(index).instrument, instrument) &&
                    ItemStack.areItemsEqual(this.craftingList.get(index).object, object) &&
                    ItemStack.areItemsEqual(this.craftingList.get(index).print, print)) {
                return this.craftingList.get(index).result;
            }
        }
        return ItemStack.EMPTY;
    }

    public void addMysticalWorkbenchRecipe(ItemStack instrument, ItemStack object, ItemStack print, ItemStack result) {
        if(getMysticalWorkbenchResult(instrument, object, print) == ItemStack.EMPTY) {
            this.craftingList.add(new RecipeGroup(instrument, object, print, result));
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

    public ItemStack getCraftingListObjectByIndex(int index) {
        return this.craftingList.get(index).object;
    }

    public ItemStack getCraftingListPrintByIndex(int index) {
        return this.craftingList.get(index).print;
    }
}