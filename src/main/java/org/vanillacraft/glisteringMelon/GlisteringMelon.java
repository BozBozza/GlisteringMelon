package org.vanillacraft.glisteringMelon;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.vanillacraft.glisteringMelon.Important.CommandRegistry;
import org.vanillacraft.glisteringMelon.Important.EventRegistry;

import java.util.ArrayList;
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

        ArrayList<Integer> scores = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            scores.add(0);
        }
        ArrayList<String> msgs = new ArrayList<String>();
        for (UUID player : playerDiamonds.keySet()) {
            String playername = Bukkit.getOfflinePlayer(player).getName();
            for (int j = 0; j < 9; j++) {
                if (playerDiamonds.get(player) > scores.get(j)) {
                    scores.set(j, playerDiamonds.get(player));
                    String newmsg = (j + 1) + ") " + playername + " - " + playerDiamonds.get(player) + "\n";
                    msgs.add(newmsg);
                    break;
                }
            }
        }
        leaderboardMsg = Component.empty();
        for (int i = 0; i < msgs.size(); i++) {
            leaderboardMsg = leaderboardMsg.append(Component.text(msgs.get(i)));
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}