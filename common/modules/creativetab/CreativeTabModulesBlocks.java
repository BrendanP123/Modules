package common.modules.creativetab;

import common.modules.blocks.ModBlocks;
import common.modules.lib.GlobalValues;
import common.modules.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabModulesBlocks extends CreativeTabs {

    public CreativeTabModulesBlocks(int string) {
        super("Module Blocks");
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ModBlocks.InfusedPurpleTorch);
    }

    @Override
    public String getTabLabel() {
        return Reference.CreativeTabModulesBlocks;
    }

    @Override
    public String getTranslatedTabLabel() {
        return getTabLabel();
    }
}