package com.azer467.saphyre.init;

import com.azer467.saphyre.SaphyreMain;
import com.azer467.saphyre.SaphyreMetadata;
import com.azer467.saphyre.config.SaphyreCommonConfigs;
import com.azer467.saphyre.items.GiftItem;
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

    //TODO: cleaner instanciation with method that register to ITEMS to avoid repeating itemName
    public static final RegistryObject<Item> SAPHYRE = ITEMS.register(
            "saphyre",
            () -> new GiftItem(
                    "saphyre",
                    SaphyreCommonConfigs.SAPHYRE_LOOT_TABLE.get(),
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            ).setGiftParticle(ParticlesInit.GIFT_PARTICLES)
    );

    public static final RegistryObject<Item> ENHANCED_SAPHYRE = ITEMS.register(
            "enhanced_saphyre",
            () -> new GiftItem(
                    "enhanced_saphyre",
                    SaphyreCommonConfigs.ENHANCED_SAPHYRE_LOOT_TABLE.get(),
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            ).setGiftParticle(ParticlesInit.ENHANCED_GIFT_PARTICLES)
    );

    public static final RegistryObject<Item> AMAZING_SAPHYRE = ITEMS.register(
            "amazing_saphyre",
            () -> new GiftItem(
                    "amazing_saphyre",
                    SaphyreCommonConfigs.AMAZING_SAPHYRE_LOOT_TABLE.get(),
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            ).setGiftParticle(ParticlesInit.AMAZING_GIFT_PARTICLES)
    );

    public static final RegistryObject<Item> INCREDIBLE_SAPHYRE = ITEMS.register(
            "incredible_saphyre",
            () -> new GiftItem(
                    "incredible_saphyre",
                    SaphyreCommonConfigs.INCREDIBLE_SAPHYRE_LOOT_TABLE.get(),
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            ).setGiftParticle(ParticlesInit.INCREDIBLE_GIFT_PARTICLES)
    );

    public static final RegistryObject<Item> ULTIMATE_SAPHYRE = ITEMS.register(
            "ultimate_saphyre",
            () -> new GiftItem(
                    "ultimate_saphyre",
                    SaphyreCommonConfigs.ULTIMATE_SAPHYRE_LOOT_TABLE.get(),
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            ).setGiftParticle(ParticlesInit.ULTIMATE_GIFT_PARTICLES)
    );


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
