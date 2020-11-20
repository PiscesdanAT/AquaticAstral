package com.piscesdan.aquaticastral.world.structures.pieces;

import com.piscesdan.aquaticastral.AquaticAstral;
import com.piscesdan.aquaticastral.util.RegistryHandler;
import com.piscesdan.aquaticastral.world.structures.AquaRuinsConfig;
import com.piscesdan.aquaticastral.world.structures.StructurePortalRuin;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.IFluidState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.*;

import java.util.List;
import java.util.Random;

public class PortalRuinPiece
{
    private static final ResourceLocation STRUCTURE = new ResourceLocation(AquaticAstral.MOD_ID, "portal_ruin");

    public static void func_204041_a(TemplateManager templateManagerIn, BlockPos pos, Rotation rotationIn, List<StructurePiece> pieces, Random rand, AquaRuinsConfig config)
    {
        func_204045_a(templateManagerIn, pos, rotationIn, pieces, rand, config);
    }

    private static void func_204045_a(TemplateManager manager, BlockPos pos, Rotation rotation, List<StructurePiece> pieces, Random rand, AquaRuinsConfig config)
    {
        pieces.add(new PortalRuinPiece.Piece(manager, STRUCTURE, pos, rotation, 0.8F, config.type));
    }

    public static class Piece extends TemplateStructurePiece
    {
        private final StructurePortalRuin.Type biomeType;
        private final float integrity;
        private final ResourceLocation templateName;
        private final Rotation rotation;

        public Piece(TemplateManager manager, ResourceLocation templateName, BlockPos pos, Rotation rotation, float integrity, StructurePortalRuin.Type biomeType)
        {
            super(RegistryHandler.PORTAL_RUIN_PIECE, 0);
            this.templateName = templateName;
            this.templatePosition = pos;
            this.rotation = rotation;
            this.integrity = integrity;
            this.biomeType = biomeType;
            this.setup(manager);
        }

        public Piece(TemplateManager manager, CompoundNBT nbt)
        {
            super(RegistryHandler.PORTAL_RUIN_PIECE, nbt);
            this.templateName = new ResourceLocation(nbt.getString("Template"));
            this.rotation = Rotation.valueOf(nbt.getString("Rot"));
            this.integrity = nbt.getFloat("integrity");
            this.biomeType = StructurePortalRuin.Type.valueOf(nbt.getString("BiomeType"));
            this.setup(manager);
        }

        private void setup(TemplateManager manager)
        {
            Template template = manager.getTemplateDefaulted(this.templateName);
            PlacementSettings settings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, settings);
        }

        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        protected void readAdditional(CompoundNBT tagCompound)
        {
            super.readAdditional(tagCompound);
            tagCompound.putString("Template", this.templateName.toString());
            tagCompound.putString("Rot", this.rotation.name());
            tagCompound.putFloat("Integrity", this.integrity);
            tagCompound.putString("BiomeType", this.biomeType.toString());
        }

        @Override
        protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb)
        {

        }

        /**
         * Create Structure Piece
         *
         * @param worldIn world
         * @param chunkGeneratorIn chunkGenerator
         * @param randomIn random
         * @param mutableBoundingBoxIn mutableBoundingBox
         * @param chunkPosIn chunkPos
         */
        public boolean create(IWorld world, ChunkGenerator<?> generator, Random rand, MutableBoundingBox boundingBox, ChunkPos chunkPos)
        {
            this.placeSettings.clearProcessors().addProcessor(new IntegrityProcessor(this.integrity)).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
            int i = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, this.templatePosition.getX(), this.templatePosition.getZ());
            this.templatePosition = new BlockPos(this.templatePosition.getX(), i, this.templatePosition.getZ());
            BlockPos pos = Template.getTransformedPos(new BlockPos(this.template.getSize().getX() - 1, 0, this.template.getSize().getZ() - 1), Mirror.NONE, this.rotation, BlockPos.ZERO).add(this.templatePosition);
            this.templatePosition = new BlockPos(this.templatePosition.getX(), this.func_204035_a(this.templatePosition, world, pos), this.templatePosition.getZ());
            return super.create(world, generator, rand, boundingBox, chunkPos);
        }

        private int func_204035_a(BlockPos templatePos, IBlockReader blockReaderIn, BlockPos templateTransformedPos)
        {
            int i = templatePos.getY();
            int j = 512;
            int k = i - 1;
            int l = 0;

            for(BlockPos blockpos : BlockPos.getAllInBoxMutable(templatePos, templateTransformedPos)) {
                int i1 = blockpos.getX();
                int j1 = blockpos.getZ();
                int k1 = templatePos.getY() - 1;
                BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(i1, k1, j1);
                BlockState blockstate = blockReaderIn.getBlockState(blockpos$mutable);

                for(IFluidState ifluidstate = blockReaderIn.getFluidState(blockpos$mutable); (blockstate.isAir() || ifluidstate.isTagged(FluidTags.WATER) || blockstate.getBlock().isIn(BlockTags.ICE)) && k1 > 1; ifluidstate = blockReaderIn.getFluidState(blockpos$mutable)) {
                    --k1;
                    blockpos$mutable.setPos(i1, k1, j1);
                    blockstate = blockReaderIn.getBlockState(blockpos$mutable);
                }

                j = Math.min(j, k1);
                if (k1 < k - 2) {
                    ++l;
                }
            }

            int l1 = Math.abs(templatePos.getX() - templateTransformedPos.getX());
            if (k - j > 2 && l > l1 - 2) {
                i = j + 1;
            }

            return i;
        }
    }
}
