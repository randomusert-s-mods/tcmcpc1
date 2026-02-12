package io.github.randomusert.mods.tcmpc1.init;

import com.mojang.serialization.MapCodec;
import io.github.randomusert.mods.tcmpc1.common.util.ConfigRecipeCondition;
import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModCodecs {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODEC =
            DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, tincraftmodpackcore1.MODID);

    public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigRecipeCondition>>
            CONFIG_CONDITION = CONDITION_CODEC.register("config_enabled", () -> ConfigRecipeCondition.CODEC);
}
