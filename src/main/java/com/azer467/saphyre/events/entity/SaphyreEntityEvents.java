package com.azer467.saphyre.events.entity;

import com.azer467.saphyre.SaphyreMetadata;
import com.azer467.saphyre.init.EntityInit;
import com.azer467.saphyre.entity.SaphyreEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaphyreMetadata.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SaphyreEntityEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityInit.SAPHYRE_ENTITY.get(), SaphyreEntity.setAttributes());
    }
}
