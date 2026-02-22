package io.github.randomusert.mods.tcmpc1.data;

import java.util.concurrent.CompletableFuture;

import com.refinedmods.refinedstorage.common.misc.ProcessorItem;
import com.refinedmods.refinedstorage.common.storage.ItemStorageVariant;
import io.github.randomusert.mods.tcmpc1.common.util.ConfigRecipeCondition;
import io.github.randomusert.mods.tcmpc1.common.util.ResourceLocationHelper;
import io.github.randomusert.mods.tcmpc1.init.ModBlocks;
import io.github.randomusert.mods.tcmpc1.init.ModItems;
import io.github.randomusert.mods.tcmpc1.item.storage.LargeItemStorageVariant;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import mekanism.api.datagen.recipe.builder.*;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import mekanism.api.datagen.recipe.builder.ItemStackToItemStackRecipeBuilder;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredItem;


public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }




    @Override
    protected void buildRecipes(RecipeOutput output) {

        ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(ModCustomItems.TIN_INGOT_TC), new ItemStack(ModCustomItems.OSMIUM_RAW_MEK)).build(output);

        ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(Items.GRANITE), new ItemStack(ModCustomItems.TIN_ORE_TC)).build(output);




        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_TIN_BLOCK_X1)
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModCustomItems.TIN_BLOCK_TC)
                .unlockedBy("has_tin_block", has(io.github.randomusert.mods.tincraft.init.ModBlocks.TIN_BLOCK))
                .save(output.withConditions(new ConfigRecipeCondition("enableCompressedTinBlockRecipes")));

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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_HAMMER)
                .pattern("dsd")
                .pattern(" s ")
                .pattern(" s ")
                .define('d', Items.DIAMOND)
                .define('s', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GRAVEL)
                .requires(ModItems.DIAMOND_HAMMER)
                .requires(Items.COBBLESTONE)
                .unlockedBy("has_diamond_hammer", has(ModItems.DIAMOND_HAMMER))
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .save(output);
        for (var type : LargeItemStorageVariant.values()) {
            if (type.equals(LargeItemStorageVariant.TIER_5)) {
                partRecipe(ModItems.ITEM_STORAGE_PART.get(type),
                        com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getItemStoragePart(ItemStorageVariant.SIXTY_FOUR_K),
                        output);
            } else {

                partRecipe(ModItems.ITEM_STORAGE_PART.get(type),
                        ModItemTags.Items.PARTS_ITEM.get(
                                LargeItemStorageVariant.values()[type.ordinal() -1]),
                        output);
            }

            diskRecipe(ModItems.ITEM_DISK.get(type), ModItemTags.Items.PARTS_ITEM.get(type), output);
        }


    }

    private void partRecipe(DeferredItem<Item> result, TagKey<Item> previousPart, RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get())
                .pattern("DID")
                .pattern("GRG")
                .pattern("DGD")
                .define('G', previousPart)
                .define('D', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getProcessor(ProcessorItem.Type.ADVANCED))
                .define('I', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getQuartzEnrichedCopper())
                .define('R', Items.REDSTONE_BLOCK)
                .unlockedBy("has_previous_part", has(previousPart))
                .save(consumer, ResourceLocationHelper.rl("part/" + result.getId().getPath()));
    }

    private void partRecipe(DeferredItem<Item> result, Item previousPart,
                            RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get())
                .pattern("DID")
                .pattern("GRG")
                .pattern("DGD")
                .define('G', previousPart)
                .define('D', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getProcessor(ProcessorItem.Type.ADVANCED))
                .define('I', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getQuartzEnrichedIron())
                .define('R', Items.REDSTONE)
                .unlockedBy("has_previous_part", has(previousPart))
                .save(consumer, ResourceLocationHelper.rl("part/" + result.getId().getPath()));
    }


    private void diskRecipe(DeferredItem<Item> result, TagKey<Item> part,
                            RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get())
                .pattern("GRG")
                .pattern("RSR")
                .pattern("III")
                .define('G', Tags.Items.GLASS_BLOCKS)
                .define('S', part)
                .define('I', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getQuartzEnrichedIron())
                .define('R', Items.REDSTONE)
                .unlockedBy("has_part", has(part))
                .save(consumer, ResourceLocationHelper.rl("disk/shaped/" + result.getId().getPath()));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get())
                .requires(com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getStorageHousing())
                .requires(part)
                .unlockedBy("has_part", has(part))
                .save(consumer, ResourceLocationHelper.rl("disk/shapeless/" + result.getId().getPath()));
    }

}
