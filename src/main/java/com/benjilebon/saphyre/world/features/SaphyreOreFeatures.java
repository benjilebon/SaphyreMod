package com.benjilebon.saphyre.world.features;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class SaphyreOreFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, SaphyreMetadata.MODID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAPHYRE_FEATURE_ORE = CONFIGURED_FEATURES.register(
            "saphyre_ore",
            () -> new ConfiguredFeature<>(
                Feature.ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.SAPHYRE_ORE.get().defaultBlockState())
                ), 8) // 8 => not sure what it means, but higher is presumably more
            )
    );

    public static void register(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
    }
}
