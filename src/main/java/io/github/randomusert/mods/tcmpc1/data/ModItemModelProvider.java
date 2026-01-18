package io.github.randomusert.mods.tcmpc1.data;

import io.github.randomusert.mods.tcmpc1.init.ModItems;
import io.github.randomusert.mods.tcmpc1.item.storage.LargeItemStorageVariant;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, tincraftmodpackcore1.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.INFINIUM_INGOT.get());
        basicItem(ModItems.TIN_INGOT.get());

        for (var type : LargeItemStorageVariant.values()) {
            singleTexture(getPath(ModItems.ITEM_STORAGE_PART.get(type).get()),
                    mcLoc("item/generated"), "layer0", modLoc("item/parts/" + type.getName()));

            singleTexture(getPath(ModItems.ITEM_DISK.get(type).get()), mcLoc("item/generated"),
                    "layer0", modLoc("item/disks/" + type.getName()));
        }
    }

    private String getPath(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }
}
