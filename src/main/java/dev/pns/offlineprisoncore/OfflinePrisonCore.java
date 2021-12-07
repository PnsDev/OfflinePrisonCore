package dev.pns.offlineprisoncore;

import dev.pns.offlineprisoncore.api.StorageAPI;
import dev.pns.offlineprisoncore.commands.Debug;
import dev.pns.offlineprisoncore.commands.Message;
import dev.pns.offlineprisoncore.data.storage.PlayerStorage;
import dev.pns.offlineprisoncore.events.DisableEvents;
import dev.pns.offlineprisoncore.events.JoinLeave;
import dev.pns.offlineprisoncore.runnables.LoadWorlds;
import dev.pns.offlineprisoncore.runnables.TabList;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class OfflinePrisonCore extends JavaPlugin {

    public static String prefix = "§dOfflinePrison > §7";
    public static StorageAPI storageAPI;

    private PlayerStorage playerStorage;

    @Override
    public void onEnable() { // Plugin startup logic
        //TODO: clean up this mess
        this.playerStorage = new PlayerStorage();
        storageAPI = new StorageAPI(this.playerStorage);

        Bukkit.getScheduler().runTask(this, new LoadWorlds());

        // Tp all players
        World hub = Bukkit.getWorld("hub");
        if (hub == null) Bukkit.getLogger().severe("Could not find world 'hub'");
        else {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.teleport(hub.getSpawnLocation());
            }
        }

        registerCommands();
        registerEvents();
        registerRunnables();
    }

    @Override
    public void onDisable() { // Plugin shutdown logic
        //TODO: do not forget to close db connection
        playerStorage = null;
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new JoinLeave(this.playerStorage), this);
        Bukkit.getPluginManager().registerEvents(new DisableEvents(this.playerStorage), this);
    }

    public void registerCommands() {
        Bukkit.getPluginCommand("debug").setExecutor(new Debug());
        Bukkit.getPluginCommand("message").setExecutor(new Message());
    }

    public void registerRunnables() {
        Bukkit.getScheduler().runTaskTimer(this, new TabList(), 0, 20);
    }
}
