package common.modules.items;

import java.util.List;
import common.modules.lib.Rarities;
import common.modules.lib.RarityHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Meta-data item for the 5 Ore Blocks.
 * 
 * @credits 2 Sparkst3r
 * @author BrendanP123
 * 
 */

public class ItemBlockOre extends ItemBlock {
	/** Human-Readable names */
	public static final String[] names = new String[] { "Copper Ore","Tin Ore", "Silver Ore", "Lead Ore", "Titanium Ore", "Ruby Ore","Sapphire Ore" };

	/**
	 * Constructor
	 * @param id Item ID
	 */
	public ItemBlockOre(int id) {
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	/**
	 * Return an item rarity from EnumRarity
	 */
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return RarityHelper.getCustomRarityType(Rarities.LEGENDARY);
	}

	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	/** Returns the unlocalised name of the block */
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return names[is.getItemDamage()];
	}
}
