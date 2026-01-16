package io.github.randomusert.mods.tcmpc1.data;

import io.github.randomusert.mods.tcmpc1.init.ModItems;
import net.minecraft.data.PackOutput;
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
    }
}
