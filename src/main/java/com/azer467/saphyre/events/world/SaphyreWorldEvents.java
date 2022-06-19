package com.azer467.saphyre.events.world;


import com.azer467.saphyre.SaphyreMetadata;
import com.azer467.saphyre.world.SaphyreOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaphyreMetadata.MODID)
public class SaphyreWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        SaphyreOreGeneration.generateOres(event);
    }
}
