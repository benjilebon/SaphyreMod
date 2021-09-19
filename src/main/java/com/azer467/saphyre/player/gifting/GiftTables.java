package com.azer467.saphyre.player.gifting;

import com.azer467.saphyre.player.gifting.gifts.ItemGift;
import com.azer467.saphyre.util.interfaces.IGiftBase;

import java.util.ArrayList;

public class GiftTables {
    public ProbabilityList
            dropList, enhancedDropList, amazingDropList, incredibleDropList, ultimateDropList;

    private static GiftTables INSTANCE = new GiftTables();

    private GiftTables() {
        dropList = new ProbabilityList(new ArrayList<IGiftBase>() {{
            add(new ItemGift("minecraft:diamond", 1, 1));
            add(new ItemGift("minecraft:gold_ingot", 1, 1));
            add(new ItemGift("saphyre:non_existant", 1, 1));
        }});
        enhancedDropList = new ProbabilityList(new ArrayList<IGiftBase>() {{
            add(new ItemGift("minecraft:diamond", 1, 1));
        }});
        amazingDropList = new ProbabilityList(new ArrayList<IGiftBase>() {{
            add(new ItemGift("minecraft:diamond", 1, 1));
        }});
        incredibleDropList = new ProbabilityList(new ArrayList<IGiftBase>() {{
            add(new ItemGift("minecraft:diamond", 1, 1));
        }});
        ultimateDropList = new ProbabilityList(new ArrayList<IGiftBase>() {{
            add(new ItemGift("minecraft:diamond", 1, 1));
        }});
    }

    public static GiftTables getInstance() {
        return INSTANCE;
    }
}
