package com.azer467.saphyre.entity.init;

import com.azer467.saphyre.SaphyreMetadata;
import com.azer467.saphyre.entity.SaphyreEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, SaphyreMetadata.MODID);

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    public static final RegistryObject<EntityType<SaphyreEntity>> SAPHYRE_ENTITY =
            ENTITY_TYPES.register(
                    "saphyre_entity",
                    () -> EntityType.Builder.of(SaphyreEntity::new, MobCategory.CREATURE)
                            .sized(1.2f, 0.9f)
                            .build(new ResourceLocation(SaphyreMetadata.MODID, "saphyre_entity").toString())
            );
}
