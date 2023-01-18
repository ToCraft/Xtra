package tocraft.xtra;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class XEventHandler {
	   
	   @SubscribeEvent(priority = EventPriority.HIGHEST)
	   public void livingDeath(LivingDeathEvent event){
		   if (event.entity instanceof EntityPlayer)
	       {
			   FMLLog.info("[To_Craft] Xtra: dropping playerFlesh");
	           event.entity.dropItem(XRegistry.potionOfManifiedVictory, 1);
	       }
	   }
}
