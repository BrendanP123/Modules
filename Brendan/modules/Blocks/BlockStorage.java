package Brendan.modules.Blocks;


import Brendan.modules.ModulesCore;
import Brendan.modules.Items.ItemBlockStorage;
import Brendan.modules.Lib.GlobalValues;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockStorage extends Block {
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[] iconBuffer;

	/**
	 * Constructor
	 * @param id
	 * @param material
	 */
	public BlockStorage(int id) {
		super(id, Material.rock);
		this.setHardness(6F);
		GameRegistry.registerBlock(this, ItemBlockStorage.class, "BlockStorage");
		this.setCreativeTab(ModulesCore.Modules);
		this.setStepSound(soundMetalFootstep);
	}
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[5];
    	
		String id = GlobalValues.MODID + ":"; 
		iconBuffer[0] = ir.registerIcon("Modules:blockCopper");
		iconBuffer[1] = ir.registerIcon("Modules:blockTin");
		iconBuffer[2] = ir.registerIcon("Modules:blockSilver");
		iconBuffer[3] = ir.registerIcon("Modules:blockLead");
		iconBuffer[4] = ir.registerIcon("Modules:blockTitanium");
	}
	
	public int damageDropped(int metadata)
    {
        return metadata;
    }
    
	
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		//If the meta is less than 4, stops ArrayIndexOutOfBoundsExceptions
		return (meta < 5)? iconBuffer[meta] : iconBuffer[0];
	}
	
}