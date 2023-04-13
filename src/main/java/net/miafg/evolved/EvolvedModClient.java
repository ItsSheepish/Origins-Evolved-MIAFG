package net.miafg.evolved;

import net.fabricmc.api.ClientModInitializer;
import net.miafg.evolved.event.KeyInputHandler;

public class EvolvedModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
