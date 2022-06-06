//package com.azer467.saphyre.player.gifting.gifts;
//
//import com.azer467.saphyre.SaphyreMetadata;
//import com.azer467.saphyre.network.NetworkMessage;
//import com.azer467.saphyre.network.NetworkPacketsInstance;
//import com.azer467.saphyre.util.interfaces.IGiftBase;
//import net.minecraft.block.Block;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.player.EntityPlayerMP;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.EnumHand;
//import net.minecraft.util.NonNullList;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.world.World;
//import org.apache.logging.log4j.LogManager;
//
//import java.io.Serializable;
//import java.util.Objects;
//import java.util.Random;
//
//public class ItemGift implements IGiftBase, Serializable {
//    private final String itemId;
//    private final int count;
//    private final double probability;
//    private String chatMessage = null;
//    private String selectedItemDisplayName = null;
//
//    public ItemGift(String itemId, int count, double probability)
//    {
//        this.itemId = itemId;
//        this.count = count;
//        this.probability = probability;
//    }
//
//    public boolean executeHandler(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
//        if (!worldIn.isRemote) {
//            ItemStack triggerItemSource = playerIn.getHeldItem(handIn);
//            final Item item = Item.REGISTRY.getObject(new ResourceLocation(this.itemId));
//            if (item == null) {
//                LogManager.getLogger(SaphyreMetadata.MODID).warn("Tried to gift non-existant item : " + this.itemId);
//                sendResultToClient(playerIn, "message.gifting.serverError");
//                return false;
//            }
//
//            final NonNullList<ItemStack> subItems = NonNullList.create();
//            item.getSubItems(Objects.requireNonNull(item.getCreativeTab()), subItems);
//            final ItemStack selectedItem = subItems.get(new Random().nextInt(subItems.size()));
//            selectedItem.setCount(count);
//            selectedItemDisplayName = selectedItem.getDisplayName();
//            if (playerIn.inventory.getFirstEmptyStack() == -1) {
//                Block.spawnAsEntity(worldIn, playerIn.getPosition(), selectedItem);
//                triggerItemSource.setCount(triggerItemSource.getCount() - 1);
//            } else {
//                playerIn.addItemStackToInventory(selectedItem);
//            }
//
//            triggerItemSource.setCount(triggerItemSource.getCount() - 1);
//            sendResultToClient(playerIn, "message.gifting.item.success");
//        }
//        return true;
//    }
//
//    private void sendResultToClient(EntityPlayer playerIn, String message) {
//        setChatMessage(message);
//        NetworkPacketsInstance.NETWORK_SERVER_INSTANCE.sendTo(
//                new NetworkMessage<>(this),
//                (EntityPlayerMP)playerIn
//        );
//    }
//
//    @Override
//    public double getProbability() {
//        return probability;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setChatMessage(String chatMessage) {
//        this.chatMessage = chatMessage;
//    }
//
//    public String getChatMessage() {
//        return chatMessage;
//    }
//
//    public String getSelectedItemDisplayName() {
//        return selectedItemDisplayName;
//    }
//
//    public String getItemId() {
//        return itemId;
//    }
//}
