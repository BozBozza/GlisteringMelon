package org.vanillacraft.glisteringMelon.DiamondLeaderboard;

import org.bukkit.Material;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.jspecify.annotations.NonNull;

import static org.vanillacraft.glisteringMelon.Important.GlobalVariables.playerDiamonds;

public class DiamondLeaveSave implements Listener {
    @EventHandler
    public void onPlayerLeave(@NonNull PlayerQuitEvent event){
        int totaldiamonds = 0;
        Player player = event.getPlayer();

        Inventory inventory = player.getPlayer().getInventory();
        for (ItemStack item : inventory.getContents()) {
            if (item == null) {
                continue;
            }
            if (item.getType().equals(Material.DIAMOND)) {
                totaldiamonds = totaldiamonds + item.getAmount();
            }
            if (item.getType().equals(Material.DIAMOND_BLOCK)){
                totaldiamonds = totaldiamonds + (item.getAmount() * 9);
            }
            if (item.getItemMeta() instanceof BlockStateMeta im){
                if (im.getBlockState() instanceof ShulkerBox shulker){
                    for (ItemStack shulkeritem : shulker.getInventory().getContents()){
                        if (shulkeritem == null) {
                            continue;
                        }
                        if (shulkeritem.getType().equals(Material.DIAMOND)) {
                            totaldiamonds = totaldiamonds + shulkeritem.getAmount();
                        }
                        if (shulkeritem.getType().equals(Material.DIAMOND_BLOCK)){
                            totaldiamonds = totaldiamonds + (shulkeritem.getAmount() * 9);
                        }
                    }
                }
            }
        }
        Inventory enderchest = player.getPlayer().getEnderChest();
        for (ItemStack item : enderchest.getContents()) {
            if (item == null) {
                continue;
            }
            if (item.getType().equals(Material.DIAMOND)) {
                totaldiamonds = totaldiamonds + item.getAmount();
            }
            if (item.getType().equals(Material.DIAMOND_BLOCK)){
                totaldiamonds = totaldiamonds + (item.getAmount() * 9);
            }
            if (item.getItemMeta() instanceof BlockStateMeta im){
                if (im.getBlockState() instanceof ShulkerBox shulker){
                    for (ItemStack shulkeritem : shulker.getInventory().getContents()){
                        if (shulkeritem == null) {
                            continue;
                        }
                        if (shulkeritem.getType().equals(Material.DIAMOND)) {
                            totaldiamonds = totaldiamonds + shulkeritem.getAmount();
                        }
                        if (shulkeritem.getType().equals(Material.DIAMOND_BLOCK)){
                            totaldiamonds = totaldiamonds + (shulkeritem.getAmount() * 9);
                        }
                    }
                }
            }
        }
        playerDiamonds.put(player.getUniqueId(), totaldiamonds);
    }
}