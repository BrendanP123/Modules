package Brendan.modules.Lib;

import Brendan.modules.Blocks.ModBlocks;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

    public void initConfig(FMLPreInitializationEvent evt)
    {
        Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
        config.load();
        ModBlocks.InfusedRedTorchID = config.getBlock("InfusedRedTorch", "block", 1002).getInt();
        ModBlocks.InfusedGreenTorchID = config.getBlock("InfusedGreenTorch", "block", 1003).getInt();
        ModBlocks.InfusedWhiteTorchID = config.getBlock("InfusedWhiteTorch", "block", 1004).getInt();
        ModBlocks.InfusedPurpleTorchID = config.getBlock("InfusedPurpleTorch", "block", 1005).getInt();
        ModBlocks.InfusedBlueTorchID = config.getBlock("InfusedBlueTorch", "block", 1006).getInt();
        ModBlocks.BlockOreFieldID = config.getBlock("BlockOreField", "block", 1007).getInt();
        ModBlocks.BlockStorageFieldID = config.getBlock("BlockStorageField", "block", 1009).getInt();
        ModBlocks.RefineryID = config.getBlock("Refinery", "block", 1010).getInt();
        ModBlocks.InfuserID = config.getBlock("Infuser", "block", 1011).getInt();
        ModBlocks.SmelterID = config.getBlock("Smelter", "block", 1012).getInt();
        System.out.println("IS THIS WORKING?");
        
        config.save();
    }
	
	
}
