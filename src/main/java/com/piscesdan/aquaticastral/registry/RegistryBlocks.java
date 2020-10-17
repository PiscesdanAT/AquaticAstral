package com.piscesdan.aquaticastral.registry;

import com.piscesdan.aquaticastral.AquaticAstral;
import com.piscesdan.aquaticastral.blocks.aquamarble.BlockAquaMarbleRaw;
import hellfirepvp.astralsorcery.common.block.base.CustomItemBlock;
import hellfirepvp.astralsorcery.common.util.NameUtil;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import java.util.LinkedList;
import java.util.List;

import static com.piscesdan.aquaticastral.lib.BlockAA.*;

public class RegistryBlocks
{
    static final List<CustomItemBlock> ITEM_BLOCKS = new LinkedList<>();

    public static void registerBlocks()
    {
            AQUA_MARBLE_RAW     = registerBlock(new BlockAquaMarbleRaw());
    }

    private static <T extends Block> T registerBlock(T block)
    {
        return registerBlock(block, NameUtil.fromClass(block, "Block"));
    }

    private static <T extends Block> T registerBlock(T block, ResourceLocation name)
    {
        block.setRegistryName(name);
        AquaticAstral.getProxy().getRegistryPrimer().register(block);
        if (block instanceof CustomItemBlock)
        {
            ITEM_BLOCKS.add((CustomItemBlock) block);
        }
        return block;
    }
}
