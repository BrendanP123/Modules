package Brendan.modules.Lib;

import Brendan.modules.Blocks.ModBlocks;
import Brendan.modules.Items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabModulesItems extends CreativeTabs {

    public CreativeTabModulesItems(int string) {
        super("Module Items");
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ModItems.ExtraItemField, 0, 2);
    }

    @Override
    public String getTabLabel() {
        return GlobalValues.CreativeTabModulesItems;
    }

    @Override
    public String getTranslatedTabLabel() {
        return getTabLabel();
    }
}