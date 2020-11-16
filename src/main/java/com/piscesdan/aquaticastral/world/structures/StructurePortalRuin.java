package com.piscesdan.aquaticastral.world.structures;

import com.mojang.datafixers.Dynamic;
import com.piscesdan.aquaticastral.util.RegistryHandler;
import com.piscesdan.aquaticastral.world.structures.pieces.PortalRuinPiece;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StructurePortalRuin extends ScatteredStructure<NoFeatureConfig>
{
    public StructurePortalRuin(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn)
    {
        super(configFactoryIn);
    }

    @Override
    public String getStructureName()
    {
        return "Portal_Ruin";
    }

    @Override
    public int getSize()
    {
        return 1;
    }

    @Override
    public IStartFactory getStartFactory()
    {
        return StructurePortalRuin.Start::new;
    }

    @Override
    protected int getSeedModifier()
    {
        return 654984521;
    }

    public static class Start extends StructureStart
    {
        public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference, long seed)
        {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
        }

        public void init(ChunkGenerator<?> generator, TemplateManager manager, int chunkX, int chunkZ, Biome biome)
        {
            NoFeatureConfig config (NoFeatureConfig)generator.getStructureConfig(biome, RegistryHandler.PORTAL_RUIN);
            int i = chunkX * 16;
            int j = chunkZ * 16;
            BlockPos pos = new BlockPos(i, 90, j);
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
            PortalRuinPiece.func_204041_a(manager, pos, rotation, this.components, this.rand, config);
            this.recalculateStructureSize();
        }
    }

    public static enum Type
    {
        WARM("warm"),
        COLD("cold");

        private static final Map<String, Type> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(StructurePortalRuin.Type::getName, (x) -> {
            return x;
        }));
        private final String name;

        private Type(String name) {this.name = name;}

        public String getName() {return this.name;}

        public static StructurePortalRuin.Type getType(String name) {return BY_NAME.get(name);}
    }

}
