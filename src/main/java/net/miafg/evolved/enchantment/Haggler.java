package net.miafg.evolved.enchantment;

import net.miafg.evolved.config.ModConfigs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class Haggler extends Enchantment {

    public Haggler(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 15 + (level - 1) * 9;
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isTreasure() {
        return ModConfigs.HAGGLER_TREASURE;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ModConfigs.HAGGLER_VILLAGER_TRADABLE;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }
}
