package common.modules.items;

import java.util.List;

import common.modules.Modules;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * Meta-data Item for the another test Item.
 * 
 * @credits 2 Sparkst3r
 * @author BrendanP123
 *
 */

public class ItemTestItem extends Item	{
	
	public static String[] names = new String[] {"Something Staff[WIP]"};

	public ItemTestItem(int par1) {
		super(par1);
		this.setCreativeTab(Modules.creativeTabModulesItems);
	}

	/** Returns the texture based on the damage value */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIconFromDamage(int damage){
		return Item.pickaxeDiamond.getIconFromDamage(damage);
	}
	
	//Additional info (eg. the names of music discs
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean B){
	list.add("This Staff Is in Testing");
	}

	//The colour of the item name (eg. with golden apples)
	@Override
	public EnumRarity getRarity(ItemStack is){
	return EnumRarity.epic;
	}
	
	//Adds an effect to the item (eg. golden apples)
	@Override
	public boolean hasEffect(ItemStack is){
	return true;
	}
	
	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return names[is.getItemDamage()];
	}
	
	//This is the Wand Useage
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 == 0)
        {
            --par5;
        }

        if (par7 == 1)
        {
            ++par5;
        }

        if (par7 == 2)
        {
            --par6;
        }

        if (par7 == 3)
        {
            ++par6;
        }

        if (par7 == 4)
        {
            --par4;
        }

        if (par7 == 5)
        {
            ++par4;
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            int i1 = world.getBlockId(par4, par5, par6);

            if (i1 == 0)
            { 
                world.playSoundEffect(par4 + 0.5D, par5 + 0.5D, par6 + 0.5D, "dig.blockDiamond1", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                world.setBlock(par4-1 , par5, par6-1, Block.blockDiamond.blockID);
                world.setBlock(par4+1 , par5, par6+1, Block.blockDiamond.blockID);
                world.setBlock(par4-1 , par5, par6+1, Block.blockDiamond.blockID);
                world.setBlock(par4+1 , par5, par6-1, Block.blockDiamond.blockID);
                world.setBlock(par4 -1, par5, par6, Block.blockDiamond.blockID);
                world.setBlock(par4 +1 , par5, par6, Block.blockDiamond.blockID);
                world.setBlock(par4 , par5, par6, Block.blockDiamond.blockID);
                world.setBlock(par4, par5, par6 -1, Block.blockDiamond.blockID);
                world.setBlock(par4 , par5, par6 +1, Block.blockDiamond.blockID);
            }
            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
        }
    }
}
