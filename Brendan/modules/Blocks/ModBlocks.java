package Brendan.modules.Blocks;

import Brendan.modules.Crafting.BlockCrafting;
import Brendan.modules.Crafting.ItemCrafting;
import Brendan.modules.Inventory.GuiHandler;
import Brendan.modules.Inventory.TileEntityInfuser;
import Brendan.modules.Inventory.TileEntityRefinery;
import Brendan.modules.Inventory.TileEntitySmelter;
import Brendan.modules.Items.InfusedCoal;
import Brendan.modules.Items.ItemBlockOre;
import Brendan.modules.Items.ItemBlockStorage;
import Brendan.modules.Items.ItemFancyBlock;
import Brendan.modules.Items.ItemRubyOre;
import Brendan.modules.Lib.RegistryUtils;
import Brendan.modules.Lib.WorldGenerator;
import Brendan.modules.util.GeneralUtil;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

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
	public static Block AlchemyTable;
	public static GuiHandler guiHandler = new GuiHandler();
	
	
	
	public static void initialize() {
		
		RefineryIdle = new Refinery(1009, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		RefineryActive = new Refinery(1012, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);		
		InfuserIdle = new Infuser(1010, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		InfuserActive = new Infuser(1013, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		SmelterIdle = new BlockSmelter(1011, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		SmelterActive = new BlockSmelter(1014, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep);
		
		BlockOreField = new BlockOre(700, "BlockOre", "BlockOre");
		BlockStorageField = new BlockStorage(701, "MetalStorage", "MetalStorage");
		InfusedRedTorch = new BlockTorchRed(702).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedGreenTorch = new BlockTorchGreen(703).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedWhiteTorch = new BlockTorchWhite(704).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedPurpleTorch = new BlockTorchPurple(705).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedBlueTorch = new BlockTorchBlue(706).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		
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
		
		for (int meta = 0; meta < 5; meta++) {
			RegistryUtils.addName(BlockOreField, meta, ItemBlockOre.names[meta]);
		}
		
	}

}
