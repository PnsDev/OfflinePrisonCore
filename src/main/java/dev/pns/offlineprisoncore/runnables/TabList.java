package dev.pns.offlineprisoncore.runnables;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

import static dev.pns.offlineprisoncore.utils.ChatUtils.format;

public class TabList implements Runnable{

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            List<String> headerList = Arrays.asList(format("              &c&lOffline &d&lPrison              "), " ", format("&7Players: &a" + Bukkit.getOnlinePlayers().size() + "&8/&7" + Bukkit.getServer().getMaxPlayers()));
            List<String> footerList = Arrays.asList(" ", format("&8https://pns.dev"));
            TextComponent header = new TextComponent(String.join("\n", headerList));
            TextComponent footer = new TextComponent(String.join("\n", footerList));
            player.setPlayerListHeaderFooter(header, footer);
        }
    }
}
