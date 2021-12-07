package dev.pns.offlineprisoncore.events;

import dev.pns.offlineprisoncore.data.model.Location;
import dev.pns.offlineprisoncore.data.storage.PlayerStorage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class DisableEvents implements Listener {
    private final PlayerStorage playerStorage;
    public DisableEvents(PlayerStorage playerStorage) {
        this.playerStorage = playerStorage;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        //TODO: add world support
        if (!playerStorage.getPlayer(e.getPlayer()).getLastLocation().equals(Location.WORLD))
            e.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        //TODO: add world support
        if (!playerStorage.getPlayer(e.getPlayer()).getLastLocation().equals(Location.WORLD))
            e.setCancelled(true);
    }
}
