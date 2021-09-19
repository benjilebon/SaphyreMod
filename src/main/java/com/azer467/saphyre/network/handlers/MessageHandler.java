package com.azer467.saphyre.network.handlers;

import com.azer467.saphyre.SaphyreMetadata;
import com.azer467.saphyre.network.NetworkMessage;
import com.azer467.saphyre.player.gifting.gifts.ItemGift;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import java.util.Objects;

@SuppressWarnings("rawtypes")
public class MessageHandler implements IMessageHandler<NetworkMessage, IMessage> {
    @Override
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(NetworkMessage message, MessageContext ctx) {
        Object translationMessage = message.getGiftInstance();
        if (translationMessage == null) {
            LogManager.getLogger(SaphyreMetadata.MODID).error("Couldn't print gift in chat !");
            return null;
        }
        if (translationMessage instanceof ItemGift) {
            processItemGift((ItemGift) translationMessage);
        }
        return null;
    }

    private void sendPlayerMessage(String message) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(message));
    }

    private void processItemGift(ItemGift itemGift) {
        if (I18n.hasKey(itemGift.getChatMessage())) {
            if (Objects.equals(itemGift.getChatMessage(), "message.gifting.item.success")) {
                sendPlayerMessage(formatItemGiftMessage(itemGift));
            } else {
                sendPlayerMessage(I18n.format(itemGift.getChatMessage()));
            }
        }
    }

    private String formatItemGiftMessage(ItemGift itemGift) {
        return I18n.format(
                itemGift.getChatMessage(),
                itemGift.getCount(),
                Objects.requireNonNull(Item.REGISTRY.getObject(
                        new ResourceLocation(itemGift.getItemId())
                )).getDefaultInstance().getDisplayName()
        );
    }
}
