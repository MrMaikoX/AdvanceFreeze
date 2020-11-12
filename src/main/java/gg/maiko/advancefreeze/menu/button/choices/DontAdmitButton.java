package gg.maiko.advancefreeze.menu.button.choices;

import gg.maiko.advancefreeze.menu.button.choices.refuse.DontAdmitMenu;
import net.frozenorb.qlib.menu.Button;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import java.util.List;

/**
 * Created by Maiko
 * Date: 10/20/2020
 */

public class DontAdmitButton extends Button {

    @Override
    public String getName(Player player) {
        return ChatColor.RED + "I don't to cheating";
    }

    @Override
    public List<String> getDescription(Player player) {
        return null;
    }

    @Override
    public Material getMaterial(Player player) {
        return Material.REDSTONE_BLOCK;
    }

    @Override
    public void clicked(Player player, int i, ClickType clickType) {
        if (clickType.isRightClick() || clickType.isLeftClick()) {
            new DontAdmitMenu().openMenu(player);

        }
    }

    @Override
    public boolean shouldCancel(Player player, int i, ClickType clickType) {
        return true;
    }
}
