package gg.maiko.advancefreeze.menu;

import gg.maiko.advancefreeze.AdvanceFreeze;
import gg.maiko.advancefreeze.menu.button.FreezeButton;
import gg.maiko.advancefreeze.menu.button.choices.AdmitButton;
import gg.maiko.advancefreeze.menu.button.choices.DontAdmitButton;
import gg.maiko.advancefreeze.uitils.CC;
import net.frozenorb.qlib.menu.Button;
import net.frozenorb.qlib.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maiko
 * Date: 10/20/2020
 */

public class FreezeMenu extends Menu {

    public FreezeMenu() {
        this.setNoncancellingInventory(true);
    }

    @Override
    public String getTitle(Player player) {
        return CC.translae(AdvanceFreeze.instance.getConfig().getString("FreezeGUI.title"));
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();
        buttons.put(0, new AdmitButton());
        buttons.put(8, new DontAdmitButton());
        return buttons;
    }

}
