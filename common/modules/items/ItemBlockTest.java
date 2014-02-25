package common.modules.items;

import java.util.List;

import common.modules.lib.Rarities;
import common.modules.lib.RarityHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Meta-data item for the Testing Block :D.
 * 
 * @credits 2 Sparkst3r
 * @author BrendanP123
 *
 */

public class ItemBlockTest extends ItemBlock {
    public static String[] colours = new String[] { "Copper", "Tin", "Silver", "Lead", "Titanium" };
	public static String[] types = new String[] {"waterMill"};
	public static String[] names = new String[] {"Kasslim Block"};

    public ItemBlockTest(int par1) {
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
