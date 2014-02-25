package common.modules.creativetab;

import common.modules.blocks.ModBlocks;
import common.modules.items.ModItems;
import common.modules.lib.GlobalValues;
import common.modules.lib.Reference;
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
        return Reference.CreativeTabModulesItems;
    }

    @Override
    public String getTranslatedTabLabel() {
        return getTabLabel();
    }
}