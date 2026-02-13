package org.vanillacraft.glisteringMelon.DiamondLeaderboard;

import java.util.Comparator;
import java.util.UUID;

public class PlayerDiamond {
    public UUID uuid;
    public int count;

    public PlayerDiamond(UUID uuid, int count) {
        this.uuid = uuid;
        this.count = count;
    }
}
