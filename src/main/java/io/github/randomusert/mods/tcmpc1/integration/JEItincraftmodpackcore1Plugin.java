package io.github.randomusert.mods.tcmpc1.integration;


import io.github.randomusert.mods.tcmpc1.init.ModItems;
import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class JEItincraftmodpackcore1Plugin implements IModPlugin {

    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(tincraftmodpackcore1.MODID, "jei_plugin");


    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addIngredientInfo(
                new ItemStack(ModItems.INFINIUM_INGOT.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei.tcmpc1.infinium.info")
        );
    }
}
