package com.piscesdan.aquaticastral.util;

import com.piscesdan.aquaticastral.blocks.aquamarble.BlockAquaMarbleRaw;
import hellfirepvp.astralsorcery.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.piscesdan.aquaticastral.AquaticAstral.MOD_ID;

public class RegistryHandler
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //for items
    public static final RegistryObject<BlockAquaMarbleRaw> AQUA_MARBLE_RAW = BLOCKS.register("aqua_marble_raw", BlockAquaMarbleRaw::new);
    public static final RegistryObject<Item> AQUA_MARBLE_RAW_ITEM = ITEMS.register("aqua_marble_raw", () -> new BlockItem(AQUA_MARBLE_RAW.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
}
