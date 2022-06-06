package com.azer467.saphyre.core.world;

import com.azer467.saphyre.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

public class OreGeneration {

    public static Holder<PlacedFeature> SAPHYRE_OREGEN;

    public static void registerOresGeneration() {
        OreConfiguration saphyreConfig = new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.SAPHYRE_ORE.get().defaultBlockState(), 100000);
        SAPHYRE_OREGEN = registerPlacedFeature("saphyre_ore", new ConfiguredFeature<>(Feature.ORE, saphyreConfig),
                CountPlacement.of(10000),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(90)));
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers) {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }
}
