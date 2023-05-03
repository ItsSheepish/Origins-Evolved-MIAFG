package net.miafg.evolved.enchantment;

import net.miafg.evolved.config.ModConfigs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class Radiance extends Enchantment {
    public Radiance(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.ARMOR_HEAD, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            LivingEntity livingTarget = (LivingEntity) target;
            if (user.world.isSkyVisible(livingTarget.getBlockPos())) {
                boolean hasClearance = true;
                for (int i = 1; i < livingTarget.getHeight(); i++) {
                    if (!livingTarget.world.isAir(livingTarget.getBlockPos().up(i))) {
                        hasClearance = false;
                        break;
                    }
                }
                if (hasClearance) {
                    livingTarget.damage(DamageSource.mob(user), this.getAttackDamage(level,((LivingEntity)target).getGroup()));
                }
            }
        }
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        return 1.5f;
    }

    @Override
    public boolean isTreasure() {
        return ModConfigs.RADIANCE_TREASURE;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ModConfigs.RADIANCE_VILLAGER_TRADABLE;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }
}
