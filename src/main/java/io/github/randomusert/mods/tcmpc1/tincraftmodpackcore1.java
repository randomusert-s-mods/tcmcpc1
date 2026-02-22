package io.github.randomusert.mods.tcmpc1;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import io.github.randomusert.mods.tcmpc1.init.ModBlocks;
import io.github.randomusert.mods.tcmpc1.init.ModCreativeTabs;
import io.github.randomusert.mods.tcmpc1.init.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(tincraftmodpackcore1.MODID)
public class tincraftmodpackcore1 {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tcmpc1";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public tincraftmodpackcore1(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
