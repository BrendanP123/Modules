package common.modules.items;

import java.util.List;

import common.modules.lib.Rarities;
import common.modules.lib.RarityHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Meta-data item for the 5 Storge Blocks.
 * 
 * @credits 2 Sparkst3r
 * @author BrendanP123
 *
 */

public class ItemBlockStorage extends ItemBlock {
	public static String[] types = new String[] {"blockCopper","blockTin","blockSilver","blockLead","blockTitanium", "blockRuby", "blockSapphire"};
	public static String[] names = new String[] {"Copper Storage","Tin Storage","Silver Storage", "Lead Storage","Titanium Storage","Ruby Storage", "Sapphire Storage"};

    public ItemBlockStorage(int par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
    
    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return RarityHelper.getCustomRarityType(Rarities.LEGENDARY);
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }
    
	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return names[is.getItemDamage()];
	}
}
