package losexds.minecraftfishingplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class EventsListener implements Listener {
    @EventHandler
    public void onJoin (PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(Objects.requireNonNull(MinecraftFishingPlugin.getInstance().getConfig().getString("messages.join")));
    }
}
