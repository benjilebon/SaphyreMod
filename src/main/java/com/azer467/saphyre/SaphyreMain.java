package com.azer467.saphyre;

import com.azer467.saphyre.proxy.CommonProxy;
import com.azer467.saphyre.util.handlers.RegistryHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModMetadata.MODID, name = ModMetadata.NAME, version = ModMetadata.VERSION)
public class SaphyreMain
{
    private static Logger logger;

    @Instance
    public static SaphyreMain instance;

    @SidedProxy(clientSide = ModMetadata.CLIENT,  serverSide = ModMetadata.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        proxy.preInit();
        RegistryHandler.preInitRegistries();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
