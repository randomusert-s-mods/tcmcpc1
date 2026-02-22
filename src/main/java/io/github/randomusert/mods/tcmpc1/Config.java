package io.github.randomusert.mods.tcmpc1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final Map<String, ModConfigSpec.BooleanValue> RECIPE_CONFIGS = new HashMap<>();
    public static final  ModConfigSpec.BooleanValue COMPRESSED_TIN_BLOCK_RECIPE;

    static {
        BUILDER.push("Recipes configuration");
        COMPRESSED_TIN_BLOCK_RECIPE = BUILDER
                .comment("Enable recipe for compressed tin block x1 and x2")
                .define("enableCompressedTinBlockRecipes", true);
        BUILDER.pop();
    }



    static final ModConfigSpec SPEC = BUILDER.build();

    private static void register(ModConfigSpec.Builder builder, String key, boolean defaultValue) {
        RECIPE_CONFIGS.put(key, builder.define(key, defaultValue));
    }


    public static boolean isRecipeEnabled(String configKey) {
        ModConfigSpec.BooleanValue configValue = RECIPE_CONFIGS.get(configKey);
        if (configValue == null) return true;


        System.out.println("Config key " + configKey + " internal value: " + configValue.get());

        return configValue.get();

    }


}
