package insanusnatura.objects.items;


import insanusnatura.Main;
import insanusnatura.commands.util.Teleport;
import insanusnatura.init.DimensionInit;
import insanusnatura.init.ItemInit;
import insanusnatura.util.interfaces.IHasModel;
import insanusnatura.world.dimension.insanusnaturadimension.DimensionInsanusNatura;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class MysticalFlute extends Item implements IHasModel {
    public MysticalFlute() {
        setUnlocalizedName("mysticalflute");
        setRegistryName("mysticalflute");
        setCreativeTab(Main.tab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if(!worldIn.isRemote){
            Teleport.teleportToDimension(playerIn, 66, playerIn.getPosition().getX(),playerIn.getPosition().getY()+5,playerIn.getPosition().getZ());
            return null;
        }
        else return null;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}