package insanusnatura.util.handlers;

import insanusnatura.Main;
import insanusnatura.init.BiomeInit;
import insanusnatura.init.BlockInit;
import insanusnatura.init.DimensionInit;
import insanusnatura.init.ItemInit;
import insanusnatura.util.interfaces.IHasModel;
import insanusnatura.world.gen.MagicalTreeGen;
import insanusnatura.world.gen.WorldGenCustomOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
        TileEntityHandler.registerTileEntities();
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(ModelRegistryEvent event) {
        for(Item item : ItemInit.ITEMS)
            if(item instanceof IHasModel)
                ((IHasModel)item).registerModels();

        for(Block block : BlockInit.BLOCKS)
            if(block instanceof IHasModel)
               ((IHasModel)block).registerModels();
    }

    public static void preInitRegistries() {
        DimensionInit.registerDimensions();

    }

    public static void initRegistries() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }

    public static void postInitRegistries() {

    }

    public static void otherRegistries()
    {
        GameRegistry.registerWorldGenerator(new MagicalTreeGen(),0);
        BiomeInit.registerBiomes();
        GameRegistry.registerWorldGenerator(new WorldGenCustomOres(),0);
    }
}
