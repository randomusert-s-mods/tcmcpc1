package io.github.randomusert.mods.tcmpc1.init;

import io.github.randomusert.mods.tcmpc1.item.storage.LargeItemStorageVariant;
import io.github.randomusert.mods.tcmpc1.item.storage.expandedstoragedisk.ExpandedStorageDiskItem;
import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
import io.github.randomusert.mods.tcmpc1.item.TinIngot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import io.github.randomusert.mods.tcmpc1.item.TinIngot;
import io.github.randomusert.mods.tcmpc1.item.*;

import java.util.HashMap;
import java.util.Map;

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

    public static final DeferredItem<BlockItem> COMPRESSED_TIN_BLOCK_X3_ITEM = ITEMS.register("compressed_tin_block_x3",
            () -> new BlockItem(ModBlocks.COMPRESSED_TIN_BLOCK_X3.get(), new Item.Properties()));

    public static final DeferredItem<Item> DIAMOND_HAMMER = ITEMS.registerItem("diamond_hammer",
            DiamondHammer::new, new Item.Properties().durability(100).setNoRepair());

    public static final Map<LargeItemStorageVariant, DeferredItem<Item>> ITEM_STORAGE_PART = new HashMap<>();
    public static final Map<LargeItemStorageVariant, DeferredItem<Item>> ITEM_DISK = new HashMap<>();


    static {
        for (var variant : LargeItemStorageVariant.values()) {
            ITEM_STORAGE_PART.put(variant, ITEMS.registerItem("storagepart_" + variant.getName(), Item::new));
            ITEM_DISK.put(variant,
                    ITEMS.register("disk_" + variant.getName(), () -> new ExpandedStorageDiskItem(variant)));
        }
    }
}
