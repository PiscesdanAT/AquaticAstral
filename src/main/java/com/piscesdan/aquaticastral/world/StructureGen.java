package com.piscesdan.aquaticastral.world;

import com.piscesdan.aquaticastral.util.RegistryHandler;
import com.piscesdan.aquaticastral.world.structures.AquaRuinsConfig;
import com.piscesdan.aquaticastral.world.structures.StructurePortalRuin;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class StructureGen
{
    public static void generatePortal()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            AquaRuinsConfig config = new AquaRuinsConfig(StructurePortalRuin.Type.WARM);
            if(biome == Biomes.WARM_OCEAN)
            {
                config = new AquaRuinsConfig(StructurePortalRuin.Type.WARM);
                biome.addStructure(RegistryHandler.PORTAL_RUIN.get().withConfiguration(config));
            }
            else if(biome == Biomes.COLD_OCEAN)
            {
                config = new AquaRuinsConfig(StructurePortalRuin.Type.COLD);
                biome.addStructure(RegistryHandler.PORTAL_RUIN.get().withConfiguration(config));
            }
            else if(biome == Biomes.PLAINS)
            {
                biome.addStructure(RegistryHandler.HOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, RegistryHandler.PORTAL_RUIN.get().withConfiguration(config).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
            biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, RegistryHandler.HOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        }
    }
}
