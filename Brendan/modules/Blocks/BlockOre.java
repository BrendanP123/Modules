package Brendan.modules.Blocks;

import java.util.Random;

import Brendan.modules.ModulesCore;
import Brendan.modules.Items.ItemBlockOre;
import Brendan.modules.Lib.GlobalValues;


import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

public class BlockOre extends Block {
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[] iconBuffer;
	public Block belowBlock = Block.stone;

	/**
	 * Constructor
	 * @param id
	 * @param material
	 */
	public BlockOre(int id) {
		super(id, Material.rock);
		this.setHardness(6F);
		GameRegistry.registerBlock(this, ItemBlockOre.class, "BlockOre");
		this.setCreativeTab(ModulesCore.Modules);
	}
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[7];
		
		String id = GlobalValues.MODID + ":";
		iconBuffer[0] = ir.registerIcon(id + ItemBlockOre.types[0]);
		iconBuffer[1] = ir.registerIcon(id + ItemBlockOre.types[1]);
		iconBuffer[2] = ir.registerIcon(id + ItemBlockOre.types[2]);
		iconBuffer[3] = ir.registerIcon(id + ItemBlockOre.types[3]);
		iconBuffer[4] = ir.registerIcon(id + ItemBlockOre.types[4]);
		iconBuffer[5] = ir.registerIcon(id + ItemBlockOre.types[5]);
		iconBuffer[6] = ir.registerIcon(id + "TestBlock.png");
	}
    /**
     * Returns the quantity of items to drop on block destruction.
     */
	public int damageDropped(int metadata)
    {
        return metadata;
    }

	
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }
	
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		//If the meta is less than 4, stops ArrayIndexOutOfBoundsExceptions
		return (meta < 7)? iconBuffer[meta] : iconBuffer[0];
	}
	
}
