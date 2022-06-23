package com.azer467.saphyre.world;

import com.azer467.saphyre.config.SaphyreCommonConfigs;
import com.azer467.saphyre.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

// TODO: Have some clearer methods for better maintenance
public class SaphyreOreFeatures {

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SAPHYRE_FEATURE_ORE = FeatureUtils.register(
            "saphyre_ore",
            Feature.ORE,
            new OreConfiguration(List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.SAPHYRE_ORE.get().defaultBlockState())
            ), 8) // 8 => not sure what it means, but higher is presumably more
    );

    public static Holder<PlacedFeature> SAPHYRE_PLACED_ORE = PlacementUtils.register(
            "saphyre_placed_ore",
            SAPHYRE_FEATURE_ORE,
            List.of(
                    CountPlacement.of(SaphyreCommonConfigs.SAPHYRE_ORE_VEINS_PER_CHUNK.get()), // Number of veins in a chunk
                    InSquarePlacement.spread(), // Veins distribution method
                    HeightRangePlacement.uniform(
                            VerticalAnchor.aboveBottom(SaphyreCommonConfigs.SAPHYRE_ORE_VEINS_MIN_HEIGHT.get()),
                            VerticalAnchor.aboveBottom(SaphyreCommonConfigs.SAPHYRE_ORE_VEINS_MAX_HEIGHT.get())
                    ), // see where does aboveBottom starts
                    BiomeFilter.biome() // ?
            )
    );
}
