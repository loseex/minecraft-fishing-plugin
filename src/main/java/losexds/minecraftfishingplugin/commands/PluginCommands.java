package losexds.minecraftfishingplugin.commands;

import losexds.minecraftfishingplugin.MinecraftFishingPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class PluginCommands extends AbstractCommands {
    public PluginCommands() {
        super("fishing");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.AQUA + "Try this: /" + label + " help");
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("fishing.reload")) {
                sender.sendMessage(ChatColor.RED + "You don't have permissions!");
                return;
            }

            MinecraftFishingPlugin.getInstance().reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "fishing plugin reloaded.");
            return;
        }

        sender.sendMessage(ChatColor.RED + "Unknown command: " + "/" + label + " " + args[0]);
        return;
    }
}
