package Brendan.modules.Items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlock{
	public static String[] types = {"copperOre","tinOre","silverOre","leadOre","titaniumOre","greenGlow"};
	public static String[] names = {"Copper Ore","Tin Ore","Silver Ore", "Lead Ore","Titanium Ore","Testing Ore"};
	public ItemBlockOre(int id) {
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);

	}
		
	
	public int getMetadata(int meta) {
		return meta;
	}
	
	public String getUnlocalizedName(ItemStack is) {
		
		return types[is.getItemDamage()];
	}
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < 6; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	} 
}
