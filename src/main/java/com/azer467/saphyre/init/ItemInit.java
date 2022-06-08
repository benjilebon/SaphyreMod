package com.azer467.saphyre.init;

import com.azer467.saphyre.SaphyreMain;
import com.azer467.saphyre.SaphyreMetadata;
import com.azer467.saphyre.objects.items.GiftItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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
                    "minecraft:chests/igloo_chest",
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            )
    );

    public static final RegistryObject<Item> ENHANCED_SAPHYRE = ITEMS.register(
            "enhanced_saphyre",
            () -> new GiftItem(
                    "enhanced_saphyre",
                    "minecraft:chests/abandoned_mineshaft",
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            )
    );

    public static final RegistryObject<Item> AMAZING_SAPHYRE = ITEMS.register(
            "amazing_saphyre",
            () -> new GiftItem(
                    "amazing_saphyre",
                    "minecraft:chests/jungle_temple",
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            )
    );

    public static final RegistryObject<Item> INCREDIBLE_SAPHYRE = ITEMS.register(
            "incredible_saphyre",
            () -> new GiftItem(
                    "incredible_saphyre",
                    "minecraft:chests/end_city_treasure",
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB))
    );

    public static final RegistryObject<Item> ULTIMATE_SAPHYRE = ITEMS.register(
            "ultimate_saphyre",
            () -> new GiftItem(
                    "ultimate_saphyre",
                    "minecraft:chests/bastion_treasure",
                    new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB)
            )
    );
}
