package Brendan.modules.Items;

import cpw.mods.fml.common.registry.GameRegistry;
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
	
	public static void initialize() {
		
		ItemIngotField = new ItemIngot(5000);
		ItemImpureIngotField = new ItemImpureIngot(5001);
		ExtraItemField = new ExtraItem(5002);
		ElectrodeField = new Electrode(5003);
		PowerCellEmptyField = new PowerCellEmpty(5004);
		InfusedCoalField = new InfusedCoal(5005);
		
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
	}

}
