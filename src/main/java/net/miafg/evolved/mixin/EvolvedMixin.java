package net.miafg.evolved.mixin;

import net.miafg.evolved.EvolvedMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class EvolvedMixin {
	private void init(CallbackInfo info) {
		EvolvedMod.LOGGER.info("MIAFG Origins Is Back Baby!");
	}
}
