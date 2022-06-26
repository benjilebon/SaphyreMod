package com.benjilebon.saphyre.world;

import com.benjilebon.saphyre.config.SaphyreCommonConfigs;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public record SaphyreEntityModifier(HolderSet<Biome> biomes, MobSpawnSettings.SpawnerData spawnerData) implements BiomeModifier {
    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD && biomes.contains(biome)) {
            builder.getMobSpawnSettings().addSpawn(
                    spawnerData.type.getCategory(),
                    new MobSpawnSettings.SpawnerData(
                            spawnerData.type,
                            SaphyreCommonConfigs.SAPHYRE_ENTITY_SPAWN_WEIGHT.get(),
                            spawnerData.minCount,
                            spawnerData.maxCount
                    )
            );
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return SaphyreBiomeModifiers.ENTITY_MODIFIER.get();
    }
}