package com.piscesdan.aquaticastral.world.structures;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.OceanRuinConfig;

public class AquaRuinsConfig implements IFeatureConfig
{
    public final StructurePortalRuin.Type type;

    public AquaRuinsConfig(StructurePortalRuin.Type type)
    {
        this.type = type;
    }

    @Override
    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("biome_temp"), ops.createString(this.type.getName()))));
    }

    public static <T> AquaRuinsConfig deserialize(Dynamic<T> in)
    {
        StructurePortalRuin.Type type = StructurePortalRuin.Type.getType(in.get("biome_temp").asString(""));
        return new AquaRuinsConfig(type);
    }
}
