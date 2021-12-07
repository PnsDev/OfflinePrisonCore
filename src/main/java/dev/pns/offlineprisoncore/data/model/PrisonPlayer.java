package dev.pns.offlineprisoncore.data.model;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;

@Getter
@Setter
public class PrisonPlayer {

    // Basic player management
    private final Player player;
    private final ArrayList<Rank> ranks = new ArrayList<>();
    private final ArrayList<String> extraPerms = new ArrayList<>();
    private Location lastLocation = Location.HUB;

    // Currency System
    private int coins = 0;

    // Mine Stuff
    private int mine = 0;
    private int prestigeLevel = 0;

    // Stats
    private int blocksMined = 0;

    //TODO: store world here? maybe just id?

    public PrisonPlayer(Player player) {
        this.player = player;
    }
}
