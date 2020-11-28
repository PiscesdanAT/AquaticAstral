package com.piscesdan.aquaticastral;

import com.piscesdan.aquaticastral.util.RegistryHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("aquaticastral")
public class AquaticAstral
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "aquaticastral";

    public AquaticAstral()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RegistryHandler.init();
    }

}
