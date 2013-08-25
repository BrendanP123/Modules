package Brendan.modules.Items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Brendan.modules.ModulesCore;
import Brendan.modules.Lib.GlobalValues;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ItemWaterWand extends Item	{

	public ItemWaterWand(int par1) {
		super(par1);
		this.setCreativeTab(ModulesCore.Modules);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon("Modules:WaterWand");
	}
	
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B){ //Additional info (eg. the names of music discs)
	l.add("This staff is magical!");
	}

	public EnumRarity getRarity(ItemStack is){ //The colour of the item name (eg. with golden apples)
	return EnumRarity.epic;
	}

	public boolean hasEffect(ItemStack is){ //Adds an effect to the item (eg. golden apples)
	return true;
	}
	
	//This is the Wand Useage
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
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
            int i1 = par3World.getBlockId(par4, par5, par6);

            if (i1 == 0)
            {
            	//addPotionEffect(new PotionEffect(Potion.regeneration.id, 10, 0));
                par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "dig.grass1", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                par3World.setBlock(par4, par5, par6, Block.stone.blockID);
                par3World.setBlock(par4+1 , par5, par6, Block.stone.blockID);
                par3World.setBlock(par4+2 , par5, par6, Block.stone.blockID);
                par3World.setBlock(par4, par5, par6+1, Block.stone.blockID);
                par3World.setBlock(par4 , par5, par6+2, Block.stone.blockID);
                par3World.setBlock(par4 , par5, par6, Block.stone.blockID);
                //Player.inventory.consumeInventoryItem
            }

            par1ItemStack.damageItem(1, par2EntityPlayer);
            return true;
        }
    }
}
