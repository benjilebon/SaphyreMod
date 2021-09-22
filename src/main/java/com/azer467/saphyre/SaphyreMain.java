package com.azer467.saphyre;

import com.azer467.saphyre.gui.tabs.SaphyreTab;
import com.azer467.saphyre.proxy.CommonProxy;
import com.azer467.saphyre.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

//TODO: Config integration
//TODO: Textures
//TODO: Items Drops (common/rare tables etc.)
//TODO: Achievements
//TODO: Add items (drop loots etc.)

@Mod(modid = SaphyreMetadata.MODID, name = SaphyreMetadata.NAME, version = SaphyreMetadata.VERSION)
public class SaphyreMain
{
    private static Logger logger;

    @Instance
    public static SaphyreMain instance;

    public static CreativeTabs SAPHYRE_TAB = new SaphyreTab("saphyre");

    @SidedProxy(clientSide = SaphyreMetadata.CLIENT,  serverSide = SaphyreMetadata.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        logger.info("Proxy Pre-initializing");
        proxy.preInit();
        logger.info("Registering Saphyre's World Ore Generator");
        RegistryHandler.preInitRegistries();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Registering recipes");
        RegistryHandler.initRegistries();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        logger.info("WOOF !");
    }
}
