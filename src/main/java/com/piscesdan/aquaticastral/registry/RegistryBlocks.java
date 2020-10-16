package com.piscesdan.aquaticastral.registry;

import com.piscesdan.aquaticastral.AquaticAstral;
import com.piscesdan.aquaticastral.blocks.aquamarble.BlockAquaMarbleRaw;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class RegistryBlocks
{
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
