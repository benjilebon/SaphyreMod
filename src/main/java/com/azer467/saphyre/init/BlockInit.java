package com.azer467.saphyre.init;

import com.azer467.saphyre.SaphyreMetadata;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

    private BlockInit() {}

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SaphyreMetadata.MODID);

    public static final RegistryObject<Block> SAPHYRE_ORE = BLOCKS.register(
        "saphyre_ore",
        () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(6.0f))
    );
}
