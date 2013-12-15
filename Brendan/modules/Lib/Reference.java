package Brendan.modules.Lib;

import java.io.File;

import Brendan.modules.Blocks.ModBlocks;
import Brendan.modules.Items.ModItems;

import net.minecraftforge.common.Configuration;

/** @author Kasslim & Brendan :D */
public class Reference {
	
	
	public static int START_ID;
	
	private static String category_other = "other";
	
	public static void initializeConfig(){
		Configuration config = new Configuration(new File("config/" + "Modules/" + GlobalValues.MODID + ".cfg"));
		config.load();
		
		config.addCustomCategoryComment(Configuration.CATEGORY_BLOCK, "Modules Item IDs");
        ModBlocks.BlockOreFieldID = config.getBlock(Configuration.CATEGORY_BLOCK, "BlockOreField", 1000).getInt();
        ModBlocks.BlockStorageFieldID = config.getBlock(Configuration.CATEGORY_BLOCK, "BlockStorageField", 1001).getInt();
        ModBlocks.InfusedRedTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "InfusedRedTorch", 1002).getInt();
        ModBlocks.InfusedGreenTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "InfusedGreenTorch", 1003).getInt();
        ModBlocks.InfusedWhiteTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "InfusedWhiteTorch", 1004).getInt();
        ModBlocks.InfusedPurpleTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "InfusedPurpleTorch", 1005).getInt();
        ModBlocks.InfusedBlueTorchID = config.getBlock(Configuration.CATEGORY_BLOCK, "InfusedBlueTorch", 1006).getInt();
        ModBlocks.RefineryID = config.getBlock(Configuration.CATEGORY_BLOCK, "Refinery", 1007).getInt();
        ModBlocks.InfuserID = config.getBlock(Configuration.CATEGORY_BLOCK, "Infuser", 1008).getInt();
        ModBlocks.SmelterID = config.getBlock(Configuration.CATEGORY_BLOCK, "Smelter", 1009).getInt();
        
		config.addCustomCategoryComment(Configuration.CATEGORY_ITEM, "Modules Item IDs");
        ModItems.ElectrodeFieldID = config.getItem(Configuration.CATEGORY_ITEM, "ElectrodeField", 10000).getInt();
        ModItems.ExtraItemFieldID = config.getItem(Configuration.CATEGORY_ITEM, "ExtraItemField", 10001).getInt();
        ModItems.GemFieldID = config.getItem(Configuration.CATEGORY_ITEM, "GemsField", 10002).getInt();
        ModItems.InfusedCoalFieldID = config.getItem(Configuration.CATEGORY_ITEM, "InfusedCoalField", 10003).getInt();
        ModItems.ItemImpureIngotFieldID = config.getItem(Configuration.CATEGORY_ITEM, "ImpureIngotField", 10004).getInt();
        ModItems.ItemIngotFieldID = config.getItem(Configuration.CATEGORY_ITEM, "ItemIngotField", 10005).getInt();
        ModItems.PowerCellEmptyFieldID = config.getItem(Configuration.CATEGORY_ITEM, "PowerCellEmptyField", 10006).getInt();
        
		
		config.save();
		
	}
}
