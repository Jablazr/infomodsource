package insanusnatura.objects.items;

public class MysticalFlute extends Item implements IHasModel {
    public MysticalFlute() {
        setUnlocalizedName("mysticalflute");
        setRegistryName("mysticalflute");
        setCreativeTab(Main.tab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}