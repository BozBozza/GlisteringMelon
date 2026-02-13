package org.vanillacraft.glisteringMelon.DiamondLeaderboard;

import java.util.Comparator;

public class PlayerDiamondComparator implements Comparator<PlayerDiamond> {
    @Override
    public int compare(PlayerDiamond o1, PlayerDiamond o2) {
        return o1.count - o2.count;
    }
}
