package com.benjilebon.saphyre;

import com.benjilebon.saphyre.config.SaphyreClientConfigs;
import com.benjilebon.saphyre.config.SaphyreCommonConfigs;
import com.benjilebon.saphyre.init.EntityInit;
import com.benjilebon.saphyre.entity.client.SaphyreRenderer;
import com.benjilebon.saphyre.init.BlockInit;
import com.benjilebon.saphyre.init.ItemInit;
import com.benjilebon.saphyre.init.ParticlesInit;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

//TODO: Story telling (i'm definitely not inspired)

@Mod(SaphyreMetadata.MODID)
public class SaphyreMain
{
    public static final Logger LOGGER = LogUtils.getLogger();

    public SaphyreMain()
    {
        LOGGER.info("Loading Saphyre");
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ParticlesInit.PARTICLE_TYPES.register(bus);
        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        EntityInit.register(bus);

        bus.addListener(this::clientSetup);

        GeckoLib.initialize();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, SaphyreClientConfigs.SPEC, "saphyre-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SaphyreCommonConfigs.SPEC, "saphyre-common.toml");

        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.info("Saphyre has been successfully loaded");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(EntityInit.SAPHYRE_ENTITY.get(), SaphyreRenderer::new);
    }

    // TODO: Move to separated file
    public static final CreativeModeTab SAPHYRE_TAB = new CreativeModeTab(SaphyreMetadata.NAME) {
        @Override
        public ItemStack makeIcon() {
            return ItemInit.SAPHYRE_ORE.get().getDefaultInstance();
        }
    };
}
