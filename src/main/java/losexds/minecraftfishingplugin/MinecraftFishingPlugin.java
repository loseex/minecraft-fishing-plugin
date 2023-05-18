package losexds.minecraftfishingplugin;

import losexds.minecraftfishingplugin.listener.EventsListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import losexds.minecraftfishingplugin.commands.PluginCommands;

public final class MinecraftFishingPlugin extends JavaPlugin {
    private static MinecraftFishingPlugin instance;
    private Storage storage;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        storage = new Storage("items.yml");

        new PluginCommands();

        Bukkit.getPluginManager().registerEvents(new EventsListener(),this); // Events
    }

    @Override
    public void onDisable() {}

    public static MinecraftFishingPlugin getInstance() {return instance;}

    public static Storage getStorage() {
        return instance.storage;
    }
}