package dev.pns.offlineprisoncore.api;

import dev.pns.offlineprisoncore.data.model.PrisonPlayer;
import dev.pns.offlineprisoncore.data.storage.PlayerStorage;

import java.util.UUID;

public class StorageAPI {
    private PlayerStorage playerStorage;
    public StorageAPI(PlayerStorage playerStorage){
        this.playerStorage = playerStorage;
    }

    /**
     * Gets a player in the cache
     * @param uuid the uuid of the player to get
     * @return the player in the cache
     */
    public PrisonPlayer getPlayer(UUID uuid) {return playerStorage.getPlayer(uuid);}

    /**
     * Checks if a player is in the cache
     * @param uuid the uuid of the player to check
     * @return true if the player is in the cache, false otherwise
     */
    public boolean isCached(UUID uuid) {
        return playerStorage.isCached(uuid);
    }


}
