package Brendan.modules.Blocks;

import java.util.List;
import java.util.Random;

import Brendan.modules.Modules;
import Brendan.modules.Items.ModItems;
import Brendan.modules.Lib.RenderID;
import Brendan.modules.util.SCBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockOre extends SCBlock {
	public Icon textureBackground;

	public String texture;

	//Colours of the blocks
	public int[] colours = new int[] {
			0xB87333,
			0xD7D7D7,
			0xA6A6A6,
			0x6381AB,
			0xA9C8F2,
			0x740c16,
			0x0F52BA
	};



	//Basic Infomation
	public BlockOre(int par1, String name, String texture) {
		super(par1, Material.rock, name);
		this.renderAsNormalBlock = true;
		this.renderID = RenderID.renderIDOre;
		this.texture = texture;
		this.setLightOpacity(255);
		this.setCreativeTab(Modules.creativeTabModulesBlocks);
		this.setHardness(5.0F);
	}

	public int damageDropped(int par1)
	{
		if	(ModBlocks.RubyOre.getItemDamage() == par1){
			return ModItems.Ruby.getItemDamage();
		}
		else if	(ModBlocks.SapphireOre.getItemDamage() == par1){
			return ModItems.Sapphire.getItemDamage();
		}
		else { 
			return par1;  
		}
	}
	
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return this.blockID;
    }


	public int idDropped(int par1, Random par2Random, int par3)
	{ 
		if	(ModBlocks.RubyOre.getItemDamage() == par1 || ModBlocks.SapphireOre.getItemDamage() == par1){
			MultiDropped = true;
			return ModItems.GemField.itemID;
		}
		else { 
			MultiDropped = false;
			return this.blockID;
		}
	}

	boolean MultiDropped;

	public int quantityDropped(Random par1Random)
	{
		if (MultiDropped){
			return par1Random.nextInt(2) + 1;
		}
		else {
			return 1;
		}
	}


	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int i = 0; i < 7; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon("Modules:BlockOre");
		this.textureBackground = par1IconRegister.registerIcon("Modules:fancyBlockBG");
	}
}
