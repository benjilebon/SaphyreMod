package com.benjilebon.saphyre.events.init;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.entity.SaphyreEntity;
import com.benjilebon.saphyre.init.EntityInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaphyreMetadata.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {

    @SubscribeEvent
    public static void onSpawnPlacementRegisterEvent(SpawnPlacementRegisterEvent event) {
        event.register(
                EntityInit.SAPHYRE_ENTITY.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                SaphyreEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR
        );
    }
}
