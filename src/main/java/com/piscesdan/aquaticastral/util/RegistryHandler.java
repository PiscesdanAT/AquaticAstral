package com.piscesdan.aquaticastral.util;

import com.piscesdan.aquaticastral.blocks.aquamarble.*;
import com.piscesdan.aquaticastral.crafting.AquaMarbleRecipe;
import com.piscesdan.aquaticastral.world.structures.StructurePortalRuin;
import com.piscesdan.aquaticastral.world.structures.pieces.PortalRuinPiece;
import hellfirepvp.astralsorcery.common.CommonProxy;
import hellfirepvp.astralsorcery.common.block.properties.PropertiesMarble;
import hellfirepvp.astralsorcery.common.crafting.nojson.LiquidStarlightCraftingRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;

import static com.piscesdan.aquaticastral.AquaticAstral.MOD_ID;

@Mod.EventBusSubscriber(bus = Bus.MOD, modid = MOD_ID)
public class RegistryHandler
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MOD_ID);

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        LiquidStarlightCraftingRegistry.INSTANCE.register(new AquaMarbleRecipe());
    }

    public static IStructurePieceType PORTAL_RUIN_PIECE = PortalRuinPiece.Piece::new;

    //for blocks
    public static final RegistryObject<BlockAquaMarbleArch> AQUA_MARBLE_ARCH = BLOCKS.register("aqua_marble_arch", BlockAquaMarbleArch::new);
    public static final RegistryObject<BlockAquaMarbleBricks> AQUA_MARBLE_BRICKS = BLOCKS.register("aqua_marble_bricks", BlockAquaMarbleBricks::new);
    public static final RegistryObject<BlockAquaMarbleChiseled> AQUA_MARBLE_CHISELED = BLOCKS.register("aqua_marble_chiseled", BlockAquaMarbleChiseled::new);
    public static final RegistryObject<BlockAquaMarbleEngraved> AQUA_MARBLE_ENGRAVED = BLOCKS.register("aqua_marble_engraved", BlockAquaMarbleEngraved::new);
    public static final RegistryObject<BlockAquaMarblePillar> AQUA_MARBLE_PILLAR = BLOCKS.register("aqua_marble_pillar", BlockAquaMarblePillar::new);
    public static final RegistryObject<BlockAquaMarbleRaw> AQUA_MARBLE_RAW = BLOCKS.register("aqua_marble_raw", BlockAquaMarbleRaw::new);
    public static final RegistryObject<BlockAquaMarbleRuned> AQUA_MARBLE_RUNED = BLOCKS.register("aqua_marble_runed", BlockAquaMarbleRuned::new);

    //stairs and slabs
    public static  final RegistryObject<Block> AQUA_MARBLE_STAIRS = BLOCKS.register("aqua_marble_stairs", () -> new StairsBlock(() -> AQUA_MARBLE_RUNED.get().getDefaultState(), PropertiesMarble.defaultMarble()));
    public static  final RegistryObject<Block> AQUA_MARBLE_SLAB = BLOCKS.register("aqua_marble_slab", () -> new SlabBlock(Block.Properties.from(AQUA_MARBLE_BRICKS.get())));

    //itemblocks
    public static final RegistryObject<Item> AQUA_MARBLE_ARCH_ITEM = ITEMS.register("aqua_marble_arch", () -> new BlockItem(AQUA_MARBLE_ARCH.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_BRICKS_ITEM = ITEMS.register("aqua_marble_bricks", () -> new BlockItem(AQUA_MARBLE_BRICKS.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_CHISELED_ITEM = ITEMS.register("aqua_marble_chiseled", () -> new BlockItem(AQUA_MARBLE_CHISELED.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_ENGRAVED_ITEM = ITEMS.register("aqua_marble_engraved", () -> new BlockItem(AQUA_MARBLE_ENGRAVED.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_PILLAR_ITEM = ITEMS.register("aqua_marble_pillar", () -> new BlockItem(AQUA_MARBLE_PILLAR.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_RAW_ITEM = ITEMS.register("aqua_marble_raw", () -> new BlockItem(AQUA_MARBLE_RAW.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_RUNED_ITEM = ITEMS.register("aqua_marble_runed", () -> new BlockItem(AQUA_MARBLE_RUNED.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_SLAB_ITEM = ITEMS.register("aqua_marble_slab", () -> new BlockItem(AQUA_MARBLE_SLAB.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));
    public static final RegistryObject<Item> AQUA_MARBLE_STAIRS_ITEM = ITEMS.register("aqua_marble_stairs", () -> new BlockItem(AQUA_MARBLE_STAIRS.get(), new Item.Properties().group(CommonProxy.ITEM_GROUP_AS)));

    //structures
    public static final RegistryObject<StructurePortalRuin> PORTAL_RUIN = FEATURES.register("portal_ruin", () -> new StructurePortalRuin(NoFeatureConfig::deserialize));

    //pieces
    @SubscribeEvent
    public static void registerStructurePieces(RegistryEvent.Register<Feature<?>>  event)
    {
        Registry.register(Registry.STRUCTURE_PIECE, "PORTAL_RUIN".toLowerCase(Locale.ROOT), PORTAL_RUIN_PIECE);
    }
}
