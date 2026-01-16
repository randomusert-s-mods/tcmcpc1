package io.github.randomusert.mods.tcmpc1.item;

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
        tooltipComponents.add(Component.literal("A Creative mode Item. Really hard to get. crafted with 8x compressed tin block x2 and a ultimate circuit"));
    }
}
