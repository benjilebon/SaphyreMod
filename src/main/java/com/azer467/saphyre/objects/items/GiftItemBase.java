package com.azer467.saphyre.objects.items;

import com.azer467.saphyre.player.gifting.GiftTables;
import com.azer467.saphyre.util.interfaces.IGiftBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class GiftItemBase extends ItemBase {
    public GiftItemBase(String name) {
        super(name);
    }

    @Override
    public @NotNull ActionResult<ItemStack> onItemRightClick(@NotNull World worldIn, @NotNull EntityPlayer playerIn, @NotNull EnumHand handIn) {
        IGiftBase randomItem = GiftTables.getInstance().dropList.sample();
        boolean handleSuccess = randomItem.executeHandler(worldIn, playerIn, handIn);
        if (handleSuccess) {
            return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
        } else {
            return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
        }
    }
}
