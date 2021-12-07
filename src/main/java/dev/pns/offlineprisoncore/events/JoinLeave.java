package dev.pns.offlineprisoncore.events;

import dev.pns.offlineprisoncore.data.model.PrisonPlayer;
import dev.pns.offlineprisoncore.data.storage.PlayerStorage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static dev.pns.offlineprisoncore.utils.ChatUtils.format;

public class JoinLeave implements Listener {

    private final PlayerStorage playerStorage;
    public JoinLeave(PlayerStorage playerStorage) {this.playerStorage = playerStorage;}

    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent e) { // Load player data
        // TODO: Attempt to get data from database
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        // Make new player if not loaded in
        if (!playerStorage.isCached(e.getPlayer().getUniqueId())) playerStorage.addPlayer(new PrisonPlayer(e.getPlayer()));

        e.setJoinMessage(format("&8[&a+&8] &7" + e.getPlayer().getName()));
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        e.setQuitMessage(format("&8[&c-&8] &7" + e.getPlayer().getName()));

        //TODO: Save player data to db

        playerStorage.removePlayer(e.getPlayer().getUniqueId());
    }
}
