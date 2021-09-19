package com.azer467.saphyre.network;

import com.azer467.saphyre.util.interfaces.IGiftBase;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.io.*;

public class NetworkMessage<T extends IGiftBase> implements IMessage {

    public NetworkMessage(){}

    private T giftInstance;

    public NetworkMessage(T giftInstance) {
        this.giftInstance = giftInstance;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(giftInstance);
            out.flush();
            buf.writeBytes(bos.toByteArray());
        } catch (IOException ignored) {
        }

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        byte[] b = new byte[buf.readableBytes()];
        buf.readBytes(b);
        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        try {
            ObjectInput in = new ObjectInputStream(bis);
            @SuppressWarnings("unchecked")
            IGiftBase giftInstance = (T) in.readObject();
        } catch (IOException | ClassNotFoundException ignored) {
        }
    }

    public T getGiftInstance() {
        return giftInstance;
    }
}
