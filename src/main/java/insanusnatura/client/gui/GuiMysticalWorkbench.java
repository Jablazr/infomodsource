package insanusnatura.client.gui;

import insanusnatura.containers.ContainerMysticalWorkbench;
import insanusnatura.tileentities.TileEntityMysticalWorkbench;
import insanusnatura.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiMysticalWorkbench extends GuiContainer {
    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/gui_mystical_workbench.png");
    private final InventoryPlayer inventoryPlayer;
    private final TileEntityMysticalWorkbench tileEntity;

    public GuiMysticalWorkbench(InventoryPlayer inventoryPlayer, TileEntityMysticalWorkbench tileEntity) {
        super(new ContainerMysticalWorkbench(inventoryPlayer, tileEntity));
        this.inventoryPlayer = inventoryPlayer;
        this.tileEntity = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tileName = this.tileEntity.getDisplayName().getUnformattedComponentText();
        this.fontRenderer.drawString(tileName, 6, 6, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}
