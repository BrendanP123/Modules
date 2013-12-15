package Brendan.modules.Items;

import cpw.mods.fml.common.registry.GameRegistry;
import Brendan.modules.Modules;
import Brendan.modules.Blocks.ModBlocks;
import Brendan.modules.Crafting.ItemCrafting;
import Brendan.modules.Lib.RegistryUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems {
	
	public static Item ItemIngotField;
	public static Item ExtraItemField;
	public static Item ElectrodeField;
	public static Item PowerCellEmptyField;
	public static Item ItemImpureIngotField;
	public static Item InfusedCoalField;
	public static Item GemField;
	public static Item stabilisingRod;
	
	public static int ItemIngotFieldID;
	public static int ExtraItemFieldID;
	public static int ElectrodeFieldID;
	public static int PowerCellEmptyFieldID;
	public static int ItemImpureIngotFieldID;
	public static int InfusedCoalFieldID;
	public static int GemFieldID;
	
	
	
    public static ItemStack Ruby;
    public static ItemStack Sapphire;
    public static ItemStack SRod;
    
	
	public static void initialize() {
		
		ItemIngotField = new ItemIngot(ItemIngotFieldID);
		ItemImpureIngotField = new ItemImpureIngot(ItemImpureIngotFieldID);
		ExtraItemField = new ExtraItem(ExtraItemFieldID);
		ElectrodeField = new Electrode(ElectrodeFieldID);
		PowerCellEmptyField = new PowerCellEmpty(PowerCellEmptyFieldID);
		InfusedCoalField = new InfusedCoal(InfusedCoalFieldID);
		GemField = new Gems(GemFieldID);
		stabilisingRod = new stabilisingRod(11100).setFull3D().setCreativeTab(Modules.creativeTabModulesItems);
		
	    Ruby = new ItemStack(ModItems.GemField, 1, 0);
	    Sapphire = new ItemStack(ModItems.GemField, 1, 1);
	    SRod = new ItemStack(ModItems.ExtraItemField, 1, 2);
		
		addInfoForMeta();
		
	}
	
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
			RegistryUtils.addName(ElectrodeField, meta, Electrode.names[meta]);
			RegistryUtils.registerOre(ElectrodeField, meta, Electrode.types[meta]);
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
		
		//Gems
		for (int meta = 0; meta < 2; meta++) {
			RegistryUtils.addName(GemField, meta, Gems.names[meta]);
			RegistryUtils.registerOre(GemField, meta, Gems.OreD[meta]);
		}
	}

}
