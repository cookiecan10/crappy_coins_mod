package net.cookiecan.crappycoinsmod.util;

import net.cookiecan.crappycoinsmod.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

//    private static final Identifier GRASS_BLOCK_ID
//            = new Identifier("minecraft", "blocks/grass");
//    private static final Identifier CREEPER_ID
//            = new Identifier("minecraft", "entities/creeper");
    private static final Identifier ENDER_DRAGON_ID
            = new Identifier("minecraft", "entities/ender_dragon");
    private static final Identifier WITHER_ID
            = new Identifier("minecraft", "entities/ender_dragon");
    private static final Identifier ELDER_GUARDIAN_ID
            = new Identifier("minecraft", "entities/elder_guardian");
    private static final Identifier WARDEN_ID
            = new Identifier("minecraft", "entities/warden");

    private static final Identifier[] COPPER_COIN_CHESTS = {
            new Identifier("minecraft", "chests/end_city_treasure"),
            new Identifier("minecraft", "chests/shipwreck_treasure"),
            new Identifier("minecraft", "chests/ruined_portal"),
            new Identifier("minecraft", "chests/igloo_chest"),
            new Identifier("minecraft", "chests/ancient_city"),
            new Identifier("minecraft", "chests/buried_treasure"),
            new Identifier("minecraft", "chests/desert_pyramid"),
            new Identifier("minecraft", "chests/woodland_mansion"),
            new Identifier("minecraft", "chests/nether_bridge"),
            new Identifier("minecraft", "chests/bastion_treasure"),
            new Identifier("minecraft", "chests/ancient_city"),
            new Identifier("minecraft", "chests/abandoned_mineshaft"),
            new Identifier("minecraft", "chests/jungle_temple")
    };

    private static void modifyCopperCoinChestLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            for (Identifier i : COPPER_COIN_CHESTS) {
                if(i.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.9f)) // 100% of the time
                            .with(ItemEntry.builder(ModItems.COPPER_COIN))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build()); // It will drop either 1 or 2
                    tableBuilder.pool(poolBuilder.build());
                }
            }
        });
    }

    public static void modifyLootTables() {
        modifyCopperCoinChestLootTables();
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if(ENDER_DRAGON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% of the time
                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(20.0f, 40.0f)).build()); // It will drop between 20 and 40
                tableBuilder.pool(poolBuilder.build());
            }
            if(WITHER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% of the time
                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(15.0f, 30.0f)).build()); // It will drop between 20 and 40
                tableBuilder.pool(poolBuilder.build());
            }
            if(ELDER_GUARDIAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% of the time
                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(15.0f, 30.0f)).build()); // It will drop between 20 and 40
                tableBuilder.pool(poolBuilder.build());
            }
            if(WARDEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% of the time
                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
//            if(GRASS_BLOCK_ID.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(0.35f)) // 35% of the time it will drop something
//                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()); // It will drop either 1 or 2
//                tableBuilder.pool(poolBuilder.build());
//            }
//            if(IGLOO_STRUCTURE_CHEST_ID.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% of the time
//                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()); // It will drop either 1 or 2
//                tableBuilder.pool(poolBuilder.build());
//            }
//            if(RUINED_PORTAL_ID.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% of the time
//                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()); // It will drop either 1 or 2
//                tableBuilder.pool(poolBuilder.build());
//            }
//            if(END_CITY_TREASURE_ID.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% of the time
//                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()); // It will drop either 1 or 2
//                tableBuilder.pool(poolBuilder.build());
//            }
//            if(SHIP_WRECK_TREASURE.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% of the time
//                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()); // It will drop either 1 or 2
//                tableBuilder.pool(poolBuilder.build());
//            }

//            if(CREEPER_ID.equals(id)) {
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // 100% of the time
//                        .with(ItemEntry.builder(ModItems.COPPER_COIN))
//                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER,
//                                        new EntityPredicate.Builder().equipment(EntityEquipmentPredicate.Builder.create()
//                                                .mainhand(ItemPredicate.Builder.create().items(Items.GOLDEN_SWORD).build()).build()).build())) // but only if killed with a gold sword
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()); // It will drop either 1 or 2
//                tableBuilder.pool(poolBuilder.build());
//            }

        });
    }

}
