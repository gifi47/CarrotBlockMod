package com.gifi47.carrotblockmod;

import com.gifi47.carrotblockmod.blocks.ChargeableBlock;
import com.gifi47.carrotblockmod.enchantments.EffectiveEatingEnchantment;
import com.gifi47.carrotblockmod.entities.CarrotEntity;
import com.gifi47.carrotblockmod.items.CoolCaterpillarItem;
import com.gifi47.carrotblockmod.misc.CarrotToolMaterial;
import com.gifi47.carrotblockmod.misc.PlatinumArmorMaterial;
import com.gifi47.carrotblockmod.misc.PlatinumToolMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarrotBlockMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("carrotblockmod");

    public static final Block CARROT_BLOCK = new Block(FabricBlockSettings.create().strength(1.45f).burnable().sounds(
            new BlockSoundGroup(1f, 1f,
                    SoundEvents.BLOCK_CROP_BREAK,
                    SoundEvents.BLOCK_SPONGE_STEP,
                    SoundEvents.ITEM_CROP_PLANT,
                    SoundEvents.BLOCK_WART_BLOCK_HIT,
                    SoundEvents.BLOCK_WART_BLOCK_FALL)));
    public static final Block PLATINUM_BLOCK = new Block(FabricBlockSettings.create().strength(4f).sounds(
            new BlockSoundGroup(1f, 1f,
                    SoundEvents.BLOCK_METAL_BREAK,
                    SoundEvents.BLOCK_METAL_STEP,
                    SoundEvents.BLOCK_METAL_PLACE,
                    SoundEvents.BLOCK_METAL_HIT,
                    SoundEvents.BLOCK_METAL_FALL)));

    public static final Block PLATINUM_ELECTRO_BLOCK = new ChargeableBlock(FabricBlockSettings.create().strength(4f).sounds(
            new BlockSoundGroup(1f, 1f,
                    SoundEvents.BLOCK_METAL_BREAK,
                    SoundEvents.BLOCK_METAL_STEP,
                    SoundEvents.BLOCK_METAL_PLACE,
                    SoundEvents.BLOCK_METAL_HIT,
                    SoundEvents.BLOCK_METAL_FALL)));

    public static final Item RENO_LOGAN_ITEM = new Item(new FabricItemSettings().food(FoodComponents.BAKED_POTATO));
    public static final Item PLATINUM_BAR_ITEM = new Item(new FabricItemSettings());
    public static final Item COOL_CATERPILLAR_ITEM = new CoolCaterpillarItem(new FabricItemSettings());

    public static final ArmorMaterial PLATINUM_ARMOR_MATERIAL = new PlatinumArmorMaterial();
    public static final Item PLATINUM_HELMET = new ArmorItem(PLATINUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item PLATINUM_CHESTPLATE = new ArmorItem(PLATINUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item PLATINUM_LEGGINGS = new ArmorItem(PLATINUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item PLATINUM_BOOTS = new ArmorItem(PLATINUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());

    public static final PlatinumToolMaterial PLATINUM_TOOL_MATERIAL = new PlatinumToolMaterial();
    public static ToolItem PLATINUM_PICKAXE = new PickaxeItem(PLATINUM_TOOL_MATERIAL, 3, -2.8F, new FabricItemSettings());
    public static ToolItem PLATINUM_AXE = new AxeItem(PLATINUM_TOOL_MATERIAL, 9.0F, -3.1F, new FabricItemSettings());
    public static ToolItem PLATINUM_HOE = new HoeItem(PLATINUM_TOOL_MATERIAL, 1, -2.4F, new FabricItemSettings());
    public static ToolItem PLATINUM_SWORD = new SwordItem(PLATINUM_TOOL_MATERIAL, 7, -2.2F, new FabricItemSettings());
    public static ToolItem PLATINUM_SHOVEL = new ShovelItem(PLATINUM_TOOL_MATERIAL, 2, -2.8F, new FabricItemSettings());

    public static final CarrotToolMaterial CARROT_TOOL_MATERIAL = new CarrotToolMaterial();
    public static ToolItem CARROT_PICKAXE = new PickaxeItem(CARROT_TOOL_MATERIAL, 1, -3F, new FabricItemSettings().food(FoodComponents.CARROT));
    public static ToolItem CARROT_AXE = new AxeItem(CARROT_TOOL_MATERIAL, 5.0F, -3.4F, new FabricItemSettings().food(FoodComponents.CARROT));
    public static ToolItem CARROT_HOE = new HoeItem(CARROT_TOOL_MATERIAL, 1, -2.8F, new FabricItemSettings().food(FoodComponents.CARROT));
    public static ToolItem CARROT_SWORD = new SwordItem(CARROT_TOOL_MATERIAL, 5, -2.8F, new FabricItemSettings().food(FoodComponents.CARROT));
    public static ToolItem CARROT_SHOVEL = new ShovelItem(CARROT_TOOL_MATERIAL, 1, -3F, new FabricItemSettings().food(FoodComponents.CARROT));

    public static Enchantment EFFECTIVE_EATING_ENCHANTMENT = new EffectiveEatingEnchantment();

    private static final ItemGroup SUS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(COOL_CATERPILLAR_ITEM))
            .displayName(Text.translatable("itemGroup.carrotblockmod.sus_group"))
            .entries((context, entries) -> {
                entries.add(COOL_CATERPILLAR_ITEM);
                entries.add(RENO_LOGAN_ITEM);
                entries.add(PLATINUM_BAR_ITEM);
                entries.add(PLATINUM_HELMET);
                entries.add(PLATINUM_CHESTPLATE);
                entries.add(PLATINUM_LEGGINGS);
                entries.add(PLATINUM_BOOTS);
                entries.add(PLATINUM_PICKAXE);
                entries.add(PLATINUM_AXE);
                entries.add(PLATINUM_SWORD);
                entries.add(PLATINUM_SHOVEL);
                entries.add(PLATINUM_HOE);
                entries.add(CARROT_PICKAXE);
                entries.add(CARROT_AXE);
                entries.add(CARROT_SWORD);
                entries.add(CARROT_SHOVEL);
                entries.add(CARROT_HOE);
                entries.add(CARROT_BLOCK);
                entries.add(PLATINUM_BLOCK);
                entries.add(PLATINUM_ELECTRO_BLOCK);
            })
            .build();

    private static final ItemGroup BARS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.IRON_INGOT))
            .displayName(Text.translatable("itemGroup.carrotblockmod.bars_group"))
            .entries((context, entries) -> {
                entries.add(Items.IRON_INGOT);
                entries.add(Items.BRICK);
                entries.add(Items.NETHER_BRICK);
                entries.add(Items.COPPER_INGOT);
                entries.add(Items.GOLD_INGOT);
                entries.add(PLATINUM_BAR_ITEM);
            })
            .build();

    public static final EntityType<CarrotEntity> CARROT_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("carrotblockmod", "carrot_entity"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CarrotEntity::new).dimensions(
                    EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        Registry.register(Registries.BLOCK, new Identifier("carrotblockmod", "carrot_block"), CARROT_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "carrot_block"),
                new BlockItem(CARROT_BLOCK, new FabricItemSettings().food(new FoodComponent.Builder().hunger(7).saturationModifier(0.6f).build())));
        Registry.register(Registries.BLOCK, new Identifier("carrotblockmod", "platinum_block"), PLATINUM_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_block"),
                new BlockItem(PLATINUM_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("carrotblockmod", "platinum_electro_block"), PLATINUM_ELECTRO_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_electro_block"),
                new BlockItem(PLATINUM_ELECTRO_BLOCK, new FabricItemSettings()));


        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "reno_logan_item"), RENO_LOGAN_ITEM);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_bar_item"), PLATINUM_BAR_ITEM);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "cool_caterpillar_item"), COOL_CATERPILLAR_ITEM);
        FuelRegistry.INSTANCE.add(COOL_CATERPILLAR_ITEM, 300);

        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_helmet"), PLATINUM_HELMET);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_chestplate"), PLATINUM_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_leggings"), PLATINUM_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_boots"), PLATINUM_BOOTS);

        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_axe"), PLATINUM_AXE);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_pickaxe"), PLATINUM_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_shovel"), PLATINUM_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_sword"), PLATINUM_SWORD);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "platinum_hoe"), PLATINUM_HOE);

        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "carrot_axe"), CARROT_AXE);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "carrot_pickaxe"), CARROT_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "carrot_shovel"), CARROT_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "carrot_sword"), CARROT_SWORD);
        Registry.register(Registries.ITEM, new Identifier("carrotblockmod", "carrot_hoe"), CARROT_HOE);

        Registry.register(Registries.ENCHANTMENT,
                new Identifier("carrotblockmod", "effective_eating_enchantment"), EFFECTIVE_EATING_ENCHANTMENT);

        Registry.register(Registries.ITEM_GROUP, new Identifier("carrotblockmod", "sus_group"), SUS_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, new Identifier("carrotblockmod", "bars_group"), BARS_ITEM_GROUP);

        FabricDefaultAttributeRegistry.register(CARROT_ENTITY, CarrotEntity.createMobAttributes());
    }
}
