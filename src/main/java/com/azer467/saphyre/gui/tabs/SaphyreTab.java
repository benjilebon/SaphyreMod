package com.azer467.saphyre.gui.tabs;

import com.azer467.saphyre.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SaphyreTab extends CreativeTabs {
    public SaphyreTab(String label) {
        super(label);
    }

    @Override
    public @NotNull ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.SAPHYRE);
    }
}
