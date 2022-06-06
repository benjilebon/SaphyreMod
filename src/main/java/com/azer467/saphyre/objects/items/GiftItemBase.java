//package com.azer467.saphyre.objects.items;
//
//import com.azer467.saphyre.player.gifting.ProbabilityList;
//import com.azer467.saphyre.util.interfaces.IGiftBase;
//import org.jetbrains.annotations.NotNull;
//
//public class GiftItemBase extends ItemBase {
//    private ProbabilityList dropList;
//
//    public GiftItemBase(String name, ProbabilityList dropList) {
//        super(name);
//        setDropList(dropList);
//    }
//
//    @Override
//    public @NotNull ActionResult<ItemStack> onItemRightClick(@NotNull World worldIn, @NotNull EntityPlayer playerIn, @NotNull EnumHand handIn) {
//        IGiftBase randomItem = dropList.sample();
//        boolean handleSuccess = randomItem.executeHandler(worldIn, playerIn, handIn);
//        if (handleSuccess) {
//            return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
//        } else {
//            return new ActionResult<>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
//        }
//    }
//
//    public ProbabilityList getDropList() {
//        return dropList;
//    }
//
//    public void setDropList(ProbabilityList dropList) {
//        this.dropList = dropList;
//    }
//}
