package Brendan.modules.Crafting;

import Brendan.modules.Blocks.ModBlocks;
import Brendan.modules.Items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * Simple class for all the item crafting recipes
 * @author Sparkst3r
 *
 */
public class ItemCrafting {
	/**
	 * Initialise the recipes
	 */
	public static void initialise() {
		FurnaceRecipes.smelting().addSmelting(ModBlocks.BlockOreField.blockID, 0, new ItemStack(ModItems.ItemImpureIngotField, 1, 0), 0.1F);
		FurnaceRecipes.smelting().addSmelting(ModBlocks.BlockOreField.blockID, 1, new ItemStack(ModItems.ItemImpureIngotField, 1, 1), 0.1F);
		FurnaceRecipes.smelting().addSmelting(ModBlocks.BlockOreField.blockID, 2, new ItemStack(ModItems.ItemImpureIngotField, 1, 2), 0.1F);
		FurnaceRecipes.smelting().addSmelting(ModBlocks.BlockOreField.blockID, 3, new ItemStack(ModItems.ItemImpureIngotField, 1, 3), 0.1F);
		FurnaceRecipes.smelting().addSmelting(ModBlocks.BlockOreField.blockID, 4, new ItemStack(ModItems.ItemImpureIngotField, 1, 4), 0.1F);
	}
}
