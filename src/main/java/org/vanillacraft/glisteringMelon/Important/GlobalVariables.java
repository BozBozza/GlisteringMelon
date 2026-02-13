package org.vanillacraft.glisteringMelon.Important;

import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GlobalVariables {
    public static boolean auctionhouseOn = false;
    public static int highestBidAmount = 0;
    public static String highestBidPlayer = "";
    public static HashMap<UUID, Integer> playerDiamonds = new HashMap<>();
    public static Component leaderboardMsg;
}
