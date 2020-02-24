package insanusnatura.items;


import insanusnatura.Main;
import insanusnatura.commands.CommandDimensionTeleport;
import insanusnatura.commands.util.Teleport;
import insanusnatura.init.ModItems;
import insanusnatura.init.ModCreativeTabs;
import insanusnatura.init.ModWorldGen;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;

public class MysticalFlute extends Item implements IHasModel, ITickable {

    private boolean inModDim = false;

    public MysticalFlute() {
        setUnlocalizedName("mysticalflute");
        setRegistryName("mysticalflute");
        setCreativeTab(ModCreativeTabs.MOD_TAB);

        ModItems.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public void update() {
        System.out.println("HELLO");
    }
}