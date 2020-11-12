package gg.maiko.advancefreeze.commands;

import gg.maiko.advancefreeze.AdvanceFreeze;
import gg.maiko.advancefreeze.uitils.CC;
import net.frozenorb.qlib.command.Command;
import net.frozenorb.qlib.command.Param;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Maiko
 * Date: 10/20/2020
 */

public class UnFreezeCommand {

    @Command(names = "unfreeze", permission = "command.unfreeze")
    public static void unfreeze(CommandSender sender, @Param(name = "player") Player player) {
        if (player.hasMetadata("frozen")) {
            player.closeInventory();
            player.removeMetadata("frozen", AdvanceFreeze.instance);
        } else {
            sender.sendMessage(CC.translae(AdvanceFreeze.instance.getConfig().getString("lang.not-frozen")
                    .replace("%player%", player.getName())));
        }
    }
}
