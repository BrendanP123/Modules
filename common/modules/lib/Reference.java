package common.modules.lib;

import java.io.File;

import common.modules.blocks.ModBlocks;
import common.modules.inventory.gui.GuiHandler;
import common.modules.items.ModItems;
import net.minecraftforge.common.Configuration;

/** @author "Kasslim & Brendan"
 ** @credits "Kasslim"
 **/

public class Reference {
	
	private static String category_other = "other";
	//GUI IDS
	public static final int REFINERY = 30;
	public static final int INFUSER = 31;
	public static final int ALCHEMYTABLE = 32;
	public static final int SMELTER = 33;
	public static final String MODID = "Modules";
	public static final String MODName = "Modules";
	public static final String ModVersion = "1.6.4_A";
	public static final String CreativeTabModulesBlocks = "Module Blocks";
	public static final String CreativeTabModulesItems = "Module Items";
	public static final GuiHandler GUIHandler = new GuiHandler();
	
	public static void initializeConfig(){
		Configuration config = new Configuration(new File("config/" + "Modules/" + Reference.MODID + ".cfg"));
		config.load();
		
		//BlockIds
		config.addCustomCategoryComment(Configuration.CATEGORY_BLOCK, "Modules Block ID's (These are All Metadata) ");
        ModBlocks.BlockOreFieldID = config.getBlock(Configuration.CATEGORY_BLOCK, "My-Ores", 1000).getInt();
        ModBlocks.BlockStorageFieldID = config.getBlock(Configuration.CATEGORY_BLOCK, "Storge-Blocks", 1001).getInt();
        ModBlocks.InfusedRedTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "Infused-Red-Torch", 1002).getInt();
        ModBlocks.InfusedGreenTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "Infused-Green-Torch", 1003).getInt();
        ModBlocks.InfusedWhiteTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "Infused-White-Torch", 1004).getInt();
        ModBlocks.InfusedPurpleTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "Infused-Purple-Torch", 1005).getInt();
        ModBlocks.InfusedBlueTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "Infused-Blue-Torch", 1006).getInt();
        ModBlocks.RefineryID = config.getBlock(Configuration.CATEGORY_BLOCK, "Refinery", 1007).getInt();
        ModBlocks.SmelterID = config.getBlock(Configuration.CATEGORY_BLOCK, "Smelter", 1008).getInt();
        
        //ItemIDS
		config.addCustomCategoryComment(Configuration.CATEGORY_ITEM, "Modules Item ID's (These are All Metadata) ");
       // ModItems.ElectrodeFieldID = config.getItem(Configuration.CATEGORY_ITEM, "Electrodes", 10000).getInt();
        ModItems.ExtraItemFieldID = config.getItem(Configuration.CATEGORY_ITEM, "Core-Items", 10001).getInt();
        ModItems.GemFieldID = config.getItem(Configuration.CATEGORY_ITEM, "Gems", 10002).getInt();
        ModItems.InfusedCoalFieldID = config.getItem(Configuration.CATEGORY_ITEM, "Infused-Coal", 10003).getInt();
        ModItems.ItemImpureIngotFieldID = config.getItem(Configuration.CATEGORY_ITEM, "Impure-Ingots", 10004).getInt();
        ModItems.ItemIngotFieldID = config.getItem(Configuration.CATEGORY_ITEM, "My-Ingots", 10005).getInt();
        ModItems.PowerCellEmptyFieldID = config.getItem(Configuration.CATEGORY_ITEM, "Power-Cells", 10006).getInt();
		
		config.save();
		
	}
}
