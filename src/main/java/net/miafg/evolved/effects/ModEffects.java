package net.miafg.evolved.effects;

import net.fabricmc.api.ModInitializer;
import net.miafg.evolved.EvolvedMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect KARMA;
    public static StatusEffect BLUE;

    public static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(EvolvedMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        KARMA = registerStatusEffect("karma", new KarmaEffect(StatusEffectCategory.HARMFUL, 13972953));
        BLUE = registerStatusEffect("blue_soul", new BlueSoulEffect(StatusEffectCategory.HARMFUL, 253));
    }
}
