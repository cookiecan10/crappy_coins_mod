package net.cookiecan.crappycoinsmod.item;

import net.cookiecan.crappycoinsmod.CrappyCoinsMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CRAPPYCOINSMOD = FabricItemGroupBuilder.build(new Identifier(CrappyCoinsMod.MOD_ID,
            "gold_coin"), () -> new ItemStack(ModItems.GOLD_COIN));
}
