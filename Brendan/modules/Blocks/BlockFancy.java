package Brendan.modules.Blocks;

import java.util.List;
import Brendan.modules.ModulesCore;
import Brendan.modules.Extra.BlockModules;
import Brendan.modules.Extra.ModulesBlock;
import Brendan.modules.Lib.GlobalValues;
import Brendan.modules.Proxy.ClientProxy;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockFancy extends ModulesBlock {
    public Icon textureBackground;
    
    public String texture;
    
    public int[] colours = new int[] {
        0x191919,
        0x993333,
        0x667F33,
        0x664C33,
        0x334CB2,
        0x7F3FB2,
        0x4C7F99,
        0x999999,
        0x4C4C4C,
        0xF27FA5,
        0x7FCC19,
        0xE5E533,
        0x6699D8,
        0xB24CD8,
        0xD87F33,
        0xFFFFFF
    };
    
    public BlockFancy(int par1, String name, String texture) {
        super(par1, Material.rock, name);
        this.texture = texture;
        this.setLightOpacity(255);
        this.renderID = GlobalValues.renderIDGlowingBrick;
        this.setCreativeTab(ModulesCore.Modules);
    }
    
    @Override
    public int damageDropped(int par1)
    {
      return par1;
    }
    
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for(int i = 0; i < 16; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }
    
    @Override
    public int getRenderType()
    {
        // You know that render ID we talked about earlier? You need to access it here.
        return GlobalValues.renderIDGlowingBrick;
    }
    
    public boolean canRenderInPass(int pass)
    {
        //Set the static var in the client proxy
        ClientProxy.renderPass = pass;
        //the block can render in both passes, so return true always
        return true;
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Modules:" + texture);
        this.textureBackground = par1IconRegister.registerIcon("Modules:BlockGlowingBG");
    }
    
    public boolean canCreatureSpawn(EnumCreatureType type, World world, int x, int y, int z)
    {
         return false;
       }
}
