package com.azer467.saphyre.player.gifting;

import com.azer467.saphyre.player.gifting.gifts.ItemGift;
import com.azer467.saphyre.util.interfaces.IGiftBase;

import java.util.ArrayList;
import java.util.Random;

public class GiftTables {
    public ProbabilityList
            dropList, enhancedDropList, amazingDropList, incredibleDropList, ultimateDropList;

    private static GiftTables INSTANCE = new GiftTables();

    private Random rand;

    private GiftTables() {
        dropList = new ProbabilityList(new ArrayList<>());
        addCommonLoots(dropList, 1.0f);
        addRareLoots(dropList, 1.0f);

        enhancedDropList = new ProbabilityList(new ArrayList<>());
        addCommonLoots(enhancedDropList, 2.0f);
        addRareLoots(enhancedDropList, 1.5f);

        amazingDropList = new ProbabilityList(new ArrayList<>());
        addCommonLoots(amazingDropList, 3.5f);
        addRareLoots(amazingDropList, 2.0f);

        incredibleDropList = new ProbabilityList(new ArrayList<>());
        addCommonLoots(incredibleDropList, 5.0f);
        addRareLoots(incredibleDropList, 2.5f);

        ultimateDropList = new ProbabilityList(new ArrayList<>());
        addCommonLoots(ultimateDropList, 8.0f);
        addRareLoots(ultimateDropList, 3.0f);
    }

    public static GiftTables getInstance() {
        return INSTANCE;
    }

    private int rand(int minimum, int maximum) {
        return minimum + rand.nextInt((maximum - minimum) + 1);
    }

    private void addCommonLoots(ProbabilityList list, float rarityLevel) {
        rand = new Random();
        list.addToList(new ItemGift("minecraft:dirt", rand(1, 3), 80 / rarityLevel))
                .addToList(new ItemGift("minecraft:cobblestone", rand(1, 2), 60 / rarityLevel))
                .addToList(new ItemGift("minecraft:rotten_flesh", rand(1, 3), 50 / rarityLevel))
                .addToList(new ItemGift("minecraft:spider_eye", 1, 45 / rarityLevel))
                .addToList(new ItemGift("minecraft:planks", 1, 30 / rarityLevel))
                .addToList(new ItemGift("minecraft:stone", rand(1, 2), 30 / rarityLevel))
                .addToList(new ItemGift("minecraft:snowball", 1, 30 / rarityLevel))
                .addToList(new ItemGift("minecraft:sand", 1, 20 / rarityLevel))
                .addToList(new ItemGift("minecraft:string", rand(1, 2), 15 / rarityLevel))
                .addToList(new ItemGift("minecraft:leaves", 1, 12 / rarityLevel))
                .addToList(new ItemGift("minecraft:arrow", 1, 11 / rarityLevel))
                .addToList(new ItemGift("minecraft:crafting_table", 1, 10 / rarityLevel))
                .addToList(new ItemGift("minecraft:furnace", 1, 10 / rarityLevel))
                .addToList(new ItemGift("minecraft:log", 1, 10 / rarityLevel))
                .addToList(new ItemGift("minecraft:coal", rand(1, 2), 10 / rarityLevel))
                .addToList(new ItemGift("minecraft:wool", 1, 10 / rarityLevel))
                .addToList(new ItemGift("minecraft:wheat", 1, 10 / rarityLevel))
                .addToList(new ItemGift("minecraft:wheat_seeds", 1, 10 / rarityLevel));
    }

    private void addRareLoots(ProbabilityList list, float probabilityMultiplier) {
        list.addToList(new ItemGift("minecraft:fish", 1, 10 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:red_flower", 1, 8 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:yellow_flower", 1, 8 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:bone", 1, 8 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:leather", 1, 8 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:gunpowder", 1, 8 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:gold_nugget", 1, 8 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:iron_nugget", 1, 8 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:redstone", 1, 7 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:gold_ingot", 1, 6 * probabilityMultiplier))
                .addToList(new ItemGift("minecraft:diamond", 1, 0.1 * probabilityMultiplier));
    }
}
