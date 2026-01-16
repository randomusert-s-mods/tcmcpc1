package io.github.randomusert.mods.tcmpc1.data;

import java.util.concurrent.CompletableFuture;

import io.github.randomusert.mods.tcmpc1.init.ModBlocks;
import io.github.randomusert.mods.tcmpc1.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_TIN_BLOCK_X1)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModCustomItems.TIN_BLOCK_TC)
                .unlockedBy("has_tin_block", has(io.github.randomusert.mods.tincraft.init.ModBlocks.TIN_BLOCK))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_TIN_BLOCK_X2)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModBlocks.COMPRESSED_TIN_BLOCK_X1)
                .unlockedBy("has_tin_block_x1", has(ModBlocks.COMPRESSED_TIN_BLOCK_X1))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.INFINIUM_INGOT)
                .requires(ModBlocks.COMPRESSED_TIN_BLOCK_X2, 8)
                .requires(ModCustomItems.ANTIMATTER_PALLET)
                .unlockedBy("has_compressed_tin_block_x2", has(ModBlocks.COMPRESSED_TIN_BLOCK_X2))
                .unlockedBy("has_antimatter_pellet", has(ModCustomItems.ANTIMATTER_PALLET))
                .save(output);
    }

}
