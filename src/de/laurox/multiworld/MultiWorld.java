package de.laurox.multiworld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiWorld extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aMultiWorld is enabled");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§cMultiWorld is disabled");
    }

}
