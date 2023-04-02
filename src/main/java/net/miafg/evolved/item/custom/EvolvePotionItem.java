package net.miafg.evolved.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EvolvePotionItem extends Item {
    public EvolvePotionItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            stack.decrement(1);
        }
        if (!world.isClient()) {
            //remove all potion effect
            user.clearStatusEffects();
        }
        if (!world.isClient()) {
            //output evolve success or fail
            outputEvolveMessage((PlayerEntity)user);
        }
        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        }

        return stack;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Drink the potion to start the evolution process").formatted(Formatting.WHITE));
        } else {
            tooltip.add(Text.literal("Hold shift for more info!").formatted(Formatting.WHITE));
        }
    }

    private void outputEvolveMessage(PlayerEntity player) {
        if (getRandomNumber()==9) {
            player.sendMessage(Text.literal("You feel nothing start to change inside you. Perhaps you just need to try again..."));
        } else if (getRandomNumber()==10)  {
            player.sendMessage(Text.literal("You feel nothing start to change inside you. Perhaps you just need to try again..."));
        } else if (getRandomNumber()<9) {
            player.sendMessage(Text.literal("You feel your bones begin to strengthen, this could take some time..."));
        }
    }

    //gets a random number and stores to getRandomNumber
    private int getRandomNumber() {
        return Random.createLocal().nextInt(10);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    //deletes item
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
