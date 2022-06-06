package com.azer467.saphyre.init;

import com.azer467.saphyre.SaphyreMain;
import com.azer467.saphyre.SaphyreMetadata;
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

//    public static final RegistryObject<Item> SAPHYRE_INGOT = ITEMS.register(
//            "saphyre_ingot",
//            () -> new Item(new Item.Properties().tab(SaphyreMain.SAPHYRE_TAB))
//    );
//
//
//    public static final Item SAPHYRE = new GiftItemBase("saphyre", GiftTables.getInstance().dropList);
//    public static final Item ENHANCED_SAPHYRE = new GiftItemBase("enhanced_saphyre", GiftTables.getInstance().enhancedDropList);
//    public static final Item AMAZING_SAPHYRE = new GiftItemBase("amazing_saphyre", GiftTables.getInstance().amazingDropList);
//    public static final Item INCREDIBLE_SAPHYRE = new GiftItemBase("incredible_saphyre", GiftTables.getInstance().incredibleDropList);
//    public static final Item ULTIMATE_SAPHYRE = new GiftItemBase("ultimate_saphyre", GiftTables.getInstance().ultimateDropList);
}
