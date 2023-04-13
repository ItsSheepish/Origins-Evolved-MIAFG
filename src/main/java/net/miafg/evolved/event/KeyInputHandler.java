package net.miafg.evolved.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String Key_Open_GUI = "key.evolved.evolution.tree";

    public static KeyBinding GUI_Key;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(GUI_Key.wasPressed()){
                client.player.sendMessage(Text.of("This button currently does nothing - it is purely here for gameplay testing in an early build of the mod!"));
            }
        });
    }
    public static void register(){
        GUI_Key = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                Key_Open_GUI,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_P,
                Key_Open_GUI
        ));

        registerKeyInputs();
    }
}
