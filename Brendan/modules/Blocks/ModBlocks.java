package Brendan.modules.Blocks;

import Brendan.modules.Crafting.BlockCrafting;
import Brendan.modules.Crafting.ItemCrafting;
import Brendan.modules.Inventory.GuiHandler;
import Brendan.modules.Inventory.TileEntityInfuser;
import Brendan.modules.Inventory.TileEntityRefinery;
import Brendan.modules.Inventory.TileEntitySmelter;
import Brendan.modules.Items.Electrode;
import Brendan.modules.Items.InfusedCoal;
import Brendan.modules.Items.ItemBlockOre;
import Brendan.modules.Items.ItemBlockStorage;
import Brendan.modules.Items.ModItems;
import Brendan.modules.Lib.RegistryUtils;
import Brendan.modules.Lib.WorldGenerator;
import Brendan.modules.util.GeneralUtil;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

public class ModBlocks {
	
	public static Block InfusedTorchField;
	public static Block InfusedRedTorch;
    public static Block InfusedGreenTorch;
    public static Block InfusedWhiteTorch;
    public static Block InfusedPurpleTorch;
    public static Block InfusedBlueTorch;
	public static Block BlockOreField;
	public static Block BlockStorageField;
	public static Block RefineryIdle;
	public static Block RefineryActive;
	public static Block InfuserIdle;
	public static Block InfuserActive;
	public static Block SmelterIdle;
	public static Block SmelterActive;
	public static GuiHandler guiHandler = new GuiHandler();
	
	public static int InfusedRedTorchID;
	public static int InfusedGreenTorchID;
	public static int InfusedWhiteTorchID;
	public static int InfusedPurpleTorchID;
	public static int InfusedBlueTorchID;
	public static int BlockOreFieldID;
	public static int BlockStorageFieldID;
	public static int RefineryID;
	public static int InfuserID;
	public static int SmelterID;
	
    static ItemStack RubyOre;
    static ItemStack SapphireOre;
    
	public static void initialize() {
		
		RefineryIdle = new Refinery(RefineryID, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		RefineryActive = new Refinery(1013, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);		
		InfuserIdle = new Infuser(InfuserID, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		InfuserActive = new Infuser(1014, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		SmelterIdle = new BlockSmelter(SmelterID, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		SmelterActive = new BlockSmelter(1015, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		
		BlockOreField = new BlockOre(BlockOreFieldID, "BlockOre", "BlockOre");
		BlockStorageField = new BlockStorage(BlockStorageFieldID, "MetalStorage", "MetalStorage");
		InfusedRedTorch = new BlockTorchRed(InfusedRedTorchID).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedGreenTorch = new BlockTorchGreen(InfusedGreenTorchID).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedWhiteTorch = new BlockTorchWhite(InfusedWhiteTorchID).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedPurpleTorch = new BlockTorchPurple(InfusedPurpleTorchID).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedBlueTorch = new BlockTorchBlue(InfusedBlueTorchID).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		
	    RubyOre = new ItemStack(ModBlocks.BlockOreField, 1, 5);
	    SapphireOre = new ItemStack(ModBlocks.BlockOreField, 1, 6);
		
		//Registering Names
		NetworkRegistry.instance().registerGuiHandler(null, guiHandler);
		LanguageRegistry.addName(InfusedRedTorch, "Redstone Dust Torch");
		LanguageRegistry.addName(InfusedGreenTorch, "Slimy Torch");
		LanguageRegistry.addName(InfusedWhiteTorch, "Boneless Torch");
		LanguageRegistry.addName(InfusedPurpleTorch, "Magic Torch");
		LanguageRegistry.addName(InfusedBlueTorch, "Water Torch");
		//LanguageRegistry.addName(BlockOreField, "Ore Block");
        LanguageRegistry.addName(RefineryIdle, "Refinery");		
        LanguageRegistry.addName(InfuserIdle, "Infuser");		
        LanguageRegistry.addName(SmelterIdle, "Smelter");
        
        
		//Registering Blocks
    	GameRegistry.registerTileEntity(TileEntityRefinery.class,"tileEntityRefinery");
    	GameRegistry.registerTileEntity(TileEntitySmelter.class,"tileEntitySmelter");
    	GameRegistry.registerTileEntity(TileEntityInfuser.class,"tileEntityInfuser");
        GameRegistry.registerWorldGenerator(new WorldGenerator());
		GameRegistry.registerBlock(InfusedRedTorch, "Infused Red Torch");
		GameRegistry.registerBlock(InfusedGreenTorch, "Infused Green Torch");	
		GameRegistry.registerBlock(InfusedWhiteTorch, "Infused White Torch");	
		GameRegistry.registerBlock(InfusedPurpleTorch, "Infused Purple Torch");	
		GameRegistry.registerBlock(InfusedBlueTorch, "Infused Blue Torch");
		GameRegistry.registerBlock(RefineryIdle, "RefineryIdle");
		GameRegistry.registerBlock(InfuserIdle, "InfuserIdle");
    	GameRegistry.registerBlock(SmelterIdle, "SmelterIdle");
		GeneralUtil.registerBlock(BlockStorageField, ItemBlockStorage.class);
		GeneralUtil.registerBlock(BlockOreField, ItemBlockOre.class);
		
		for (int meta = 0; meta < 7; meta++) {
			LanguageRegistry.addName(new ItemStack(BlockOreField, 1, meta), ItemBlockOre.names[meta]);
			LanguageRegistry.addName(new ItemStack(BlockStorageField, 1, meta), ItemBlockStorage.names[meta]);
			RegistryUtils.registerOre(BlockStorageField, meta, ItemBlockStorage.types[meta]);
		}
		
	}

}
