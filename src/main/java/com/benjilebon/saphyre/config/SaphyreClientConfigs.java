package com.benjilebon.saphyre.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class SaphyreClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> SHOW_PARTICLES;


    static {
        BUILDER.push("Client-side Configs for Saphyre Mod");

        SHOW_PARTICLES = BUILDER
            .comment("Should Saphyre trigger particles around the player ?")
            .define("Show particles", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
