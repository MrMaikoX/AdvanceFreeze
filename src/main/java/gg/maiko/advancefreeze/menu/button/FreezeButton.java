package gg.maiko.advancefreeze.menu.button;

import com.google.common.collect.Lists;
import gg.maiko.advancefreeze.AdvanceFreeze;
import gg.maiko.advancefreeze.uitils.CC;
import net.frozenorb.qlib.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import java.util.List;

/**
 * Created by Maiko
 * Date: 10/20/2020
 */

public class FreezeButton extends Button {

    @Override
    public String getName(Player player) {
        return CC.translae(AdvanceFreeze.instance.getConfig().getString("FreezeGUI.name"));
    }

    @Override
    public List<String> getDescription(Player player) {
        List<String> lore = Lists.newArrayList();
        lore.add("Join our teamspeak please :D");
        return lore;
    }

    @Override
    public Material getMaterial(Player player) {
        return Material.valueOf(AdvanceFreeze.instance.getConfig().getString("FreezeGUI.material"));
    }
}