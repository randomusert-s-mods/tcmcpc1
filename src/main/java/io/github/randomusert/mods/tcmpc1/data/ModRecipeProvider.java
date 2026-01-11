package io.github.randomusert.mods.tcmpc1.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import mekanism.api.datagen.recipe.builder.*;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import mekanism.api.datagen.recipe.builder.ItemStackToItemStackRecipeBuilder;



public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }



    @Override
    protected void buildRecipes(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModCustomItems.BASIC_ENERGY_CUBE_MEK)
                .requires(Items.IRON_BLOCK, 9)
                .unlockedBy("has_iron_block", has(Items.IRON_BLOCK))
                .save(output);

                ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(ModCustomItems.TIN_INGOT_TC), new ItemStack(ModCustomItems.OSMIUM_RAW_MEK)).build(output);

                ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(Items.GRANITE), new ItemStack(ModCustomItems.TIN_ORE_TC)).build(output);
    }

}
