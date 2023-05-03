package net.miafg.evolved.enchantment;

import net.miafg.evolved.config.ModConfigs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.random.Random;

public class Spore extends Enchantment {

    public Spore(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.ARMOR_CHEST, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        Random random = user.getRandom();
        if (!user.world.isClient()) {
            if (attacker instanceof LivingEntity) {
                if (Spore.shouldDamageAttacker(level, random)) {
                    ((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 40 + (2 * (level * 10)), (level - 1), false, true));
                }
            }
        }
        super.onTargetDamaged(user, attacker, level);
    }

    @Override
    public boolean isTreasure() {
        return ModConfigs.SPORE_TREASURE;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ModConfigs.SPORE_VILLAGER_TRADABLE;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }

    public static boolean shouldDamageAttacker(int level, Random random) {
        if (level <= 0) {
            return false;
        }
        return random.nextFloat() < 0.15f * (float)level;
    }
}