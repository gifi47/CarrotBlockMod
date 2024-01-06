package com.gifi47.carrotblockmod.items;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class CoolCaterpillarItem extends Item {
    public CoolCaterpillarItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_BELL_USE, 4.0F, 2.0F);
        var pos = raycast(world, playerEntity, RaycastContext.FluidHandling.NONE).getBlockPos().toCenterPos();
        world.createExplosion(playerEntity, pos.x, pos.y, pos.z, 6f, true, World.ExplosionSourceType.BLOCK);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
