package io.github.randomusert.mods.tcmpc1.common.util;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.Codec;
import io.github.randomusert.mods.tcmpc1.Config;
import net.neoforged.neoforge.common.conditions.ICondition;

public record ConfigRecipeCondition(String configKey) implements ICondition {

    public static final MapCodec<ConfigRecipeCondition> CODEC = RecordCodecBuilder.mapCodec(inst ->
            inst.group(
                    Codec.STRING.fieldOf("config_key").forGetter(ConfigRecipeCondition::configKey)
            ).apply(inst, ConfigRecipeCondition::new)
    );

    @Override
    public boolean test(IContext iContext) {
        boolean result = Config.isRecipeEnabled(this.configKey);
        System.out.println("DEBUG: Checking condition " + this.configKey + " = " + result);
        return result;
    }

    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}
