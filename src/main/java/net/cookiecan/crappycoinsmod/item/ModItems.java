package net.cookiecan.crappycoinsmod.item;

import net.cookiecan.crappycoinsmod.CrappyCoinsMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item COPPER_COIN = registerItem("copper_coin",
            new Item(new FabricItemSettings().group(ModItemGroup.CRAPPYCOINSMOD)));

    public static final Item IRON_COIN = registerItem("iron_coin",
            new Item(new FabricItemSettings().group(ModItemGroup.CRAPPYCOINSMOD)));
    public static final Item GOLD_COIN = registerItem("gold_coin",
            new Item(new FabricItemSettings().group(ModItemGroup.CRAPPYCOINSMOD)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CrappyCoinsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CrappyCoinsMod.LOGGER.debug("Registering Mod Items for" + CrappyCoinsMod.MOD_ID);
    }
}