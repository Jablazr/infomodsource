package insanusnatura.objects.recipes;

import insanusnatura.init.ItemInit;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MysticalWorkbenchRecipes {
    private class RecipeGroup {
        public ItemStack print;
        public ItemStack primary;
        public ItemStack secondary;
        public ItemStack tertiary;
        public ItemStack result;
        public int group;
        public RecipeGroup(ItemStack print, ItemStack primary, ItemStack secondary, ItemStack tertiary, ItemStack result, int group) {
            this.print = print;
            this.primary = primary;
            this.secondary = secondary;
            this.tertiary = tertiary;
            this.result = result;
            this.group = group;
        }
    }

    private static final MysticalWorkbenchRecipes INSTANCE = new MysticalWorkbenchRecipes();
    private final List<RecipeGroup> craftingList = new LinkedList<>();

    public static MysticalWorkbenchRecipes getInstance() {
        return INSTANCE;
    }

    private MysticalWorkbenchRecipes() {
        addMysticalWorkbenchRecipe(new ItemStack(ItemInit.MUSICAL_PRINT), // print
                new ItemStack(ItemInit.FLUTE), // item1
                new ItemStack(ItemInit.MAGENTA_FEATHER), // item2
                new ItemStack(ItemInit.VINE_BRACELET), // item3
                new ItemStack(ItemInit.MYSTICAL_FLUTE), // result
                0); // group + 1
        createShapeless(); // bottom of constructor
    }

    public ItemStack getMysticalWorkbenchResult(ItemStack print, ItemStack primary, ItemStack secondary, ItemStack tertiary) {
        for(int index = 0; index < this.craftingList.size(); index++) {
            if (ItemStack.areItemsEqual(this.craftingList.get(index).print, print) &&
                    ItemStack.areItemsEqual(this.craftingList.get(index).primary, primary) &&
                    ItemStack.areItemsEqual(this.craftingList.get(index).secondary, secondary) &&
                    ItemStack.areItemsEqual(this.craftingList.get(index).tertiary, tertiary)) {
                return this.craftingList.get(index).result;
            }
        }
        return ItemStack.EMPTY;
    }

    public void addMysticalWorkbenchRecipe(ItemStack print, ItemStack primary, ItemStack secondary, ItemStack tertiary, ItemStack result, int group) {
        if(getMysticalWorkbenchResult(print, primary, secondary, tertiary) == ItemStack.EMPTY) {
            this.craftingList.add(new RecipeGroup(print, primary, secondary, tertiary, result, group));
        }
    }

    public void createShapeless() {
        ItemStack print;
        ItemStack primary;
        ItemStack secondary;
        ItemStack tertiary;
        ItemStack result;
        ItemStack temporary;
        int group;
        for(int i = 0; i < getCraftingList().size(); i++) {
            print = getCraftingList().get(i).print;
            primary = getCraftingList().get(i).primary;
            secondary = getCraftingList().get(i).secondary;
            tertiary = getCraftingList().get(i).tertiary;
            result = getCraftingList().get(i).result;
            group = getCraftingList().get(i).group;
            for(int j = 0; j < 2; j++) {
                temporary = primary;
                primary = secondary;
                secondary = temporary;
                addMysticalWorkbenchRecipe(print, primary, secondary, tertiary, result, group);
                temporary = secondary;
                secondary = tertiary;
                tertiary = temporary;
                addMysticalWorkbenchRecipe(print, primary, secondary, tertiary, result, group);
            }
            temporary = primary;
            primary = secondary;
            secondary = temporary;
            addMysticalWorkbenchRecipe(print, primary, secondary, tertiary, result, group);
        }
    }

    public List<RecipeGroup> getCraftingList() {
        return this.craftingList;
    }
}