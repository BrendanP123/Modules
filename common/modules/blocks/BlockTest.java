package common.modules.blocks;

import java.util.List;
import java.util.Random;

import common.modules.Modules;
import common.modules.lib.RenderID;
import common.modules.util.SCBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockTest extends SCBlock {
    public Icon textureBackground;
    public Icon blockIconTop;
    public Icon blockIconBot;
    
    public String texture;
    
    //Colours of the blocks
    public int[] colours = new int[] {
            0xF535AA
    };
    
    //Basic Infomation
    public BlockTest(int par1, String name, String texture) {
        super(par1, Material.rock, name);
        this.renderAsNormalBlock = true;
        this.renderID = RenderID.renderIDKasTest;
        this.texture = texture;
        this.setLightOpacity(255);
        this.setLightValue(000.1f);
        this.setCreativeTab(Modules.creativeTabModulesBlocks);
        this.setHardness(5.0F);
    }
    
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
	@SideOnly(Side.CLIENT)
 	@Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		float fx = (float)x + 0.5F;
		float fy = (float)y + 0.5F;
		float fz = (float)z + 0.5F;
		double xv;
		double yv;
		double zv;
		for(int i = 0; i < 20; i++){
			xv = random.nextDouble() - 0.5D;
			yv = random.nextDouble() - 0.5D;
			zv = random.nextDouble() - 0.5D;
			world.spawnParticle("mobSpell", fx, fy, fz, xv, yv, zv);
		}
	}
    
    //Meta data block dropped
    @Override
    public int damageDropped(int par1)
    {
      return par1;
    }
    
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for(int i = 0; i < 1; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
	
	@Override
	public Icon getIcon(int side, int metadata){
		if(side == 1){
			return blockIconTop;
		}
		else if(side == 0){
			return blockIconBot;
		}else{
			return blockIcon;
		}
	}

    //Registers textures
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("modules:WatermillSide3");
        this.blockIconTop = par1IconRegister.registerIcon("modules:WatermillSide3");
        this.blockIconBot = par1IconRegister.registerIcon("modules:WatermillSide3");
        this.textureBackground = par1IconRegister.registerIcon("modules:fancyBlockBG");
    }
    
    //Can Mob spawn = false
    @Override
	public boolean canCreatureSpawn(EnumCreatureType type, World world, int x, int y, int z)
    {
         return false;
       }
}
