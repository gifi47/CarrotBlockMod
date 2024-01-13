package com.gifi47.carrotblockmod.client;

import com.gifi47.carrotblockmod.CarrotBlockMod;
import com.gifi47.carrotblockmod.entities.CarrotEntityModel;
import com.gifi47.carrotblockmod.entities.CarrotEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class CarrotBlockModClient implements ClientModInitializer {

    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(
            new Identifier("carrotblockmod", "carrot_entity"), "main");

    @Override
    public void onInitializeClient() {
        /*
         * Registers our Cube Entity's renderer, which provides a model and texture for the entity.
         *
         * Entity Renderers can also manipulate the model before it renders based on entity context (EndermanEntityRenderer#render).
         */
        EntityRendererRegistry.INSTANCE.register(CarrotBlockMod.CARROT_ENTITY, (context) -> {
            return new CarrotEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, CarrotEntityModel::getTexturedModelData);
    }
}
