package com.azer467.saphyre.util.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public interface IGiftBase {
    double probability = 0;

    default boolean executeHandler(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        return false;
    }

    default double getProbability() {
        return probability;
    }
}
