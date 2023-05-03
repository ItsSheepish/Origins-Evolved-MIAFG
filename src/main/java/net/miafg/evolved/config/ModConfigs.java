package net.miafg.evolved.config;

import com.mojang.datafixers.util.Pair;
import net.miafg.evolved.EvolvedMod;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;


    //Tradable Enchantments
        public static boolean HAGGLER_VILLAGER_TRADABLE;
        public static boolean LIFESTEAL_VILLAGER_TRADABLE;
        public static boolean RADIANCE_VILLAGER_TRADABLE;
        public static boolean SPORE_VILLAGER_TRADABLE;
        public static boolean FROST_VILLAGER_TRADABLE;


    //Treasure Enchantments
        public static boolean HAGGLER_TREASURE;
        public static boolean LIFESTEAL_TREASURE;
        public static boolean RADIANCE_TREASURE;
        public static boolean SPORE_TREASURE;
        public static boolean FROST_TREASURE;


    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(EvolvedMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        //Villager Trading
            configs.addKeyValuePair(new Pair<>("haggler.tradable", false), "boolean | makes haggler enchantment able to be gained from villager tradings");
            configs.addKeyValuePair(new Pair<>("lifesteal.tradable", false), "boolean | makes lifesteal enchantment able to be gained from villager tradings");
            configs.addKeyValuePair(new Pair<>("radiance.tradable", false), "boolean | makes radiance enchantment able to be gained from villager tradings");
            configs.addKeyValuePair(new Pair<>("spore.tradable", false), "boolean | makes spore enchantment able to be gained from villager tradings");
            configs.addKeyValuePair(new Pair<>("frost.tradable", false), "boolean | makes frost enchantment able to be gained from villager tradings");
        //Treasure
            configs.addKeyValuePair(new Pair<>("haggler.treasure", false), "boolean | makes haggler enchantment able to be gained from loot tables");
            configs.addKeyValuePair(new Pair<>("lifesteal.treasure", false), "boolean | makes lifesteal enchantment able to be gained from loot tables");
            configs.addKeyValuePair(new Pair<>("radiance.treasure", false), "boolean | makes radiance enchantment able to be gained from loot tables");
            configs.addKeyValuePair(new Pair<>("spore.treasure", false), "boolean | makes spore enchantment able to be gained from loot tables");
            configs.addKeyValuePair(new Pair<>("frost.treasure", false), "boolean | makes frost enchantment able to be gained from loot tables");
    }

    private static void assignConfigs() {
        //Villager Trading
            HAGGLER_VILLAGER_TRADABLE = CONFIG.getOrDefault("haggler.tradable", false);
            LIFESTEAL_VILLAGER_TRADABLE = CONFIG.getOrDefault("lifesteal.tradable", false);
            RADIANCE_VILLAGER_TRADABLE = CONFIG.getOrDefault("lifesteal.tradable", false);
            SPORE_VILLAGER_TRADABLE = CONFIG.getOrDefault("lifesteal.tradable", false);
            FROST_VILLAGER_TRADABLE = CONFIG.getOrDefault("frost.tradable", false);
        //Treasure
            HAGGLER_TREASURE = CONFIG.getOrDefault("haggler.treasure", false);
            LIFESTEAL_TREASURE = CONFIG.getOrDefault("lifesteal.treasure", false);
            RADIANCE_TREASURE = CONFIG.getOrDefault("lifesteal.treasure", false);
            SPORE_TREASURE = CONFIG.getOrDefault("lifesteal.treasure", false);
            FROST_TREASURE = CONFIG.getOrDefault("frost.treasure", false);

        System.out.println("All " + configs.getConfigsList().size() +" "+ EvolvedMod.MOD_ID + " configs have been set properly");
    }
}