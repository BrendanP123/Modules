package Brendan.modules.Blocks;

import java.util.List;
import Brendan.modules.Modules;
import Brendan.modules.Lib.RenderID;
import Brendan.modules.util.SCBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockStorage extends SCBlock {
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
    public BlockStorage(int par1, String name, String texture) {
        super(par1, Material.rock, name);
        this.renderAsNormalBlock = true;
        this.renderID = RenderID.renderIDIngotStorage;
        this.texture = texture;
        this.setLightOpacity(255);
        this.setLightValue(000.1f);
        this.setCreativeTab(Modules.creativeTabModulesBlocks);
        this.setHardness(5.0F);
    }
    //Meta data block dropped
    @Override
    public int damageDropped(int par1)
    {
      return par1;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for(int i = 0; i < 7; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    //Registers textures
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("modules:IngotsStorage");
        this.textureBackground = par1IconRegister.registerIcon("modules:fancyBlockBG");
    }
    
    //Can Mob spawn = false
    @Override
	public boolean canCreatureSpawn(EnumCreatureType type, World world, int x, int y, int z)
    {
         return false;
       }
}
