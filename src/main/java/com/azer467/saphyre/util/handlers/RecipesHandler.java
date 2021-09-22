package com.azer467.saphyre.util.handlers;

import com.azer467.saphyre.init.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesHandler
{
    public static void registerRecipes()
    {
        GameRegistry.addSmelting(new ItemStack(ItemInit.SAPHYRE_INGOT), new ItemStack(ItemInit.SAPHYRE), 1.0f);
    }
}
