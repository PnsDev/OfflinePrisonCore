package dev.pns.offlineprisoncore.utils;

import org.bukkit.ChatColor;

public class ChatUtils {
    public static String format(String m) {
        return ChatColor.translateAlternateColorCodes('&', m);
    }
}
