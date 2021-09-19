package com.azer467.saphyre.init;

import com.azer467.saphyre.objects.items.GiftItemBase;
import com.azer467.saphyre.objects.items.ItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit
{
    public static List<Item> ITEMS = new ArrayList<>();

    public static final Item SAPHYRE_INGOT = new ItemBase("saphyre_ingot");
    public static final Item SAPHYRE = new GiftItemBase("saphyre");
    public static final Item ENHANCED_SAPHYRE = new GiftItemBase("enhanced_saphyre");
    public static final Item AMAZING_SAPHYRE = new GiftItemBase("amazing_saphyre");
    public static final Item INCREDIBLE_SAPHYRE = new GiftItemBase("incredible_saphyre");
    public static final Item ULTIMATE_SAPHYRE = new GiftItemBase("ultimate_saphyre");
}
