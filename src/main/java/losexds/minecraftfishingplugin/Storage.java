package losexds.minecraftfishingplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Storage {
    private File file;
    private FileConfiguration config;

    public Storage(String name) {
        file = new File(MinecraftFishingPlugin.getInstance().getDataFolder(), name);
        try {
            if (!file.exists() && !file.createNewFile()) throw new IOException();
        }
        catch (IOException e) {
            throw new RuntimeException("Failed create file " + name + ".yml", e);
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }

    public void save () {
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save config.", e);
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
