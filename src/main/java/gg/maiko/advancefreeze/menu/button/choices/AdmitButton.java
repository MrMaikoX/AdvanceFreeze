package gg.maiko.advancefreeze.menu.button.choices;

import gg.maiko.advancefreeze.AdvanceFreeze;
import gg.maiko.advancefreeze.uitils.CC;
import net.frozenorb.qlib.menu.Button;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import java.util.List;

/**
 * Created by Maiko
 * Date: 10/20/2020
 */

public class AdmitButton extends Button {

    @Override
    public String getName(Player player) {
        return ChatColor.GREEN + "I admit to cheating";
    }

    @Override
    public List<String> getDescription(Player player) {
        return null;
    }

    @Override
    public Material getMaterial(Player player) {
        return Material.EMERALD_BLOCK;
    }

    @Override
    public void clicked(Player player, int i, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online.hasPermission("command.freeze") || online.isOp()) {
                    //TODO: ADD COOLDOWN
                    online.sendMessage(CC.translae(AdvanceFreeze.instance.getConfig().getString("lang.staff.admit")
                    .replace("%player%", player.getName())));

                }
            }
        }
    }

    @Override
    public boolean shouldCancel(Player player, int i, ClickType clickType) {
        return true;
    }
}
