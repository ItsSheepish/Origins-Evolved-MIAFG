package net.miafg.evolved.enchantment;

import net.miafg.evolved.EvolvedMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchants {
    public static Enchantment LIFESTEAL = register("lifesteal",
            new Lifesteal(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.WEAPON,
                    new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static Enchantment SPORE = register("spore",
            new Spore(Enchantment.Rarity.VERY_RARE,
                    EquipmentSlot.CHEST));
    public static Enchantment RADIANCE = register("radiance",
            new Radiance(Enchantment.Rarity.VERY_RARE,
                    EquipmentSlot.HEAD));

    public static Enchantment HAGGLER = register("haggler",
            new Haggler(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.FISHING_ROD,
                    new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));

    public static Enchantment FROST = register("frost",
            new Frost(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.BOW,
                    new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(EvolvedMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + EvolvedMod.MOD_ID);
    }
}
