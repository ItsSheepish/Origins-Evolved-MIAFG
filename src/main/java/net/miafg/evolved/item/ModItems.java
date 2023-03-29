package net.miafg.evolved.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.miafg.evolved.EvolvedMod;
import net.miafg.evolved.item.custom.EvolvePotionItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item EvolvePotionItem = registerItem("evolution_bottle",
            new EvolvePotionItem(new FabricItemSettings().group(ModItemGroup.MIAFG_EXCLUSIVE).maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(EvolvedMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        EvolvedMod.LOGGER.debug("Registering Mod Items for"+ EvolvedMod.MOD_ID);
    }
}
