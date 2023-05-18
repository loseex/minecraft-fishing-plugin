package losexds.minecraftfishingplugin.listener;

import losexds.minecraftfishingplugin.MinecraftFishingPlugin;
import losexds.minecraftfishingplugin.utils.GiveLootPlayer;
import losexds.minecraftfishingplugin.utils.Utils;

import losexds.minecraftfishingplugin.utils.СalculationSystem;
import org.bukkit.ChatColor;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;


public class EventsListener implements Listener {
    @EventHandler
    public void onFish (PlayerFishEvent e) {
        Player player = e.getPlayer();
        if (e.getState() == PlayerFishEvent.State.FISHING) {
            // Если нет разрешения fishing.fishing - то запрещаем рыбачить.
            if (!e.getPlayer().hasPermission("fishing.fishing")) {
                e.setCancelled(true);
                Utils.sendActionBar(e.getPlayer(), ChatColor.WHITE + Utils.readConfig("messages.permission"));
            }
            // Если настройка fishingOnlyOnBeach true - то можно рыбачить только на пляже.
            if (MinecraftFishingPlugin.getInstance().getConfig().getBoolean("settings.fishingOnlyOnBeach")) {
                // Если игрок вне пляжа, либо океана - то запрещаем использовать удочку.
                if (player.getLocation().getBlock().getBiome() != Biome.BEACH && player.getLocation().getBlock().getBiome() != Biome.OCEAN) {
                    e.setCancelled(true);
                    Utils.sendActionBar(e.getPlayer(), ChatColor.RED + Utils.readConfig("messages.alert"));
                }
            }
        }

        // Успех
        if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            e.getCaught().remove();
            GiveLootPlayer.give(e.getPlayer());
            Utils.sendActionBar(e.getPlayer(), ChatColor.GREEN + "+" + СalculationSystem.Calculation(1, e.getPlayer().getLevel()) + " xp");
        }

        // Провал
        if (e.getState() == PlayerFishEvent.State.FAILED_ATTEMPT) {
            e.getPlayer().sendMessage(ChatColor.RED + Utils.readConfig("messages.crush"));
            Utils.sendActionBar(e.getPlayer(), ChatColor.RED + "-" + СalculationSystem.Calculation(1, e.getPlayer().getLevel()) + " xp");
        }
    }
}
