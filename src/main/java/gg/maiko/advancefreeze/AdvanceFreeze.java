package gg.maiko.advancefreeze;

import gg.maiko.advancefreeze.listener.FreezeListener;
import net.frozenorb.qlib.command.FrozenCommandHandler;
import net.frozenorb.qlib.qLib;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Maiko
 * Date: 10/20/2020
 */

public class AdvanceFreeze extends JavaPlugin {

    public static AdvanceFreeze instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
        registerCommands();
        Bukkit.getPluginManager().registerEvents(new FreezeListener(), this);
    }

    private void registerCommands() {
        FrozenCommandHandler.registerAll(this);
        Bukkit.getPluginManager().registerEvents(new FreezeListener(), this);

    }

    @Override
    public void onDisable() {
        instance = null;
        saveConfig();
    }


}
