package com.benjilebon.saphyre.events.particles;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.particles.GiftParticle;
import com.benjilebon.saphyre.init.ParticlesInit;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaphyreMetadata.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticlesInit.GIFT_PARTICLES.get(), GiftParticle.GiftProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticlesInit.ENHANCED_GIFT_PARTICLES.get(), GiftParticle.EnhancedGiftProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticlesInit.AMAZING_GIFT_PARTICLES.get(), GiftParticle.AmazingGiftProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticlesInit.INCREDIBLE_GIFT_PARTICLES.get(), GiftParticle.IncredibleGiftProvider::new);
        Minecraft.getInstance().particleEngine.register(ParticlesInit.ULTIMATE_GIFT_PARTICLES.get(), GiftParticle.UltimateGiftProvider::new);
    }
}
