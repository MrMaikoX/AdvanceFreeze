package gg.maiko.advancefreeze.listener;

import gg.maiko.advancefreeze.AdvanceFreeze;
import gg.maiko.advancefreeze.menu.FreezeMenu;
import gg.maiko.advancefreeze.menu.button.choices.refuse.DontAdmitMenu;
import gg.maiko.advancefreeze.uitils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Maiko
 * Date: 10/20/2020
 */

public class FreezeListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(e.getPlayer().hasMetadata("frozen")) {
            Bukkit.getServer().getOnlinePlayers().forEach(
                    staff -> staff.hasPermission("command.freeze"));

        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (e.getPlayer().hasMetadata("frozen")) {
            e.getPlayer().removeMetadata("frozen", AdvanceFreeze.instance);
            for (Player staff : Bukkit.getOnlinePlayers()) {
                if (staff.hasPermission("command.freeze")) {
                    staff.sendMessage("");
                    staff.sendMessage(CC.translae("&c&l" + e.getPlayer().getName()) + "&ehas &4&lLOGOUT &ewhile frozen!");
                    staff.sendMessage("");
                }
            }
        }
    }


    @EventHandler
    public void onEntityHit(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if(player.hasMetadata("frozen")) {
                e.setCancelled(true);
            }
        }
    }
//
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (e.getInventory() != null && e.getPlayer().hasMetadata("frozen") && e.getInventory().getTitle().contains(
                CC.translae(AdvanceFreeze.instance.getConfig().getString("FreezeGUI.title")))) {
            new FreezeMenu().openMenu((Player) e.getPlayer());
            return;
        }
        if (e.getPlayer().hasMetadata("frozen") && e.getInventory().getTitle().contains(
                CC.translae(AdvanceFreeze.instance.getConfig().getString("FreezeGUI.denied-title")))) {
            new DontAdmitMenu().openMenu((Player) e.getPlayer());
        }
    }

//        new BukkitRunnable() {
//            public void run() {
//                if (e.getPlayer().hasMetadata("frozen") && e.getInventory().getTitle().equals(CC.translae(AdvanceFreeze.instance.getConfig().getString("FreezeGUI.title")))) {
//                    new FreezeMenu().openMenu((Player) e.getPlayer());
//                }
//            }
//        }.runTaskTimer(AdvanceFreeze.instance, 2L, 2L);
//    }


    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e) {
        if(e.getPlayer().hasMetadata("frozen")) {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onBlockPlace(BlockBreakEvent e) {
        if(e.getPlayer().hasMetadata("frozen")) {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onBuild(BlockPlaceEvent e) {
        if(e.getPlayer().hasMetadata("frozen")) {
            e.setCancelled(true);

        }
    }
}
