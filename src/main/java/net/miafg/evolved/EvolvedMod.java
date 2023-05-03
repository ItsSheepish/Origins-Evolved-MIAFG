package net.miafg.evolved;

import net.fabricmc.api.ModInitializer;
import net.miafg.evolved.config.ModConfigs;
import net.miafg.evolved.effects.ModEffects;
import net.miafg.evolved.enchantment.ModEnchants;
import net.miafg.evolved.item.ModItems;
import net.miafg.evolved.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EvolvedMod implements ModInitializer {
	public static final String MOD_ID = "evolved";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();

		ModItems.registerModItems();
		ModEnchants.registerModEnchantments();

		ModEffects.registerEffects();

		ModLootTableModifiers.modifyLootTables();
	}
}
