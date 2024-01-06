package com.gifi47.carrotblockmod;

import com.gifi47.carrotblockmod.items.CoolCaterpillarItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarrotBlockMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

    //public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f));

    public static final Item RENO_LOGAN_ITEM = new Item(new FabricItemSettings().food(FoodComponents.BAKED_POTATO));
    public static final Item PLATINUM_BAR_ITEM = new Item(new FabricItemSettings());
    public static final Item COOL_CATERPILLAR_ITEM = new CoolCaterpillarItem(new FabricItemSettings());
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "reno_logan_item"), RENO_LOGAN_ITEM);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_bar_item"), PLATINUM_BAR_ITEM);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "cool_caterpillar_item"), COOL_CATERPILLAR_ITEM);
        FuelRegistry.INSTANCE.add(COOL_CATERPILLAR_ITEM, 300);
    }
}
