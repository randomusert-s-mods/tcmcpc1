package io.github.randomusert.mods.tcmpc1.init;

import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
import io.github.randomusert.mods.tcmpc1.item.TinIngot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import io.github.randomusert.mods.tcmpc1.item.TinIngot;

// class to hold item setup
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(tincraftmodpackcore1.MODID);

    //register tin ingot
    public static final DeferredItem<TinIngot> TIN_INGOT = ITEMS.registerItem(
            "tin_ingot",
            TinIngot::new,
            new Item.Properties().rarity(Rarity.COMMON)
    );
}
