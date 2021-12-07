package dev.pns.offlineprisoncore.commands;

import dev.pns.offlineprisoncore.OfflinePrisonCore;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Message implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        // Parse arguments
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage(OfflinePrisonCore.prefix + "You need to specify a player to message!");
            return false;
        } else if (args.length == 1) {
            p.sendMessage(OfflinePrisonCore.prefix + "You need to specify a message!");
            return false;
        }

        // Find the player
        Player recipient = Bukkit.getPlayer(args[0]);
        if (recipient == null) {
            p.sendMessage(OfflinePrisonCore.prefix + "That player is not online!");
            return false;
        }

        // Lol
        if (recipient.equals(p)) {
            p.sendMessage(OfflinePrisonCore.prefix + ":(");
            return false;
        }

        // Send the message
        recipient.sendMessage("§f" + p.getName() + "§d -> §fYou§d > &7" + String.join(" ", Arrays.copyOfRange(args, 1, args.length)));
        p.sendMessage("§fYou §d -> §f" + recipient.getName() + "§d > &7" + String.join(" ", Arrays.copyOfRange(args, 1, args.length)));
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
        recipient.playSound(recipient.getLocation(), Sound.NOTE_PLING, 1, 1);
        return true;
    }
}
