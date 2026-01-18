package io.github.randomusert.mods.tcmpc1.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class infinium extends Item {
    public infinium(Properties properties) {
        super(properties);
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal("Creative tier item"));
        tooltipComponents.add(Component.translatable("tooltip.tcmpc1.see_jei").withStyle(ChatFormatting.GRAY));
    }
}
