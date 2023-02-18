package tocraft.xtra;

import java.util.List;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import tocraft.xtra.items.PotionOfManifiedVictory;

public class XEventHandler {
	   
	   @SubscribeEvent(priority = EventPriority.LOWEST)
	   public void livingDeath(LivingDeathEvent event){
		   if (event.entity instanceof EntityPlayer)
	       {
			   PotionOfManifiedVictory victoryPotion = (PotionOfManifiedVictory)XRegistry.potionOfManifiedVictory;
			   String playerName = ((EntityPlayer)event.entity).getDisplayName();		   
			   ItemStack victoryPotionStack = new ItemStack(victoryPotion);
			   
	           List tooltip = victoryPotionStack.getTooltip(Minecraft.getMinecraft().thePlayer, false);
	           victoryPotion.setPlayerName(victoryPotionStack, playerName);
	           victoryPotion.addInformation(victoryPotionStack, Minecraft.getMinecraft().thePlayer, tooltip, false);
	           
			   FMLLog.warning("[To_Craft] Xtra: " + playerName + " died and dropped Potion of Manified Victory with " + victoryPotionStack.getTooltip(Minecraft.getMinecraft().thePlayer, false));
	           
	           event.entity.entityDropItem(victoryPotionStack, 1);
	       }
	   }
}
