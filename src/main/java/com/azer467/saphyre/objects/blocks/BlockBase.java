package com.azer467.saphyre.objects.blocks;

import com.azer467.saphyre.SaphyreMain;
import com.azer467.saphyre.init.BlockInit;
import com.azer467.saphyre.init.ItemInit;
import com.azer467.saphyre.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material, Float hardness)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(SaphyreMain.SAPHYRE_TAB);
        setHardness(hardness);
        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels()
    {
        SaphyreMain.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}
