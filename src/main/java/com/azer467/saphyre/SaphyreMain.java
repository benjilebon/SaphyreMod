package com.azer467.saphyre;

import com.azer467.saphyre.core.world.OreGeneration;
import com.azer467.saphyre.init.BlockInit;
import com.azer467.saphyre.init.ItemInit;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

// PORT TO 1.18.2

//TODO: Add missing items
//TODO: Re-add gifting system
//TODO: Re-add network stack
//TODO: Verify resources
//TODO: Fix Saphyre Ore no drops
//TODO: Fix Saphyre Ore no generation

/////////////////

//TODO: Config integration
//TODO: Textures
//TODO: Items Drops (common/rare tables etc.)
//TODO: Achievements
//TODO: Add items (drop loots etc.)

@Mod(SaphyreMetadata.MODID)
public class SaphyreMain
{
    private static final Logger LOGGER = LogUtils.getLogger();

    public SaphyreMain()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // TODO: Move to separated file
    public static final CreativeModeTab SAPHYRE_TAB = new CreativeModeTab(SaphyreMetadata.NAME) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return ItemInit.SAPHYRE_ORE.get().getDefaultInstance();
        }
    };

    public void setup(final FMLCommonSetupEvent event) // =<<<<<<<<<<<<
    {
        LOGGER.info("Proxy Pre-initializing");
        LOGGER.info("Registering Saphyre's World Ore Generator");
        event.enqueueWork(OreGeneration::registerOresGeneration);
    }

//    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents
//    {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
//        {
//            LOGGER.info("Registering recipes");
//        }
//    }
}
