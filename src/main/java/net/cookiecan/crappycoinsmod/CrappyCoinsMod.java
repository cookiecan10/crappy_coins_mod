package net.cookiecan.crappycoinsmod;

import net.cookiecan.crappycoinsmod.item.ModItems;
import net.cookiecan.crappycoinsmod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrappyCoinsMod implements ModInitializer {
	public static final String MOD_ID = "crappycoinsmod";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
	}
}
