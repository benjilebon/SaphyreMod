package com.benjilebon.saphyre.events.entity;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.init.EntityInit;
import com.benjilebon.saphyre.entity.SaphyreEntity;
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
