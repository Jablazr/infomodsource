package insanusnatura.objects.recipes;

import insanusnatura.init.BlockInit;
import insanusnatura.init.ItemInit;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MysticalWorkbenchRecipes {
    private class Node {
        ItemStack instrument;
        ItemStack object;
        ItemStack print;
        ItemStack result;
        public Node(ItemStack instrument, ItemStack object, ItemStack print, ItemStack result) {
            this.instrument = instrument;
            this.object = object;
            this.print = print;
            this.result = result;
        }
    }
    private static final MysticalWorkbenchRecipes INSTANCE = new MysticalWorkbenchRecipes();
    private final List<Node> craftingList = new ArrayList<>();

    public static MysticalWorkbenchRecipes getInstance() {
        return INSTANCE;
    }

    private MysticalWorkbenchRecipes() {
        addMysticalWorkbenchRecipe(new ItemStack(ItemInit.FLUTE), new ItemStack(ItemInit.MAGENTA_FEATHER), new ItemStack(ItemInit.MUSICAL_PRINT), new ItemStack(ItemInit.MYSTICAL_FLUTE));
    }

    public void addMysticalWorkbenchRecipe(ItemStack instrument, ItemStack object, ItemStack print, ItemStack result) {
        if(getMysticalWorkbenchResult(instrument, object, print) != ItemStack.EMPTY) return;
        this.craftingList.add(new Node(instrument, object, print, result));
    }

    public ItemStack getMysticalWorkbenchResult(ItemStack instrument, ItemStack object, ItemStack print) {
        for(int i = 0; i < this.craftingList.size(); i++)
            if(this.craftingList.get(i).instrument == instrument)
                if(this.craftingList.get(i).object == object)
                    if(this.craftingList.get(i).print == print)
                        return this.craftingList.get(i).result;
        return ItemStack.EMPTY;
    }

    public List<Node> getCraftingList() {
        return this.craftingList;
    }
}