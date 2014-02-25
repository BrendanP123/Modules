package common.modules.items;

import common.modules.Modules;
import common.modules.crafting.ItemCrafting;
import common.modules.lib.RegistryUtils;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {
	//Items
	public static Item ItemIngotField;
	public static Item ExtraItemField;
	//public static Item ElectrodeField;
	public static Item PowerCellEmptyField;
	public static Item ItemImpureIngotField;
	public static Item InfusedCoalField;
	public static Item GemField;
	public static Item Testing;
	//Id's
	public static int ItemIngotFieldID;
	public static int ExtraItemFieldID;
	//public static int ElectrodeFieldID;
	public static int PowerCellEmptyFieldID;
	public static int ItemImpureIngotFieldID;
	public static int InfusedCoalFieldID;
	public static int GemFieldID;
	//ItemStacks
    public static ItemStack Ruby;
    public static ItemStack Sapphire;
    
	
	public static void initialize() {
		
		//Items
		ItemIngotField = new ItemIngot(ItemIngotFieldID);
		ItemImpureIngotField = new ItemImpureIngot(ItemImpureIngotFieldID);
		ExtraItemField = new CoreItems(ExtraItemFieldID);
		//ElectrodeField = new Electrode(ElectrodeFieldID);
		PowerCellEmptyField = new PowerCells(PowerCellEmptyFieldID);
		InfusedCoalField = new InfusedCoal(InfusedCoalFieldID);
		GemField = new Gems(GemFieldID);
		Testing = new ItemTestItem(10234);
		
		//Itemstacks
	    Ruby = new ItemStack(ModItems.GemField, 1, 0);
	    Sapphire = new ItemStack(ModItems.GemField, 1, 1);
		addInfoForMeta();
		recipes();
	}
	 public static void recipes() {
		 //Sheet recipe
		 GameRegistry.addRecipe(new ItemStack(ExtraItemField, 1, 5),
				 "AIA", "IWI", "AIA", 
				 'I', Item.ingotIron,
				 'W', Item.bucketWater
				 );
		//Filter Sheet recipe
		 GameRegistry.addRecipe(new ItemStack(ExtraItemField, 1, 3),
				 "SGS", "SGS", "WFW", 
				 'G', Item.ingotGold,
				 'W', Block.cloth,
				 'S', Item.silk,
				 'F', (new ItemStack(ExtraItemField, 1, 5)));
		 //Filter recipe
		 GameRegistry.addRecipe(new ItemStack(ExtraItemField, 1, 0),
				 "GAG", "AWA", "GAG", 
				 'G', Item.ingotGold,
				 'W', (new ItemStack(ExtraItemField, 1, 3)),
				 'A', (new ItemStack(ExtraItemField, 1, 5)));
		 //Iron Plating
		 GameRegistry.addRecipe(new ItemStack(ExtraItemField, 1, 1),
				 "III", "GGG", "III", 
				 'G', Item.ingotGold,
				 'I', Item.ingotIron
				 );
		//Stabilising Rod
		 GameRegistry.addRecipe(new ItemStack(ExtraItemField, 1, 2),
				 "NIG", 
				 "IBI", 
				 "GIN", 
				 'G', Item.ingotGold,
				 'B', Item.blazeRod,
				 'I', Item.ingotIron);
	 }
	
    public static void addInfoForMeta() {
    	
		//Ingot
		for (int meta = 0; meta < ItemIngot.types.length; meta++) {
			RegistryUtils.addName(ItemIngotField, meta, ItemIngot.names[meta]);
			RegistryUtils.registerOre(ItemIngotField, meta, ItemIngot.types[meta]);
		}
		
		//Impure Ingots
		for (int meta = 0; meta < ItemImpureIngot.types.length; meta++) {
			RegistryUtils.addName(ItemImpureIngotField, meta, ItemImpureIngot.names[meta]);
			RegistryUtils.registerOre(ItemImpureIngotField, meta, ItemImpureIngot.types[meta]);
		}
		
		//ExtraItem
		for (int meta = 0; meta < CoreItems.types.length; meta++) {
			RegistryUtils.addName(ExtraItemField, meta, CoreItems.names[meta]);
			RegistryUtils.registerOre(ExtraItemField, meta, CoreItems.types[meta]);
		}
		
		//Power Cell
		/*
		for (int meta = 0; meta < Electrode.types.length; meta++) {
			RegistryUtils.addName(ElectrodeField, meta, Electrode.names[meta]);
			RegistryUtils.registerOre(ElectrodeField, meta, Electrode.types[meta]);
		}
		*/
		
		//Power Cell Empty
		for (int meta = 0; meta < PowerCells.types.length; meta++) {
			RegistryUtils.addName(PowerCellEmptyField, meta, PowerCells.names[meta]);
			RegistryUtils.registerOre(PowerCellEmptyField, meta, PowerCells.types[meta]);
		}
		
		//Infused Coal
		for (int meta = 0; meta < InfusedCoal.types.length; meta++) {
			RegistryUtils.addName(InfusedCoalField, meta, InfusedCoal.names[meta]);
			RegistryUtils.registerOre(InfusedCoalField, meta, InfusedCoal.types[meta]);
		}
		
		//Gems
		for (int meta = 0; meta < Gems.types.length; meta++) {
			RegistryUtils.addName(GemField, meta, Gems.names[meta]);
			RegistryUtils.registerOre(GemField, meta, Gems.types[meta]);
		}
		//Testing
		for (int meta = 0; meta < ItemTestItem.names.length; meta++) {
			RegistryUtils.addName(Testing, meta, ItemTestItem.names[meta]);
		}
	}

}
