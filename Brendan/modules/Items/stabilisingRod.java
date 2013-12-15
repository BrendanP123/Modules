package Brendan.modules.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class stabilisingRod extends Item {

        public stabilisingRod(int id) {
                super(id);
                
                setCreativeTab(CreativeTabs.tabMisc);
                setUnlocalizedName("genericItem");
        }
}