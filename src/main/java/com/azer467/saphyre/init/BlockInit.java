package com.azer467.saphyre.init;

import com.azer467.saphyre.objects.blocks.OreBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static List<Block> BLOCKS = new ArrayList<>();

    public static final Block SAPHYRE_ORE = new OreBase("saphyre_ore", Material.ROCK, 6.0f);
}
