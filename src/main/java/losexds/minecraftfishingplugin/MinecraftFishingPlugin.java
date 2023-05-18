package losexds.minecraftfishingplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import losexds.minecraftfishingplugin.commands.PluginCommands;

public final class MinecraftFishingPlugin extends JavaPlugin {
    private static MinecraftFishingPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        new PluginCommands();

        Bukkit.getPluginManager().registerEvents(new EventsListener(),this); // Events
    }

    @Override
    public void onDisable() {}

    public static MinecraftFishingPlugin getInstance() {return instance;}
}