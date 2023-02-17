package tocraft.xtra.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import tocraft.xtra.util.ItemNBTHelper;

public class PotionOfManifiedVictory extends ItemFood {
	private static final String playerName = "";

    public PotionOfManifiedVictory() {
		super(10, 10, false);
    }
    
    public void setPlayerName(ItemStack itemStack, String pName) {
    	ItemNBTHelper.setString(itemStack, playerName, pName);
    }
    
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --itemStack.stackSize;
        }
        if (!world.isRemote) {			player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 4800, 4));
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 6000, 0));
			player.addPotionEffect(new PotionEffect(Potion.hunger.id, 25, 1));
        }

        if (!player.capabilities.isCreativeMode) {
            if (itemStack.stackSize <= 0) {
                return new ItemStack(Items.glass_bottle);
            }

            player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        }

        return itemStack;
    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction.drink;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    	player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		return itemStack;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List tooltip, boolean advanced) {
     	tooltip.add(EnumChatFormatting.GOLD + ItemNBTHelper.getString(itemStack, playerName, ""));
    	super.addInformation(itemStack, player, tooltip, advanced);
    }
}