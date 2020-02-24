package insanusnatura.items;

import insanusnatura.Main;
import insanusnatura.commands.util.Teleport;
import insanusnatura.init.ModCreativeTabs;
import insanusnatura.init.ModItems;
import insanusnatura.init.ModWorldGen;
import insanusnatura.util.interfaces.IHasModel;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class MysticalFlute extends Item implements IHasModel {
    private int initialCooldown = 100;
    private int cooldown = initialCooldown;
    private boolean charged = false;

    public MysticalFlute() {
        setUnlocalizedName("mysticalflute");
        setRegistryName("mysticalflute");
        setCreativeTab(ModCreativeTabs.MOD_TAB);

        maxStackSize = 1;
        setMaxDamage(5);

        ModItems.ITEMS.add(this);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        // if player in overworld, tp to insanus natura and vice versa
        // only works if item is charged
        if (charged) {
            if (playerIn.dimension == 0) {
                Teleport.teleportToDimension(playerIn, ModWorldGen.INSANUSNATURA_DIM_ID, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
            } else if (playerIn.dimension == ModWorldGen.INSANUSNATURA_DIM_ID) {
                Teleport.teleportToDimension(playerIn, 0, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
            }
        }
        // use charge if rightclicked
        charged = false;
        // reset cooldown
        cooldown = initialCooldown;
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        // 2 states, is holding and is not holding
        if (isSelected && entityIn instanceof EntityPlayer) {
            // decrease cooldown if greater than 0
            if (cooldown > 0) {
                cooldown--;
            } else {
                charged = true;
            }
            // give glow if charged
            if (charged) {
                if (!stack.isItemEnchanted())
                    stack.addEnchantment(Enchantment.getEnchantmentByID(-1), 0);
            } else {
                // remove enchantments if not charged
                if (stack.getTagCompound() != null)
                    if (stack.getTagCompound().hasKey("ench"))
                        stack.getTagCompound().removeTag("ench");
            }
            // set durability in relation to cooldown remaining
            setDamage(stack, cooldown / 20);
        } else {
            // reset cooldown
            cooldown = initialCooldown;
            // set durability to full
            setDamage(stack, 0);
            // remove enchantments if any
            if (stack.getTagCompound() != null)
                if (stack.getTagCompound().hasKey("ench"))
                    stack.getTagCompound().removeTag("ench");
            // set charged to false
            charged = false;
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}