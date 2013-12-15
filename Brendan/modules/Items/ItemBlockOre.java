package Brendan.modules.Items;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import Brendan.modules.Lib.Rarities;
import Brendan.modules.Lib.RarityHelper;

public class ItemBlockOre extends ItemBlock{
	
	public static final String[] names = new String[] {"Copper Ore","Tin Ore","Silver Ore", "Lead Ore","Titanium Ore", "Ruby Ore", "Sapphire Ore"};
	
	
	public ItemBlockOre(int id) {
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);

	}
		
    @Override
    public EnumRarity getRarity(ItemStack stack)
    {
        return RarityHelper.getCustomRarityType(Rarities.LEGENDARY);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }
    
	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return names[is.getItemDamage()];
	}
}
