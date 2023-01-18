package tocraft.xtra;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import tocraft.xtra.items.PotionOfManifiedVictory;

public class XRegistry {
	public static Item potionOfManifiedVictory;
	
	public static void registerItems() {
		potionOfManifiedVictory = new PotionOfManifiedVictory();
		
		registerItem(potionOfManifiedVictory, "PotionOfManifiedVictory");
	}
	
	public static void registerBlock(Block block, String codename) {
		registerBlock(block, codename, ItemBlock.class);
	}

	public static void registerBlock(Block block, String codename, Class<? extends ItemBlock> itemClass) {
		block.setBlockName("xtra:" + codename);
		block.setBlockTextureName("xtra:" + codename);
		GameRegistry.registerBlock(block, itemClass, codename);
	}

	public static void registerItem(Item item, String codename) {
		item.setUnlocalizedName("xtra:" + codename);
		item.setTextureName("xtra:" + codename);
		GameRegistry.registerItem(item, codename);
	}
}
