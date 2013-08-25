package Brendan.modules.Extra;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Base class for any {@link Block} classes created.
 * 
 * @author Jcm2606
 */
public class BlockModules extends Block implements IBlockAddon {
    String rarity;
    
    public BlockModules(int par1, Material par2Material, String par3) {
        super(par1, par2Material);
        this.rarity = par3;
    }
    
    public BlockModules(int par1, Material par2Material) {
        super(par1, par2Material);
        this.rarity = "";
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean b) {}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		// TODO Auto-generated method stub
		return null;
	}
}
