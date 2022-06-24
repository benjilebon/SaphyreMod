package com.benjilebon.saphyre.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class SaphyreCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> SAPHYRE_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> SAPHYRE_ORE_VEINS_MAX_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SAPHYRE_ORE_VEINS_MIN_HEIGHT;

    public static final ForgeConfigSpec.ConfigValue<String> SAPHYRE_LOOT_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> ENHANCED_SAPHYRE_LOOT_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> AMAZING_SAPHYRE_LOOT_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> INCREDIBLE_SAPHYRE_LOOT_TABLE;
    public static final ForgeConfigSpec.ConfigValue<String> ULTIMATE_SAPHYRE_LOOT_TABLE;

    public static final ForgeConfigSpec.ConfigValue<Integer> SAPHYRE_ENTITY_SPAWN_WEIGHT;

    static {
        BUILDER.push("Configs for Saphyre Mod");

        BUILDER.push("Saphyre Mod Ore Configuration");
        SAPHYRE_ORE_VEINS_PER_CHUNK = BUILDER
                .comment("How much Saphyre Ore Veins should spawn per Chunk")
                .define("Veins per chunk", 8);

        SAPHYRE_ORE_VEINS_MAX_HEIGHT = BUILDER
                .comment("Maximum height for spawning Saphyre Ore Veins")
                .defineInRange("Maximum height", 80, 0, 128);

        SAPHYRE_ORE_VEINS_MIN_HEIGHT = BUILDER
                .comment("Minimum height for spawning Saphyre Ore Veins")
                .defineInRange("Minimum height", 8, 0, 128);

        BUILDER.pop().push("Saphyre Mod Gifting Configuration");
        SAPHYRE_LOOT_TABLE = BUILDER
                .comment("What Loot Table is Saphyre taking items from")
                .define("Saphyre loot table", "minecraft:chests/igloo_chest");

        ENHANCED_SAPHYRE_LOOT_TABLE = BUILDER
                .comment("What Loot Table is Enhanced Saphyre taking items from")
                .define("Enhanced Saphyre loot table", "minecraft:chests/abandoned_mineshaft");

        AMAZING_SAPHYRE_LOOT_TABLE = BUILDER
                .comment("What Loot Table is Amazing Saphyre taking items from")
                .define("Amazing Saphyre loot table", "minecraft:chests/jungle_temple");

        INCREDIBLE_SAPHYRE_LOOT_TABLE = BUILDER
                .comment("What Loot Table is Incredible Saphyre taking items from")
                .define("Incredible Saphyre loot table", "minecraft:chests/end_city_treasure");

        ULTIMATE_SAPHYRE_LOOT_TABLE = BUILDER
                .comment("What Loot Table is Ultimate Saphyre taking items from")
                .define("Ultimate Saphyre loot table", "minecraft:chests/bastion_treasure");

        BUILDER.pop().push("Saphyre Entity Configuration");
        SAPHYRE_ENTITY_SPAWN_WEIGHT = BUILDER
                .comment("How much Saphyre Entity will spawn at a time, higher is more")
                .define("Saphyre Spawn Weight", 8);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
