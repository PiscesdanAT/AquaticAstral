package com.piscesdan.aquaticastral.util;

import com.piscesdan.aquaticastral.blocks.aquamarble.*;
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

    //for blocks
    public static final RegistryObject<BlockAquaMarbleArch> AQUA_MARBLE_ARCH= BLOCKS.register("aqua_marble_arch", BlockAquaMarbleArch::new);
    public static final RegistryObject<BlockAquaMarbleBricks> AQUA_MARBLE_BRICKS = BLOCKS.register("aqua_marble_bricks", BlockAquaMarbleBricks::new);
    public static final RegistryObject<BlockAquaMarbleChiseled> AQUA_MARBLE_CHISELED = BLOCKS.register("aqua_marble_chiseled", BlockAquaMarbleChiseled::new);
    public static final RegistryObject<BlockAquaMarbleEngraved> AQUA_MARBLE_ENGRAVED = BLOCKS.register("aqua_marble_engraved", BlockAquaMarbleEngraved::new);
    public static final RegistryObject<BlockAquaMarblePillar> AQUA_MARBLE_PILLAR = BLOCKS.register("aqua_marble_pillar", BlockAquaMarblePillar::new);
    public static final RegistryObject<BlockAquaMarbleRaw> AQUA_MARBLE_RAW = BLOCKS.register("aqua_marble_raw", BlockAquaMarbleRaw::new);
    public static final RegistryObject<BlockAquaMarbleRuned> AQUA_MARBLE_RUNED = BLOCKS.register("aqua_marble_runed", BlockAquaMarbleRuned::new);

    //itemblocks
    public static final RegistryObject<Item> AQUA_MARBLE_ARCH_ITEM = ITEMS.register("aqua_marble_arch", () -> new BlockItem(AQUA_MARBLE_ARCH.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_BRICKS_ITEM = ITEMS.register("aqua_marble_bricks", () -> new BlockItem(AQUA_MARBLE_BRICKS.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_CHISELED_ITEM = ITEMS.register("aqua_marble_chiseled", () -> new BlockItem(AQUA_MARBLE_CHISELED.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_ENGRAVED_ITEM = ITEMS.register("aqua_marble_engraved", () -> new BlockItem(AQUA_MARBLE_ENGRAVED.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_PILLAR_ITEM = ITEMS.register("aqua_marble_pillar", () -> new BlockItem(AQUA_MARBLE_PILLAR.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_RAW_ITEM = ITEMS.register("aqua_marble_raw", () -> new BlockItem(AQUA_MARBLE_RAW.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_RUNED_ITEM = ITEMS.register("aqua_marble_runed", () -> new BlockItem(AQUA_MARBLE_RUNED.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
}
