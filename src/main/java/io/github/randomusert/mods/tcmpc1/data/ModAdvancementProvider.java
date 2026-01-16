package io.github.randomusert.mods.tcmpc1.data;

import io.github.randomusert.mods.tcmpc1.init.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static final class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {
            Advancement.Builder builder = Advancement.Builder.advancement();

            builder.parent(AdvancementSubProvider.createPlaceholder("minecraft:story/root"));
            builder.display(new ItemStack(ModItems.INFINIUM_INGOT.get()),
                    Component.literal("A material from far far away"),
                    Component.literal("Obtain infinium. a Really late game item."),
                    null,
                    AdvancementType.CHALLENGE,
                    true,
                    true,
                    false
                    );

            builder.rewards(
                    AdvancementRewards.Builder.experience(1000)
            );

            builder.addCriterion("obtain_infinium", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.INFINIUM_INGOT));

            builder.save(consumer, ResourceLocation.fromNamespaceAndPath("tcmpc1", "obtain_infinium"), existingFileHelper);
        }
    }
}
