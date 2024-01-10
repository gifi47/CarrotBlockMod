package com.gifi47.carrotblockmod.enchantments;

import com.gifi47.carrotblockmod.misc.CarrotToolMaterial;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;

public class EffectiveEatingEnchantment extends Enchantment {
    public EffectiveEatingEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.BREAKABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinLevel(){
        return 1;
    }

    @Override
    public int getMaxLevel(){
        return 3;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        ToolItem item = (ToolItem)stack.getItem();
        if (item != null) {
            return item.getMaterial() instanceof CarrotToolMaterial;
        }
        return false;
    }

    public boolean canEnchant(ItemStack stack){
        return false;
    }
}
