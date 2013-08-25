package Brendan.modules.Values;

import java.io.File;

import jcm2606.mods.sorcerycraft.item.main.ItemCog;
import Brendan.modules.Blocks.*;
import Brendan.modules.Crafting.BlockCrafting;
import Brendan.modules.Crafting.ItemCrafting;
import Brendan.modules.Extra.RegistryUtils;
import Brendan.modules.Inventory.GuiHandler;
import Brendan.modules.Items.*;
import Brendan.modules.Lib.ConvertUtil;
import Brendan.modules.Lib.GeneralUtil;
import Brendan.modules.Proxy.ClientProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;



/**
 * Values and other for the world expansion.
 * 
 * @author Sparkst3r
 * @author BrendanP123
 *
 */
public class WorldValues {
	
	public static WorldValues proxy;
	//Ore Based blocks
	public static Block BlockOreField;
	public static Block BlockStorageField;
	public static Item ItemIngotField;
	public static Item ExtraItemField;
	public static Item PowerCellField;
	public static Item PowerCellEmptyField;
	public static Item ItemImpureIngotField;
	public static Item InfusedCoalField;
	public static Block InfusedTorchField;
	public static Block InfusedRedTorch;
    public static Block InfusedGreenTorch;
    public static Block InfusedWhiteTorch;
    public static Block InfusedPurpleTorch;
    public static Block InfusedBlueTorch;
    public static Item ItemWaterWand;
    public static Item ItemFireWand;
    public static Item ItemEarthWand;
    public static Item ItemAirWand;
    public static int blockCustomOreRI = -1;
    public static Block BlockGlowing;
    public static Configuration config;
    public static Block fancyBlock;
	public static GuiHandler guiHandler = new GuiHandler();
	public static int renderIDGlowBrick;
	
	
    public static void initialize() {
    
		ItemIngotField = new ItemIngot(5000);
		ItemImpureIngotField = new ItemImpureIngot(5001);
		ExtraItemField = new ExtraItem(5002);
		PowerCellField = new PowerCell(5003);
		PowerCellEmptyField = new PowerCellEmpty(5004);
		InfusedCoalField = new InfusedCoal(5005);
		ItemWaterWand = new ItemWaterWand(5006);
		BlockOreField = new BlockOre(700);
		BlockStorageField = new BlockStorage(701);
		InfusedRedTorch = (new BlockTorchRed(702, 0).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep));
		InfusedGreenTorch = (new BlockTorchGreen(703, 0)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedWhiteTorch = (new BlockTorchWhite(704, 0)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedPurpleTorch = (new BlockTorchPurple(705, 0)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		InfusedBlueTorch = (new BlockTorchBlue(706, 0)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep);
		fancyBlock = new BlockFancy(707, "fancyBlock", "fancyBlock");
		
		
		addInfoForMeta();
		ItemCrafting.initialise();
		BlockCrafting.initialise();
		
		LanguageRegistry.addName(fancyBlock, "Fancy Block (In Testing)");
		LanguageRegistry.addName(InfusedRedTorch, "Infused Red Torch");
		LanguageRegistry.addName(InfusedGreenTorch, "Infused Green Torch");
		LanguageRegistry.addName(InfusedWhiteTorch, "Infused White Torch");
		LanguageRegistry.addName(InfusedPurpleTorch, "Infused Purple Torch");
		LanguageRegistry.addName(InfusedBlueTorch, "Infused Blue Torch");
		LanguageRegistry.addName(ItemWaterWand, "Water Wand(In Testing)");
		GameRegistry.registerBlock(InfusedRedTorch, "Infused Red Torch");
		GameRegistry.registerBlock(InfusedGreenTorch, "Infused Green Torch");	
		GameRegistry.registerBlock(InfusedWhiteTorch, "Infused White Torch");	
		GameRegistry.registerBlock(InfusedPurpleTorch, "Infused Purple Torch");	
		GameRegistry.registerBlock(InfusedBlueTorch, "Infused Blue Torch");
		GeneralUtil.registerBlock(fancyBlock, BlockFancyItem.class);
		
		//GameRegistry.registerWorldGenerator(new WorldGenerator());
	}
    
    
	
	/**
	 * Adds extra info about meta data blocks/items
	 */
	public static void addInfoForMeta() {
		//Ingot
		for (int meta = 0; meta < 5; meta++) {
			RegistryUtils.addName(ItemIngotField, meta, ItemIngot.names[meta]);
			RegistryUtils.registerOre(ItemIngotField, meta, ItemIngot.types[meta]);
		}
		for (int meta = 0; meta < 5; meta++) {
			RegistryUtils.addName(ItemImpureIngotField, meta, ItemImpureIngot.names[meta]);
			RegistryUtils.registerOre(ItemImpureIngotField, meta, ItemImpureIngot.types[meta]);
		}
		//ExtraItem
		for (int meta = 0; meta < 5; meta++) {
			RegistryUtils.addName(ExtraItemField, meta, ExtraItem.names[meta]);
			RegistryUtils.registerOre(ExtraItemField, meta, ExtraItem.types[meta]);
		}
		//Power Cell
		for (int meta = 0; meta < 2; meta++) {
			RegistryUtils.addName(PowerCellField, meta, PowerCell.names[meta]);
			RegistryUtils.registerOre(PowerCellField, meta, PowerCell.types[meta]);
		}
		//Power Cell Empty
		for (int meta = 0; meta < 2; meta++) {
			RegistryUtils.addName(PowerCellEmptyField, meta, PowerCellEmpty.names[meta]);
			RegistryUtils.registerOre(PowerCellEmptyField, meta, PowerCellEmpty.types[meta]);
		}
		//Infused Coal
				for (int meta = 0; meta < 5; meta++) {
					RegistryUtils.addName(InfusedCoalField, meta, InfusedCoal.names[meta]);
					RegistryUtils.registerOre(InfusedCoalField, meta, InfusedCoal.types[meta]);
				}
		
				
		//Ore Block
		for (int meta = 0; meta < 6; meta++) {
			RegistryUtils.addName(BlockOreField, meta, ItemBlockOre.names[meta]);
		}
		
		//Storage Block
		for (int meta = 0; meta < 5; meta++) {
			RegistryUtils.addName(BlockStorageField, meta, ItemBlockStorage.names[meta]);
			RegistryUtils.registerOre(BlockOreField, meta, ItemBlockStorage.types[meta]);
		}
	}
}
