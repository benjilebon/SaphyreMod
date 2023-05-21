package com.benjilebon.saphyre.events.particles;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.particles.GiftParticle;
import com.benjilebon.saphyre.init.ParticlesInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaphyreMetadata.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ParticleEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
       event.register(ParticlesInit.GIFT_PARTICLES.get(), GiftParticle.GiftProvider::new);
       event.register(ParticlesInit.ENHANCED_GIFT_PARTICLES.get(), GiftParticle.EnhancedGiftProvider::new);
       event.register(ParticlesInit.AMAZING_GIFT_PARTICLES.get(), GiftParticle.AmazingGiftProvider::new);
       event.register(ParticlesInit.INCREDIBLE_GIFT_PARTICLES.get(), GiftParticle.IncredibleGiftProvider::new);
       event.register(ParticlesInit.ULTIMATE_GIFT_PARTICLES.get(), GiftParticle.UltimateGiftProvider::new);
    }
}
