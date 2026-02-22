package io.github.randomusert.mods.tcmpc1.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DiamondHammer extends Item {
    public DiamondHammer(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
            return (stack.getItem() instanceof DiamondHammer);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        int durability = itemStack.getDamageValue();

        itemStack.setDamageValue(durability + 1);

        if (itemStack.getDamageValue() == itemStack.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        return itemStack.copy();
    }
}
