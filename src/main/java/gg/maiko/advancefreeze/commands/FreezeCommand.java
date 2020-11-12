package gg.maiko.advancefreeze.commands;

import gg.maiko.advancefreeze.AdvanceFreeze;
import gg.maiko.advancefreeze.menu.FreezeMenu;
import gg.maiko.advancefreeze.uitils.CC;
import net.frozenorb.qlib.command.Command;
import net.frozenorb.qlib.command.Param;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

/**
 * Created by Maiko
 * Date: 10/20/2020
 */

public class FreezeCommand {

    @Command(names = "testfreeze", permission = "op")
    public static void test(Player player) {
        player.setMetadata("frozen", new FixedMetadataValue(AdvanceFreeze.instance, true));
        new FreezeMenu().openMenu(player);

    }

    // We use this code because some people
    // Don't like the /unfreeze so we did it like this.
    @Command(names = {"freeze", "ss"}, permission = "command.freeze")
    public static void freeze(CommandSender sender, @Param(name = "player")Player player) {
        if(player.hasMetadata("frozen")) {
            // This will tell everyone who has this certain permission that
            // the player is unfrozen.
            for(Player online : Bukkit.getOnlinePlayers()) {
                if (online.hasPermission("command.freeze")) {
                    online.sendMessage(CC.translae(AdvanceFreeze.instance.getConfig().getString("lang.staff.unfrozen")
                            .replace("%executor%", (sender) instanceof ConsoleCommandSender ? "CONSOLE" : sender.getName())
                            .replace("%target", player.getName())));
                }
                player.sendMessage(CC.translae(AdvanceFreeze.instance.getConfig().getString("lang.player.unfrozen")
                        .replace("%executor%", (sender) instanceof ConsoleCommandSender ? "CONSOLE" : sender.getName())));
                player.closeInventory();
            }

        } else {
            // if a player has a permission or if op they wont get frozen
            if (player.hasPermission("freeze.bypass") || player.isOp()) {
                sender.sendMessage(CC.translae(AdvanceFreeze.instance.getConfig().getString("lang.error")));
                return;
            }

            if (player.hasMetadata("frozen")) {
                sender.sendMessage(CC.translae("&cPlayer is already frozen"));
                return;
            }
            // This will tell everyone who has this certain permission that
            // the player is frozen by a certain staff member.
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online.hasPermission("command.freeze")) {
                    online.sendMessage(CC.translae(AdvanceFreeze.instance.getConfig().getString("lang.staff.frozen")
                            .replace("%executor%", (sender) instanceof ConsoleCommandSender ? "CONSOLE" : sender.getName())
                            .replace("%target", player.getName())));
                }
                player.setMetadata("frozen", new FixedMetadataValue(AdvanceFreeze.instance, true));
                new FreezeMenu().openMenu(player);

            }
        }
    }
}