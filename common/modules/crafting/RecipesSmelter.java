package common.modules.crafting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import common.modules.blocks.ModBlocks;
import common.modules.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class RecipesSmelter
{
	private static final RecipesSmelter smeltBase = new RecipesSmelter();

	private HashMap<List<Integer>, ItemStack> metaSmeltingList1 = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, ItemStack> metaSmeltingList2 = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList1 = new HashMap<List<Integer>, ItemStack>();
	private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList2 = new HashMap<List<Integer>, ItemStack>();

	public static final RecipesSmelter smelting()
	{
		return smeltBase;
	}

	private RecipesSmelter()
	{
		this.addDoubleItemSmelting(new ItemStack(ModBlocks.InfusedBlueTorch), new ItemStack(ModItems.ItemImpureIngotField, 3), new ItemStack(ModItems.InfusedCoalField, 4));
	}

	public void addDoubleItemSmelting(ItemStack input1, ItemStack input2, ItemStack output)
	{
		this.metaSmeltingList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), output);
		this.metaSmeltingList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), output);
		this.metaSmeltingCheckList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), input1);
		this.metaSmeltingCheckList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), input2);
	}

	public ItemStack getDoubleSmeltingResult(ItemStack item1, ItemStack item2)
	{
		if (item1 == null){return null;}
		if (item2 == null){return null;}

		if (item1.itemID == ModItems.ItemIngotField.itemID && item2.itemID == Item.diamond.itemID)
		{
			return new ItemStack(Item.axeDiamond);
		}
		return null;
	}

	public ItemStack getSlot1ReduceAmount(ItemStack input)
	{
		return this.metaSmeltingCheckList1.get(Arrays.asList(input.itemID, input.getItemDamage()));
	}

	public ItemStack getSlot2ReduceAmount(ItemStack input)
	{
		return this.metaSmeltingCheckList2.get(Arrays.asList(input.itemID, input.getItemDamage()));
	}

}