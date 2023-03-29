package net.miafg.evolved;

import net.fabricmc.api.ModInitializer;
import net.miafg.evolved.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EvolvedMod implements ModInitializer {
	public static final String MOD_ID = "evolved";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
