package Brendan.modules.Items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Brendan.modules.Modules;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWaterWand extends Item	{

	public ItemWaterWand(int par1) {
		super(par1);
		this.setCreativeTab(Modules.creativeTabModulesItems);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("Modules:WaterWand");
	}
	
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B){ //Additional info (eg. the names of music discs)
	l.add("This staff is magical!");
	}

	@Override
	public EnumRarity getRarity(ItemStack is){ //The colour of the item name (eg. with golden apples)
	return EnumRarity.epic;
	}

	@Override
	public boolean hasEffect(ItemStack is){ //Adds an effect to the item (eg. golden apples)
	return true;
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
