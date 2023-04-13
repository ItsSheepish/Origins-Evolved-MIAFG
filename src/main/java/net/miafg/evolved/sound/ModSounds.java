package net.miafg.evolved.sound;

import net.miafg.evolved.EvolvedMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent MEGALOVANIA = registerSoundEvent("megalovania");

    public static SoundEvent GHOST = registerSoundEvent("ghostfight");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(EvolvedMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT,id,new SoundEvent(id));
    }
}
