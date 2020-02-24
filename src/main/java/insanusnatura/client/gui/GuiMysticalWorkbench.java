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
    private static final int xSize = 175;
    private static final int ySize = 178;
    private final InventoryPlayer inventoryPlayer;
    private final TileEntityMysticalWorkbench tileEntity;

    public GuiMysticalWorkbench(InventoryPlayer inventoryPlayer, TileEntityMysticalWorkbench tileEntity) {
        super(new ContainerMysticalWorkbench(inventoryPlayer, tileEntity));
        this.inventoryPlayer = inventoryPlayer;
        this.tileEntity = tileEntity;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tileName = this.tileEntity.getDisplayName().getUnformattedComponentText();
        this.fontRenderer.drawString(tileName, 8, 6, 13027014);
        this.fontRenderer.drawString("Inventory", 8, 85, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, xSize, ySize);
    }
}
