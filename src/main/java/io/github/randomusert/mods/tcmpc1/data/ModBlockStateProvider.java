package io.github.randomusert.mods.tcmpc1.data;

import io.github.randomusert.mods.tcmpc1.init.ModBlocks;
import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, tincraftmodpackcore1.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.COMPRESSED_TIN_BLOCK_X1);
        blockWithItem(ModBlocks.COMPRESSED_TIN_BLOCK_X2);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
