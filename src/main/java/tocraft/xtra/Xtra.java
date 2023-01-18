package tocraft.xtra;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(
   modid = "xtra",
   version = "Version 1.0",
   name = "Xtra",
   dependencies = "before:lotr"
)

public class Xtra {
	
	public boolean foundLotRMod = false;
	
   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
		/*
		 * Tests, if the LotR-mod is present
		 */
		for (ModContainer modcontainer : Loader.instance().getModList())
		{				
			if (modcontainer.getModId().equals("lotr"))
			{					
				foundLotRMod = true;
				FMLLog.info("[To_Craft] Xtra: found LoTR-Mod");
			}
		}
		if (!foundLotRMod) FMLLog.info("[To_Craft] Xtra: LoTR-Mod wasn't found.");
		
		MinecraftForge.EVENT_BUS.register(new XEventHandler());
	    FMLLog.info("[To_Craft] Xtra: Registered XEventHandler");
		
		if (foundLotRMod) {
		      XWaypoint.setupWaypoints();
		      FMLLog.info("[To_Craft] Xtra: Registered Xtra Waypoints");
		}
      XRegistry.registerItems();
      FMLLog.info("[To_Craft] Xtra: Registered Items");
   }
   
   @EventHandler
   public void postInit(FMLPostInitializationEvent event) {


   }
}
