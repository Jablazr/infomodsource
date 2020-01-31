package insanusnatura.util.handlers;

import insanusnatura.objects.containers.ContainerMysticalWorkbench;
import insanusnatura.objects.gui.GuiMysticalWorkbench;
import insanusnatura.objects.tileentities.TileEntityMysticalWorkbench;
import insanusnatura.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Reference.GUI_MYSTICAL_WORKBENCH) return new ContainerMysticalWorkbench(player.inventory, (TileEntityMysticalWorkbench) world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Reference.GUI_MYSTICAL_WORKBENCH) return new GuiMysticalWorkbench(player.inventory, (TileEntityMysticalWorkbench) world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

    public static void registerGuis() {}
}
