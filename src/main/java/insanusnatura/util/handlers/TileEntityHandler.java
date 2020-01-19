package insanusnatura.util.handlers;

import insanusnatura.objects.tileentities.TileEntityMysticalWorkbench;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityMysticalWorkbench.class, "mysticalworkbench");
    }
}
