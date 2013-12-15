package Brendan.modules.Crafting;

import Brendan.modules.Blocks.ModBlocks;
import Brendan.modules.Items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 8, 0), new ItemStack(ModBlocks.BlockStorageField, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 8, 1), new ItemStack(ModBlocks.BlockStorageField, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 8, 2), new ItemStack(ModBlocks.BlockStorageField, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 8, 3), new ItemStack(ModBlocks.BlockStorageField, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ItemIngotField, 8, 4), new ItemStack(ModBlocks.BlockStorageField, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.GemField, 9, 0), new ItemStack(ModBlocks.BlockStorageField, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.GemField, 9, 1), new ItemStack(ModBlocks.BlockStorageField, 1, 6));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 0), 
				new Object[] {
			"III","IXI","III", Character.valueOf('I'), "ingotCopper"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 1), 
				new Object[] {
			"III","IXI","III", Character.valueOf('I'), "ingotTin"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 2), 
				new Object[] {
			"III","IXI","III", Character.valueOf('I'), "ingotSilver"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 3), 
				new Object[] {
			"III","IXI","III", Character.valueOf('I'), "ingotLead"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 4), 
				new Object[] {
			"III","IXI","III", Character.valueOf('I'), "ingotTitanium"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 5), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), (new ItemStack(ModItems.GemField, 9, 0)),
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockStorageField, 1, 6), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), (new ItemStack(ModItems.GemField, 9, 1))
		}));
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.InfusedRedTorch, 4), new Object[] {"X", "#", 'X', new ItemStack(ModItems.InfusedCoalField, 1, 0), '#', Item.stick});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.InfusedGreenTorch, 4), new Object[] {"X", "#", 'X', new ItemStack(ModItems.InfusedCoalField, 1, 1), '#', Item.stick});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.InfusedWhiteTorch, 4), new Object[] {"X", "#", 'X', new ItemStack(ModItems.InfusedCoalField, 1, 2), '#', Item.stick});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.InfusedPurpleTorch, 4), new Object[] {"X", "#", 'X', new ItemStack(ModItems.InfusedCoalField, 1, 3), '#', Item.stick});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.InfusedBlueTorch, 4), new Object[] {"X", "#", 'X', new ItemStack(ModItems.InfusedCoalField, 1, 4), '#', Item.stick});
		
	}

}
