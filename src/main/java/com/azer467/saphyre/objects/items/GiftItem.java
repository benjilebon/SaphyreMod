package com.azer467.saphyre.objects.items;

import com.azer467.saphyre.SaphyreMetadata;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class GiftItem extends Item {
        private String itemName;

        public GiftItem(String itemName, Properties properties) {
            super(properties);
            this.itemName = itemName;
        }

        @Override
        public void appendHoverText(ItemStack itemStack, Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced)
        {
            tooltipComponents.add(new TranslatableComponent("itemTooltip." + SaphyreMetadata.MODID + "." + itemName));
            super.appendHoverText(itemStack, level, tooltipComponents, isAdvanced);
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
