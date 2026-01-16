package io.github.randomusert.mods.tcmpc1.init;

import java.util.function.Supplier;

import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;




public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, tincraftmodpackcore1.MODID);

    public static final Supplier<CreativeModeTab> TINCRAFT_MAIN_TAB = CREATIVE_MODE_TABS.register("main_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN_INGOT.get()))
                    .title(Component.translatable("creativetab.tcmpc1.main"))
                    .displayItems((itemDisplayParameter, output) -> {
                        output.accept(ModBlocks.COMPRESSED_TIN_BLOCK_X1);
                        output.accept(ModBlocks.COMPRESSED_TIN_BLOCK_X2);
                        output.accept(ModItems.INFINIUM_INGOT);
                    }).build());
}