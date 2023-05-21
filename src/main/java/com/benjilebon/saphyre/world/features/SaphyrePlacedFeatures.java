package com.benjilebon.saphyre.world.features;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.config.SaphyreCommonConfigs;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class SaphyrePlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, SaphyreMetadata.MODID);

    public static final RegistryObject<PlacedFeature> SAPHYRE_PLACED_ORE = PLACED_FEATURES.register(
            "saphyre_placed_ore",
            () -> new PlacedFeature(
                    SaphyreOreFeatures.SAPHYRE_FEATURE_ORE.getHolder().get(),
                    List.of(
                            // using .get() crashes the game since configs are not loaded yet when registering placed features, so config cannot be used here anymore
                            // see https://github.com/MinecraftForge/MinecraftForge/pull/8236 and issue #7716 for that matter

                            CountPlacement.of(SaphyreCommonConfigs.SAPHYRE_ORE_VEINS_PER_CHUNK.getDefault()), // Number of veins in a chunk
                            InSquarePlacement.spread(), // Veins distribution method
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.aboveBottom(SaphyreCommonConfigs.SAPHYRE_ORE_VEINS_MIN_HEIGHT.getDefault()),
                                    VerticalAnchor.aboveBottom(SaphyreCommonConfigs.SAPHYRE_ORE_VEINS_MAX_HEIGHT.getDefault())
                            ), // see where does aboveBottom starts
                            BiomeFilter.biome() // ?
                    ))
    );

    public static void register(IEventBus bus) {
        PLACED_FEATURES.register(bus);
    }
}
