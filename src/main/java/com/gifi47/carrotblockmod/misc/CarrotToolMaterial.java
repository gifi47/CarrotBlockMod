package com.gifi47.carrotblockmod.misc;

import com.gifi47.carrotblockmod.CarrotBlockMod;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CarrotToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 12;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1F;
    }

    @Override
    public float getAttackDamage() {
        return 1F;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.CARROT, Items.CARROT_ON_A_STICK, Items.GOLDEN_CARROT);
    }
}
