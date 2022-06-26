package com.benjilebon.saphyre.world;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.config.SaphyreCommonConfigs;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
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
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    SaphyreOreFeatures.SAPHYRE_FEATURE_ORE,
                    List.of(
                            CountPlacement.of(SaphyreCommonConfigs.SAPHYRE_ORE_VEINS_PER_CHUNK.get()), // Number of veins in a chunk
                            InSquarePlacement.spread(), // Veins distribution method
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.aboveBottom(SaphyreCommonConfigs.SAPHYRE_ORE_VEINS_MIN_HEIGHT.get()),
                                    VerticalAnchor.aboveBottom(SaphyreCommonConfigs.SAPHYRE_ORE_VEINS_MAX_HEIGHT.get())
                            ), // see where does aboveBottom starts
                            BiomeFilter.biome() // ?
                    ))
    );

    public static void register(IEventBus bus) {
        PLACED_FEATURES.register(bus);
    }
}
