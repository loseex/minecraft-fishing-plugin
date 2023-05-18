package losexds.minecraftfishingplugin.listener;

import losexds.minecraftfishingplugin.MinecraftFishingPlugin;
import losexds.minecraftfishingplugin.utils.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class EventsListener implements Listener {
    @EventHandler
    public void onJoin (PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(Objects.requireNonNull(MinecraftFishingPlugin.getInstance().getConfig().getString("messages.join")));
    }

    @EventHandler
    public void onFish (PlayerFishEvent e) {
        if (e.getState() == PlayerFishEvent.State.FISHING) {
            if (!e.getPlayer().hasPermission("fishing.fishing")) {
                e.setCancelled(true);
                Utils.sendActionBar(e.getPlayer(), ChatColor.WHITE + "У вас нет лицензии!");
            }
        }

        if (e.getState() == PlayerFishEvent.State.FAILED_ATTEMPT) {
            Utils.sendActionBar(e.getPlayer(), ChatColor.RED + "Вы упустили рыбу!");
        }
        if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            Utils.sendActionBar(e.getPlayer(), ChatColor.GREEN + "Вы что-то поймали!");
        }
    }
}
