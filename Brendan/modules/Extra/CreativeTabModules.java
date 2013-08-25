package Brendan.modules.Extra;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabModules extends CreativeTabs {

    public CreativeTabModules() {
        super("Modules");
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Item.appleGold);
    }

    @Override
    public String getTabLabel() {
        return "Modules";
    }

    @Override
    public String getTranslatedTabLabel() {
        return getTabLabel();
    }
}