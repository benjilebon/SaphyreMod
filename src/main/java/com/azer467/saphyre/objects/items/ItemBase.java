package com.azer467.saphyre.objects.items;

import com.azer467.saphyre.SaphyreMain;
import com.azer467.saphyre.init.ItemInit;
import com.azer467.saphyre.util.interfaces.IHasModel;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        SaphyreMain.proxy.registerItemRenderer(this, 0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, @NotNull List<String> tooltip, @NotNull ITooltipFlag flagIn) {
        final String tooltipDescKey = stack.getItem().getUnlocalizedName() + ".description";
        if (I18n.hasKey(tooltipDescKey)) {
            tooltip.add(I18n.format(tooltipDescKey));
        }
    }
}
