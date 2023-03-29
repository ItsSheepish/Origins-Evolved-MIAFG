package net.miafg.evolved.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.miafg.evolved.EvolvedMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup MIAFG_EXCLUSIVE = FabricItemGroupBuilder.build(
            new Identifier(EvolvedMod.MOD_ID,"miafg"), () -> new ItemStack(
                    ModItems.EvolvePotionItem
            ));
}
