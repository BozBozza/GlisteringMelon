package org.vanillacraft.glisteringMelon.Important;

import org.bukkit.event.Listener;
import org.vanillacraft.glisteringMelon.DiamondLeaderboard.DiamondLeaveSave;
import org.vanillacraft.glisteringMelon.GlisteringMelon;

public class EventRegistry {
    public static void handle(Listener listener){
        GlisteringMelon.plugin.getServer().getPluginManager().registerEvents(listener, GlisteringMelon.plugin);
    }

    public static void register() {
        handle(new DiamondLeaveSave());
    }
}
