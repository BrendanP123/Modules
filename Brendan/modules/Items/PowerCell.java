package Brendan.modules.Items;


import java.util.List;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Brendan.modules.ModulesCore;
import Brendan.modules.Lib.GlobalValues;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;


/**
 * Meta-data item for the 4 ingots.
 * 
 * @author BrendanP123
 * @author Sparkst3r
 *
 */
public class PowerCell extends Item {
	/** Texture file names + code name */
    public static String[] types = new String[] {"unrefinedElectrode", "electrode"};     
    
    /** Human-Readable names */
    public static String[] names = new String[] {"Unrefined Electrode", "Electrode"};
    
    /** Icon Array */
    @SideOnly(Side.CLIENT)
    private Icon[] iconBuffer;

    /**
     * Constructor
     * @param id Item ID
     */
	public PowerCell(int id) {
		super(id);
        this.setCreativeTab(ModulesCore.Modules);
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
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[types.length];

		String id = GlobalValues.MODID + ":";
		iconBuffer[0] = ir.registerIcon(id + types[0]);
		iconBuffer[1] = ir.registerIcon(id + types[1]);
	}
    
	/** Adds the meta items to the tab */
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < 2; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	} 

	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return types[is.getItemDamage()];
	}

}