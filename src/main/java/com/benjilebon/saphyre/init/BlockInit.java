package com.benjilebon.saphyre.init;

import com.benjilebon.saphyre.SaphyreMetadata;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class BlockInit {

    private BlockInit() {}

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SaphyreMetadata.MODID);

    public static final RegistryObject<Block> SAPHYRE_ORE = BLOCKS.register(
        "saphyre_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(6.0f))
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
