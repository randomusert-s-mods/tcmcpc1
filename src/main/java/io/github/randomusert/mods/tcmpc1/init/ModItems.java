package io.github.randomusert.mods.tcmpc1.init;

import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
import io.github.randomusert.mods.tcmpc1.item.TinIngot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import io.github.randomusert.mods.tcmpc1.item.TinIngot;
import io.github.randomusert.mods.tcmpc1.item.*;

// class to hold item setup
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(tincraftmodpackcore1.MODID);

    //register tin ingot
    public static final DeferredItem<TinIngot> TIN_INGOT = ITEMS.registerItem(
            "tin_ingot",
            TinIngot::new,
            new Item.Properties().rarity(Rarity.COMMON)
    );

    public static final DeferredItem<infinium> INFINIUM_INGOT = ITEMS.registerItem("infinium",
            infinium::new,
            new Item.Properties().rarity(Rarity.EPIC).fireResistant());

    public static final DeferredItem<BlockItem> COMPRESSED_TIN_BLOCK_X1_ITEM = ITEMS.register("compressed_tin_block_x1",
            () -> new BlockItem(ModBlocks.COMPRESSED_TIN_BLOCK_X1.get(), new Item.Properties()));

    public static final DeferredItem<BlockItem> COMPRESSED_TIN_BLOCK_X2_ITEM = ITEMS.register("compressed_tin_block_x2",
            () -> new BlockItem(ModBlocks.COMPRESSED_TIN_BLOCK_X2.get(), new Item.Properties()));
}
