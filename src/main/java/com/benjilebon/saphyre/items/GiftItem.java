package com.benjilebon.saphyre.items;

import com.benjilebon.saphyre.SaphyreMain;
import com.benjilebon.saphyre.config.SaphyreClientConfigs;
import net.minecraft.Util;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GiftItem extends Item {
    private final String itemName;
    //TODO: custom loot tables ?
    private final ForgeConfigSpec.ConfigValue<String> lootTable;

    // We use the registry object entry instead of directly calling the object since it's not yet registered into the particle registry
    private RegistryObject<SimpleParticleType> giftParticle;

    public GiftItem(String itemName, ForgeConfigSpec.ConfigValue<String> lootTable, Properties properties)
    {
        super(properties);
        this.itemName = itemName;
        this.lootTable = lootTable;
    }

    public GiftItem setGiftParticle(RegistryObject<SimpleParticleType> particleType) {
        this.giftParticle = particleType;
        return this;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced)
    {
        tooltipComponents.add(Component.translatable("itemTooltip.saphyre.saphyre"));
        super.appendHoverText(itemStack, level, tooltipComponents, isAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand)
    {
        ItemStack currentSaphyre = player.getItemInHand(interactionHand);
        if (level.isClientSide) {
            player.startUsingItem(interactionHand);
            if (Boolean.TRUE.equals(SaphyreClientConfigs.SHOW_PARTICLES.get())) {
                spawnGiftParticles(level, player);
            }
            return InteractionResultHolder.success(currentSaphyre);
        } else {
            try {
                LootTable giftTable = ((ServerLevel) level).getServer().getLootTables().get(new ResourceLocation(lootTable.get()));
                if (giftTable.getLootTableId() == null) {
                    throw new IllegalStateException("Specified loot table for " + itemName + " does not exist (" + lootTable.get() + ")");
                }
                LootContext giftCtx = (new LootContext.Builder((ServerLevel) level)).create(LootContextParamSet.builder().build());
                List<ItemStack> generatedLoots = giftTable.getRandomItems(giftCtx);
                ItemStack givenLoot = generatedLoots.get(
                        ThreadLocalRandom.current().nextInt(generatedLoots.size()) % generatedLoots.size()
                );

                SaphyreMain.LOGGER.debug("Player " + player.getName().getContents() + " used " + this.itemName + "(" + lootTable.get() +")" + " : got " + givenLoot);
                player.sendSystemMessage(formatSuccessChatMessage(givenLoot));
                if (this.canGift(player, givenLoot)) {
                    player.addItem(givenLoot);
                } else {
                    ItemEntity itemEntity = new ItemEntity(level, player.getX(), player.getY() + 1.0D, player.getZ(), givenLoot);
                    level.addFreshEntity(itemEntity);
                }
                player.getItemInHand(interactionHand).shrink(1);

                return InteractionResultHolder.pass(player.getItemInHand(interactionHand));
            } catch (Exception e) {
                player.sendSystemMessage(Component.translatable("message.gifting.serverError"));
                SaphyreMain.LOGGER.error(e.getMessage());
                e.printStackTrace();
                return InteractionResultHolder.fail(player.getItemInHand(interactionHand));
            }
        }
    }

    private boolean canGift(Player player, ItemStack item) {
        return player.getInventory().getFreeSlot() != -1 || player.getInventory().contains(item);
    }

    private void spawnGiftParticles(Level level, Player player) {
        for (int i = 0; i < 360; i++) {
            if (i % 20 == 0) {
                level.addParticle(
                    giftParticle.get(),
                    player.getX(),
                    player.getY() + 0.50,
                    player.getZ(),
                    Math.cos(i) * 0.25d,
                    0.15d,
                    Math.sin(i) * 0.25d
                );
            }
        }
    }

    private Component formatSuccessChatMessage(ItemStack item) {
        return Component.translatable("message.gifting.item.success", item.getCount(), item.getDisplayName());
    }
}
