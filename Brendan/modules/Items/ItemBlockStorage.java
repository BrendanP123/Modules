package Brendan.modules.Items;

import java.util.List;
import Brendan.modules.Lib.Rarities;
import Brendan.modules.Lib.RarityHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStorage extends ItemBlock {
    public static String[] colours = new String[] { "Copper", "Tin", "Silver", "Lead", "Titanium" };
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
