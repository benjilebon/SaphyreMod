package com.azer467.saphyre.util.handlers;

import com.azer467.saphyre.init.BlockInit;
import com.azer467.saphyre.init.ItemInit;
import com.azer467.saphyre.network.NetworkMessage;
import com.azer467.saphyre.network.NetworkPacketsInstance;
import com.azer467.saphyre.network.handlers.MessageHandler;
import com.azer467.saphyre.util.interfaces.IHasModel;
import com.azer467.saphyre.world.generation.WorldGenSaphyreOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber
public class RegistryHandler
{
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for (Item item : ItemInit.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel)item).registerModels();
            }
        }

        for (Block block : BlockInit.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel)block).registerModels();
            }
        }
    }

    public static void preInitRegistries()
    {
        NetworkPacketsInstance.NETWORK_SERVER_INSTANCE.registerMessage(MessageHandler.class, NetworkMessage.class, 0,Side.CLIENT);
        GameRegistry.registerWorldGenerator(new WorldGenSaphyreOres(), 0);
    }

    public static void initRegistries()
    {
        RecipesHandler.registerRecipes();
    }
}
