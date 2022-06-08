package com.azer467.saphyre.objects.items;

import com.azer467.saphyre.SaphyreMetadata;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;

public class GiftItem extends Item {
    private final String itemName;
    //TODO: custom loot tables ?
    private String lootTable;

    public GiftItem(String itemName, String lootTable, Properties properties)
    {
        super(properties);
        this.itemName = itemName;
        this.lootTable = lootTable;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced)
    {
        tooltipComponents.add(new TranslatableComponent("itemTooltip." + SaphyreMetadata.MODID + "." + itemName));
        super.appendHoverText(itemStack, level, tooltipComponents, isAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand)
    {

        LootTable giftTable = level.getServer().getLootTables().get(new ResourceLocation(lootTable));
        LootContext giftCtx = (new LootContext.Builder((ServerLevel) level)).create(LootContextParamSets.CHEST);
        List<ItemStack> generatedLoots = giftTable.getRandomItems(giftCtx);
        return super.use(level, player, interactionHand);
    }

    //    public @NotNull ActionResult<ItemStack> onItemRightClick(@NotNull World worldIn, @NotNull EntityPlayer playerIn, @NotNull EnumHand handIn) {
//        IGiftBase randomItem = dropList.sample();
//        boolean handleSuccess = randomItem.executeHandler(worldIn, playerIn, handIn);
//        if (handleSuccess) {
//            return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
//        } else {
//            return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
//        }
//    }
}
