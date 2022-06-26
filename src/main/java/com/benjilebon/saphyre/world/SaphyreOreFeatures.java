package com.benjilebon.saphyre.world;

import com.benjilebon.saphyre.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class SaphyreOreFeatures {

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SAPHYRE_FEATURE_ORE = FeatureUtils.register(
            "saphyre_ore",
            Feature.ORE,
            new OreConfiguration(List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.SAPHYRE_ORE.get().defaultBlockState())
            ), 8) // 8 => not sure what it means, but higher is presumably more
    );

}
