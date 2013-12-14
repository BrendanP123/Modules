package Brendan.modules.Crafting;

import Brendan.modules.Blocks.ModBlocks;
import Brendan.modules.Items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
/**
 * Simple class for all the block crafting recipes
 * @author Sparkst3r
 *
 */
public class BlockCrafting {
	/**
	 * Initialise the recipes
	 */

	
	public static void initialise() {
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 9, 0), new ItemStack(ModBlocks.BlockStorageField, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 9, 1), new ItemStack(ModBlocks.BlockStorageField, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 9, 2), new ItemStack(ModBlocks.BlockStorageField, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 9, 3), new ItemStack(ModBlocks.BlockStorageField, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 9, 4), new ItemStack(ModBlocks.BlockStorageField, 1, 4));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 0), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotCopper"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 1), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotTin"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 2), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotSilver"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 3), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotLead"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 4), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotTitanium"
		}));
	}

}
