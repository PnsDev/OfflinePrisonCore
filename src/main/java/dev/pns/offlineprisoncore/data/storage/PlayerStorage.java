package dev.pns.offlineprisoncore.data.storage;

import dev.pns.offlineprisoncore.data.model.PrisonPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerStorage {
    private final HashMap<UUID, PrisonPlayer> onlinePlayers = new HashMap<>();

    public PlayerStorage() {
        //TODO: move to runnable
        for (Player p : Bukkit.getOnlinePlayers()){
            //TODO: Add mongodb pull
            onlinePlayers.put(p.getUniqueId(), new PrisonPlayer(p));
        }
    }

    /**
     * Gets a player in the cache
     * @param p layer the player to get
     * @return the player in the cache
     */
    public PrisonPlayer getPlayer(Player p) {
        return getPlayer(p.getUniqueId());
    }

    /**
     * Gets a player in the cache
     * @param uuid the uuid of the player to get
     * @return the player in the cache
     */
    public PrisonPlayer getPlayer(UUID uuid) {return onlinePlayers.get(uuid);}

    /**
     * Adds a player to the cache
     * @param prisonPlayer the player to add
     */
    public void addPlayer(PrisonPlayer prisonPlayer) {
        onlinePlayers.put(prisonPlayer.getPlayer().getUniqueId(), prisonPlayer);
    }

    /**
     * Removes a player from the cache
     * @param uuid the uuid of the player to remove
     */
    public void removePlayer(UUID uuid) {
        onlinePlayers.remove(uuid);
    }

    /**
     * Checks if a player is in the cache
     * @param uuid the uuid of the player to check
     * @return true if the player is in the cache, false otherwise
     */
    public boolean isCached(UUID uuid) {
        return onlinePlayers.containsKey(uuid);
    }
}
