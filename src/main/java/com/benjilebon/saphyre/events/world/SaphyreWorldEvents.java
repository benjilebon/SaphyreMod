//package com.benjilebon.saphyre.events.world;
//
//
//import com.benjilebon.saphyre.SaphyreMetadata;
//import com.benjilebon.saphyre.config.SaphyreCommonConfigs;
//import com.benjilebon.saphyre.init.EntityInit;
//import com.benjilebon.saphyre.world.SaphyreOreGeneration;
//import net.minecraft.world.entity.MobCategory;
//import net.minecraft.world.level.biome.Biome;
//import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
//import net.minecraftforge.event.world.BiomeLoadingEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = SaphyreMetadata.MODID)
//public class SaphyreWorldEvents {
//    @SubscribeEvent
//    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
//
//        SaphyreOreGeneration.generateOres(event);
//
//        if (event.getCategory().equals(Biome.BiomeCategory.FOREST)) {
//            event.getSpawns().addSpawn(MobCategory.CREATURE, new SpawnerData(EntityInit.SAPHYRE_ENTITY.get(), SaphyreCommonConfigs.SAPHYRE_ENTITY_SPAWN_WEIGHT.get(), 1, 1));
//        }
//    }
//}
