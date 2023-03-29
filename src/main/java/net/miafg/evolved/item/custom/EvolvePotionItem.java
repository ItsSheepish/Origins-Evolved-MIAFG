package net.miafg.evolved.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class EvolvePotionItem extends Item {
    public EvolvePotionItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }
    public boolean isFood() {
        return true;
    }
    public int getUseDuration(ItemStack stack) {
        return 32;
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            //cooldown on use
            user.getItemCooldownManager().set(this, 1200);

            //output evolve success or fail
            outputEvolveMessage(user);
        }

        return super.use(world, user, hand);
    }

    private void outputEvolveMessage(PlayerEntity player) {
        if (getRandomNumber()==9) {
            player.sendMessage(Text.literal("You feel nothing start to change inside you. Perhaps you just need to try again..."));
        } else if (getRandomNumber()<10) {
            player.sendMessage(Text.literal("You feel your bones begin to strengthen, this could take some time..."));
        }
    }

    //gets a random number and stores to getRandomNumber
    private int getRandomNumber() {
        return Random.createLocal().nextInt(10);
    }
}
