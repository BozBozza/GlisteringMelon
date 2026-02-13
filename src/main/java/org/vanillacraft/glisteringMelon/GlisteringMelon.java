package org.vanillacraft.glisteringMelon;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.vanillacraft.glisteringMelon.DiamondLeaderboard.DiamondLeaderboardData;
import org.vanillacraft.glisteringMelon.DiamondLeaderboard.PlayerDiamond;
import org.vanillacraft.glisteringMelon.DiamondLeaderboard.PlayerDiamondComparator;
import org.vanillacraft.glisteringMelon.Important.CommandRegistry;
import org.vanillacraft.glisteringMelon.Important.EventRegistry;
import org.vanillacraft.glisteringMelon.Important.GlobalVariables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.vanillacraft.glisteringMelon.Important.GlobalVariables.leaderboardMsg;
import static org.vanillacraft.glisteringMelon.Important.GlobalVariables.playerDiamonds;

public final class GlisteringMelon extends JavaPlugin {
    public static GlisteringMelon plugin;

    @Override
    public void onEnable() {
        GlisteringMelon.plugin = this;
        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, registry -> CommandRegistry.register(registry.registrar()));
        EventRegistry.register();
        DiamondLeaderboardData.load();

        ArrayList<PlayerDiamond> playerDiamonds = new ArrayList<>();

        for (UUID uuid : GlobalVariables.playerDiamonds.keySet()) {
            int count = GlobalVariables.playerDiamonds.get(uuid);
            playerDiamonds.add(new PlayerDiamond(uuid, count));
        }

        playerDiamonds.sort(new PlayerDiamondComparator());
        playerDiamonds = new ArrayList<>(playerDiamonds.reversed());

        for (int i = 0; i < Math.min(playerDiamonds.size(), 10); i++) {
            UUID uuid = playerDiamonds.get(i).uuid;
            int count = playerDiamonds.get(i).count;
            String name = Bukkit.getOfflinePlayer(uuid).getName();
            leaderboardMsg = leaderboardMsg.append(Component.text(i+1 + ") " + name + " - " + count + " diamonds \n"));
        }
    }

    @Override
    public void onDisable() {
        DiamondLeaderboardData.save();
    }
}