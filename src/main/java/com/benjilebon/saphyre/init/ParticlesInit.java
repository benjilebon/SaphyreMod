package com.benjilebon.saphyre.init;

import com.benjilebon.saphyre.SaphyreMetadata;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticlesInit {
    public static DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SaphyreMetadata.MODID);

    public static final RegistryObject<SimpleParticleType> GIFT_PARTICLES =
            PARTICLE_TYPES.register("gift_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> ENHANCED_GIFT_PARTICLES =
            PARTICLE_TYPES.register("enhanced_gift_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> AMAZING_GIFT_PARTICLES =
            PARTICLE_TYPES.register("amazing_gift_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> INCREDIBLE_GIFT_PARTICLES =
            PARTICLE_TYPES.register("incredible_gift_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> ULTIMATE_GIFT_PARTICLES =
            PARTICLE_TYPES.register("ultimate_gift_particles", () -> new SimpleParticleType(true));

}
