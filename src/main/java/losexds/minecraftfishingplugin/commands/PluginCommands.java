package losexds.minecraftfishingplugin.commands;

import losexds.minecraftfishingplugin.MinecraftFishingPlugin;
import losexds.minecraftfishingplugin.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class PluginCommands extends AbstractCommands {
    public PluginCommands() {
        super("fishing");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Utils.readConfig("messages.prefix") + ChatColor.AQUA + "Try this: /" + label + " help");
            return;
        }

        if (args[0].equalsIgnoreCase("help")) {
            if (!sender.hasPermission("fishing.settings")) {
                sender.sendMessage(Utils.readConfig("messages.prefix") + "");
                return;
            } else {
                sender.sendMessage(Utils.readConfig("messages.prefix") + "");
                return;
            }
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("fishing.reload")) {
                sender.sendMessage(Utils.readConfig("messages.prefix") + ChatColor.RED + Utils.readConfig("messages.permission"));
                return;
            }

            MinecraftFishingPlugin.getInstance().reloadConfig();
            sender.sendMessage(Utils.readConfig("messages.prefix") + ChatColor.GREEN + Utils.readConfig("messages.reload"));
            return;
        }

        if (args[0].equalsIgnoreCase("stats")) {
            String user = sender.getName();
            return;
        }


        sender.sendMessage(Utils.readConfig("messages.prefix") + ChatColor.RED + "Unknown command: " + "/" + label + " " + args[0]);
        return;
    }
}
