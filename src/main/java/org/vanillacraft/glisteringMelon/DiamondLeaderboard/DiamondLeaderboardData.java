package org.vanillacraft.glisteringMelon.DiamondLeaderboard;

import org.bukkit.configuration.file.YamlConfiguration;
import org.vanillacraft.glisteringMelon.GlisteringMelon;
import org.vanillacraft.glisteringMelon.Important.GlobalVariables;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DiamondLeaderboardData {
    public static void save() {
        YamlConfiguration yaml = new YamlConfiguration();
        for (UUID uuid : GlobalVariables.playerDiamonds.keySet()) {
            yaml.set(uuid.toString(), GlobalVariables.playerDiamonds.get(uuid));
        }
        try {
            yaml.save(new File(GlisteringMelon.plugin.getDataFolder(), "diamond-leaderboard.yml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load() {
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(new File(GlisteringMelon.plugin.getDataFolder(), "diamond-leaderboard.yml"));
        for (String uuidString : yaml.getKeys(false)) {
            UUID uuid = UUID.fromString(uuidString);
            int diamondCount = yaml.getInt(uuidString);
            GlobalVariables.playerDiamonds.put(uuid, diamondCount);
        }
    }
}

/*

ABCDEF-12356-323421-12343: 59
ABCDEF-12356-323421-12343: 59
ABCDEF-12356-323421-12343: 59
ABCDEF-12356-323421-12343: 59
ABCDEF-12356-323421-12343: 59
ABCDEF-12356-323421-12343: 59
ABCDEF-12356-323421-12343: 59

 */