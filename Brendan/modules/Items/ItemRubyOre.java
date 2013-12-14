package Brendan.modules.Items;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemRubyOre extends ItemBlock {
    public final static String[] colours = new String[] { "Ruby"};

    public ItemRubyOre(int par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
    
    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.rare;
    }
    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4)
    {
        list.add(colours[(stack.getItemDamage() % 16)]);
    }
}
