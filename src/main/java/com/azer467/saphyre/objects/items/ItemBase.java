package com.azer467.saphyre.objects.items;

import com.azer467.saphyre.SaphyreMain;
import com.azer467.saphyre.init.ItemInit;
import com.azer467.saphyre.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        SaphyreMain.proxy.registerItemRenderer(this, 0);
    }
}
