package net.miafg.evolved.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.miafg.evolved.effects.ModEffects;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.Map;

public class KeyInputHandler {
    public static final String Key_Open_GUI = "key.evolved.evolution.tree";

    public static KeyBinding GUI_Key;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(client.player != null && hasCustomEffect(client.player)){
                if(GUI_Key.isPressed()){
                    if (score < MAX_SCORE) {
                        score++;
                        delayTime = 0;
                    }
                } else if (score > 0) {
                    delayTime++;
                    client.player.setVelocity(client.player.getVelocity().x, 0.1*(score/5), client.player.getVelocity().z);
                    if (delayTime >= 10) {
                        client.player.sendMessage(Text.of("Player moved upwards by "+score/5));
                        score = 0;
                        delayTime = 0;
                    }
                }
            } else {
                if (score > 0){
                    score = 0;
                }
            }
        });
    }
    public static void register(){
        GUI_Key = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                Key_Open_GUI,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UP,
                "MIAFG Origins"
        ));

        registerKeyInputs();
    }

    private static int score;
    private static final int MAX_SCORE = 25;
    private static int delayTime;

    private static boolean hasCustomEffect(LivingEntity entity) {
        for (Map.Entry<StatusEffect, StatusEffectInstance> entry : entity.getActiveStatusEffects().entrySet()) {
            if (entry.getKey() == ModEffects.BLUE) {
                return true;
            }
        }
        return false;
    }
}
