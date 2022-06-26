package com.benjilebon.saphyre.world;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SaphyreBiomeModifiers {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SaphyreMetadata.MODID);

    public static RegistryObject<Codec<SaphyreOreModifier>> ORE_MODIFIER = BIOME_MODIFIERS.register("ores", () ->
        RecordCodecBuilder.create(builder -> builder.group(
                Biome.LIST_CODEC.fieldOf("biomes").forGetter(SaphyreOreModifier::biomes),
                PlacedFeature.CODEC.fieldOf("feature").forGetter(SaphyreOreModifier::feature)
        ).apply(builder, SaphyreOreModifier::new))
    );

    public static void register(IEventBus bus) {
        BIOME_MODIFIERS.register(bus);
    }
}
