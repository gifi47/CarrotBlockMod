package com.gifi47.carrotblockmod.misc;

import com.gifi47.carrotblockmod.CarrotBlockMod;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ToolMaterial;

public class PlatinumToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 192;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.5F;
    }

    @Override
    public float getAttackDamage() {
        return 1F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 3;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(CarrotBlockMod.PLATINUM_BAR_ITEM);
    }
}