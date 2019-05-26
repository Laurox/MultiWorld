package de.laurox.multiworld;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileManager {
    private static FileConfiguration config;
    private static File configFile;
    private static FileConfiguration textConfig;
    private static File textConfigFile;
    //private static FileConfiguration worldsConfig;
    //private static File worldsConfigFile;

    private static String language;

    public static void fileSetup(MultiWorld plugin) {
        //setup MultiWorld Config
        configFile = new File("plugins/MultiWorld", "config.yml");
        configFile.getParentFile().mkdirs();
        config = YamlConfiguration.loadConfiguration(configFile);
        config.addDefault("language", "en");
        config.addDefault("showPrefix", true);
        config.addDefault("prefixFormat", "[%prefix%]");
        config.options().copyDefaults(true);
        saveConfig();

        //load text config
        textConfigFile = new File("plugins/MultiWorld", config.getString("language")+".yml");
        if(!textConfigFile.exists()) {
            try {
                InputStream input = FileManager.class.getResource(config.getString("language")+".yml").openStream();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        textConfig = YamlConfiguration.loadConfiguration(textConfigFile);
        language = config.getString("language");
    }

    public static void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static void reloadTextConfig() {
        if(!language.equalsIgnoreCase(config.getString("language")))
            textConfigFile = new File("plugin/MultiWorld", config.getString("language") + ".yml");
            textConfig = YamlConfiguration.loadConfiguration(textConfigFile);
    }

    public static void reloadAll() {
        reloadConfig();
        reloadTextConfig();
    }

    /*
        GETTER
     */

    public static FileConfiguration getConfig() {
        return config;
    }

    public static FileConfiguration getTextConfig() {
        return textConfig;
    }
}
