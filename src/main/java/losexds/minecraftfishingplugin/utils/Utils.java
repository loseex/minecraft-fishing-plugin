package losexds.minecraftfishingplugin.utils;

import losexds.minecraftfishingplugin.MinecraftFishingPlugin;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class Utils {

    // Вывод ActionBar для игрока.
    public static void sendActionBar(Player player, String text) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(text));
    }


    // Чтение значений из конфига.
    public static String readConfig(String value) {
        return MinecraftFishingPlugin.getInstance().getConfig().getString(value);
    }
}
