package com.gifi47.carrotblockmod.entities;

import com.gifi47.carrotblockmod.client.CarrotBlockModClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CarrotEntityRenderer extends MobEntityRenderer<CarrotEntity, CarrotEntityModel> {
    public CarrotEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CarrotEntityModel(context.getPart(CarrotBlockModClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CarrotEntity entity) {
        return new Identifier("carrotblockmod", "textures/entity/carrot_entity/carrot_entity.png");
    }
}
