package net.miafg.evolved.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
public class Lifesteal extends Enchantment {

    public Lifesteal(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
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
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40+(level*10), 0, true, false));
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 40+(level*10), 0, true, false));
            if (level == 3) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 40+(level*10), 0, true, false));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 40+(level*10), 0, true, false));
            }
        }

        super.onTargetDamaged(user, target, level);
    }
}
