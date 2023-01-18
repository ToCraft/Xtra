package tocraft.xtra;

import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraftforge.common.util.EnumHelper;

public class XWaypoint {
   public static LOTRWaypoint Spawn;
   public static LOTRWaypoint Dwaling;
   public static LOTRWaypoint BombadilsHouse;
   public static LOTRWaypoint Withywindle;
   public static LOTRWaypoint GridleyIsland;

/*
 * NOTE:
 * 
 * The coordinates are diffrent to the normal ones.
 * Here's how you calculate them:
 * 
 * X: x/128+809.5
 * 
 * Y: y/128+725.5
 * 
 */
   public static void setupWaypoints() {
	   Dwaling = addWaypoint("Dwaling", LOTRWaypoint.Region.SHIRE, LOTRFaction.HOBBIT, 841.9, 702);
	   BombadilsHouse = addWaypoint("BombadilsHouse", LOTRWaypoint.Region.OLD_FOREST, LOTRFaction.UNALIGNED, 890.4, 743.4);
	   GridleyIsland = addWaypoint("GridleyIsland", LOTRWaypoint.Region.SHIRE, LOTRFaction.HOBBIT, 851.4, 746.3);
   }
   
   
   public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z) {
	      return addWaypoint(name, region, faction, x, z, false);
	   }

	   public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
	      Class[] classArr = new Class[]{LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE};
	      Object[] args = new Object[]{region, faction, x, z, hidden};
	      return (LOTRWaypoint)EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	   }
}
