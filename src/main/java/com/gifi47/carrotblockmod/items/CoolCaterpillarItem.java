package com.gifi47.carrotblockmod.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;

public class CoolCaterpillarItem extends Item {
    public CoolCaterpillarItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // default white text
        tooltip.add(Text.translatable("item.carrotblockmod.cool_caterpillar_item.tooltip_line_1"));

        // formatted red text
        tooltip.add(Text.translatable("item.carrotblockmod.cool_caterpillar_item.tooltip_line_2").formatted(Formatting.RED));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_BELL_USE, 4.0F, 2.0F);
        var pos = raycast(world, playerEntity, RaycastContext.FluidHandling.NONE).getBlockPos().toCenterPos();
        world.createExplosion(playerEntity, pos.x, pos.y, pos.z, 6f, true, World.ExplosionSourceType.BLOCK);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
