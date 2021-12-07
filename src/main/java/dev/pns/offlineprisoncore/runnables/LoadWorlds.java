package dev.pns.offlineprisoncore.runnables;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.File;

import static dev.pns.offlineprisoncore.utils.WorldUtils.*;

public class LoadWorlds implements Runnable{

    @Override
    public void run() {
        // Unload all worlds
        for(World world : Bukkit.getServer().getWorlds()){
            if (world.getName().startsWith("world")) continue;
            unloadWorld(world);
            deleteWorld(world.getWorldFolder());
        }

        // Load all worlds
        File folder = new File("maps");
        for(File file : folder.listFiles()){
            if(!file.isDirectory()) continue;
            copyWorld(file, new File(file.getName()));
            WorldCreator worldCreator = new WorldCreator(file.getName());
            worldCreator.createWorld();
        }
    }
}
