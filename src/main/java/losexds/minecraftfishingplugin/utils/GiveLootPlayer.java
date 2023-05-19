package losexds.minecraftfishingplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveLootPlayer {
    private ItemStack itemStack;

    public static void giveItem (Player player) {
        double chance = Math.random();
        player.sendMessage("chance:  " + chance);

        if (chance > 0.5) {
            ItemStack item = new ItemStack(Material.SALMON);
            player.getInventory().addItem(item);
            Utils.sendActionBar(player, ChatColor.WHITE + "Вы поймали " + ChatColor.GREEN + Material.SALMON.data.getName());
        }
        if (chance < 0.5) {
            ItemStack item = new ItemStack(Material.COD);
            player.getInventory().addItem(item);
            Utils.sendActionBar(player, ChatColor.WHITE + "Вы поймали " + ChatColor.GREEN + Material.COD.data.getName());
        }
        if (chance > 0.9) {
            ItemStack item = new ItemStack(Material.TROPICAL_FISH);
            player.getInventory().addItem(item);
            Utils.sendActionBar(player, ChatColor.WHITE + "Вы поймали " + ChatColor.GREEN + Material.TROPICAL_FISH.data.getName());
        }
    }

    public static double giveXp (Player player) {
        return 0.0;
    }
}
