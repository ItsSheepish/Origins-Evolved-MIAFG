package net.miafg.evolved.enchantment;

import net.miafg.evolved.config.ModConfigs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Frost extends Enchantment {

    public Frost(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            if (target instanceof LivingEntity) {
                LivingEntity livingTarget = (LivingEntity) target;
                livingTarget.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200+(200*(level/2)), 9,true,false));
                livingTarget.setFrozenTicks(200+(200*(level/2)));
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public boolean isTreasure() {
        return ModConfigs.FROST_TREASURE;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ModConfigs.FROST_VILLAGER_TRADABLE;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }
}
