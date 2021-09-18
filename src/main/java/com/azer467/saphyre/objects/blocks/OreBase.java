package com.azer467.saphyre.objects.blocks;

import com.azer467.saphyre.init.ItemInit;
import com.azer467.saphyre.util.interfaces.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;

public class OreBase extends BlockBase implements IHasModel {

    public OreBase(String name, Material material, Float hardness)
    {
        super(name, material, hardness);
    }

    @Override
    public void getDrops(@NotNull NonNullList<ItemStack> drops, @NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull IBlockState state, int fortune) {
        drops.add(new ItemStack(ItemInit.SAPHYRE_INGOT, 2));
    }
}
