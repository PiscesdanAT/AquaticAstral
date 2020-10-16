package com.piscesdan.aquaticastral.util;

import com.piscesdan.aquaticastral.AquaticAstral;
import com.piscesdan.aquaticastral.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler
{
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AquaticAstral.MOD_ID);

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //for items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
}
