package com.benjilebon.saphyre.init;

import com.benjilebon.saphyre.SaphyreMain;
import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.config.SaphyreCommonConfigs;
import com.benjilebon.saphyre.items.GiftItem;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit
{
    private ItemInit() {}

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SaphyreMetadata.MODID);


    public static final RegistryObject<BlockItem> SAPHYRE_ORE = ITEMS.register(
        "saphyre_ore",
        () -> new BlockItem(
                BlockInit.SAPHYRE_ORE.get(),
                new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
        )
    );


    public static final RegistryObject<Item> SAPHYRE = registerGiftItem("saphyre", SaphyreCommonConfigs.SAPHYRE_LOOT_TABLE.get(), ParticlesInit.GIFT_PARTICLES);
    public static final RegistryObject<Item> ENHANCED_SAPHYRE = registerGiftItem("enhanced_saphyre", SaphyreCommonConfigs.ENHANCED_SAPHYRE_LOOT_TABLE.get(), ParticlesInit.ENHANCED_GIFT_PARTICLES);
    public static final RegistryObject<Item> AMAZING_SAPHYRE = registerGiftItem("amazing_saphyre", SaphyreCommonConfigs.AMAZING_SAPHYRE_LOOT_TABLE.get(), ParticlesInit.AMAZING_GIFT_PARTICLES);
    public static final RegistryObject<Item> INCREDIBLE_SAPHYRE = registerGiftItem("incredible_saphyre", SaphyreCommonConfigs.INCREDIBLE_SAPHYRE_LOOT_TABLE.get(), ParticlesInit.INCREDIBLE_GIFT_PARTICLES);
    public static final RegistryObject<Item> ULTIMATE_SAPHYRE = registerGiftItem("ultimate_saphyre", SaphyreCommonConfigs.ULTIMATE_SAPHYRE_LOOT_TABLE.get(), ParticlesInit.ULTIMATE_GIFT_PARTICLES);


    private static RegistryObject<Item> registerGiftItem(String name, String lootTable, RegistryObject<SimpleParticleType> particle) {
        SaphyreMain.LOGGER.debug("Loaded loot table for " + name + " : " + lootTable);
        return ITEMS.register(name, () -> new GiftItem(
                name,
                lootTable,
                new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
        ).setGiftParticle(particle));
    }


    public static final RegistryObject<Item> RACCOON_SPAWN_EGG = ITEMS.register(
            "saphyre_spawn_egg",
            () -> new ForgeSpawnEggItem(
                    EntityInit.SAPHYRE_ENTITY,
                    0xffffff,
                    0xeeeeee,
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            )
    );
}
