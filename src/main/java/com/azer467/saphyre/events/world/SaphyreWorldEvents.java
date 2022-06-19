package com.azer467.saphyre.events.world;


import com.azer467.saphyre.SaphyreMetadata;
import com.azer467.saphyre.init.EntityInit;
import com.azer467.saphyre.world.SaphyreOreGeneration;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SaphyreMetadata.MODID)
public class SaphyreWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        SaphyreOreGeneration.generateOres(event);

        if (event.getCategory().equals(Biome.BiomeCategory.FOREST)) {
            event.getSpawns().addSpawn(MobCategory.CREATURE, new SpawnerData(EntityInit.SAPHYRE_ENTITY.get(), 8, 1, 1));
        }
    }
}
