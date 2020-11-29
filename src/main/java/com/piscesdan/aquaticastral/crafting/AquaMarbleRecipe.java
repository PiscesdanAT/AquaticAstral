package com.piscesdan.aquaticastral.crafting;

import com.piscesdan.aquaticastral.AquaticAstral;
import com.piscesdan.aquaticastral.util.RegistryHandler;
import hellfirepvp.astralsorcery.client.effect.function.VFXAlphaFunction;
import hellfirepvp.astralsorcery.client.effect.function.VFXColorFunction;
import hellfirepvp.astralsorcery.client.effect.handler.EffectHelper;
import hellfirepvp.astralsorcery.client.lib.EffectTemplatesAS;
import hellfirepvp.astralsorcery.common.crafting.nojson.starlight.LiquidStarlightRecipe;
import hellfirepvp.astralsorcery.common.lib.ColorsAS;
import hellfirepvp.astralsorcery.common.util.MiscUtils;
import hellfirepvp.astralsorcery.common.util.data.Vector3;
import hellfirepvp.astralsorcery.common.util.item.ItemUtils;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Collections;
import java.util.List;

public class AquaMarbleRecipe extends LiquidStarlightRecipe
{
    public AquaMarbleRecipe()
    {
        super(new ResourceLocation(AquaticAstral.MOD_ID, "aqua_marble"));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public List<Ingredient> getInputForRender() {
        return Collections.singletonList(Ingredient.fromItems(Blocks.PRISMARINE));
    }

    @Override
    public List<Ingredient> getOutputForRender() {
        return Collections.singletonList(Ingredient.fromItems(RegistryHandler.AQUA_MARBLE_RAW.get()));
    }

    @Override
    public boolean doesStartRecipe(ItemStack item) {
        return item.getItem().equals(Items.PRISMARINE);
    }

    @Override
    public boolean matches(ItemEntity trigger, World world, BlockPos at) {
        return true;
    }

    @Override
    public void doServerCraftTick(ItemEntity trigger, World world, BlockPos at) {
        if (getAndIncrementCraftingTick(trigger) > 10) {
            if (consumeItemEntityInBlock(world, at, 1, (ItemStack stack) -> !stack.isEmpty() && stack.getItem().equals(Items.PRISMARINE)) != null) {
                ItemUtils.dropItemNaturally(world, trigger.getPosX(), trigger.getPosY(), trigger.getPosZ(), new ItemStack(RegistryHandler.AQUA_MARBLE_RAW.get()));
            }
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void doClientEffectTick(ItemEntity trigger, World world, BlockPos at) {
        for (int i = 0; i < 4; i++) {
            Vector3 pos = new Vector3(at).add(0.5, 0.5, 0.5);
            MiscUtils.applyRandomOffset(pos, rand, 0.5F);

            EffectHelper.of(EffectTemplatesAS.GENERIC_PARTICLE)
                    .spawn(pos)
                    .color(VFXColorFunction.constant(ColorsAS.DYE_CYAN))
                    .alpha(VFXAlphaFunction.PYRAMID)
                    .setScaleMultiplier(0.1F + rand.nextFloat() * 0.1F)
                    .setMaxAge(30 + rand.nextInt(20));
        }
    }
}
