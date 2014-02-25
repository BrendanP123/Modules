package common.modules.items;


import java.util.List;

import common.modules.Modules;
import common.modules.lib.GlobalValues;
import common.modules.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;


/**
 * Meta-data item for the 2 PowerCell's.
 * 
 * @credits 2 Sparkst3r
 * @author BrendanP123
 *
 */
public class PowerCells extends Item {
	/** Texture file names + code name */
    /** Human-Readable names */
    public static String[] types = new String[] {"emptyPowercell", "powerCell"};
    public static String[] names = new String[] {"Empty Power Cell", "Power Cell"};
    
    /** Icon Array */
    @SideOnly(Side.CLIENT)
    private Icon[] iconBuffer;

    /**
     * Constructor
     * @param id Item ID
     */
	public PowerCells(int id) {
		super(id);
        this.setCreativeTab(Modules.creativeTabModulesItems);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}


	/** Returns the texture based on the damage value */
	@SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int damage){
    	return iconBuffer[damage];
    }
    
	/** Register the textures with the IconRegister */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[types.length];

		String id = Reference.MODID + ":";
		iconBuffer[0] = ir.registerIcon(id + types[0]);
		iconBuffer[1] = ir.registerIcon(id + types[1]);
	}
    
	/** Adds the meta items to the tab */
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < this.types.length; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	} 

	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return types[is.getItemDamage()];
	}

}