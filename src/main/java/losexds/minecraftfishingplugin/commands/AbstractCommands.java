package losexds.minecraftfishingplugin.commands;

import losexds.minecraftfishingplugin.MinecraftFishingPlugin;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractCommands implements CommandExecutor {
    public AbstractCommands (String command) {
        PluginCommand pluginCommand = MinecraftFishingPlugin.getInstance().getCommand(command);
        if (pluginCommand != null) {
            pluginCommand.setExecutor(this);
        }
    }

    public abstract void execute (CommandSender sender, String label, String[] args);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        execute(sender, label, args);
        return true;
    }
}
