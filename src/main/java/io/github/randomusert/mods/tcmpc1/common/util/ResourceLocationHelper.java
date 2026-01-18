package io.github.randomusert.mods.tcmpc1.common.util;

import net.minecraft.resources.ResourceLocation;
import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
public class ResourceLocationHelper {

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(tincraftmodpackcore1.MODID, path);
    }
}
