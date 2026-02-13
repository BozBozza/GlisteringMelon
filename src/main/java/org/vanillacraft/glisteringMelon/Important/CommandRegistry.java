package org.vanillacraft.glisteringMelon.Important;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import org.vanillacraft.glisteringMelon.AuctionHouse.AuctionHouseBidCmd;
import org.vanillacraft.glisteringMelon.AuctionHouse.AuctionHouseStartCmd;
import org.vanillacraft.glisteringMelon.AuctionHouse.AuctionHouseStopCmd;
import org.vanillacraft.glisteringMelon.DiamondLeaderboard.DiamondLeaderboardCmd;
import org.vanillacraft.glisteringMelon.Other.PlayTimeCmd;

public class CommandRegistry {
    public static void register(Commands r){
        r.register(Commands.literal("playtime")
                .then(Commands.argument("arg", ArgumentTypes.players())
                        .executes(PlayTimeCmd::execute))
                .build());

        r.register(Commands.literal("auctionhousestart")
                .executes(AuctionHouseStartCmd::execute)
                .build());

        r.register(Commands.literal("auctionhousestop")
                .executes(AuctionHouseStopCmd::execute)
                .build());

        r.register(Commands.literal("bid")
                .then(Commands.argument("amount", IntegerArgumentType.integer())
                        .executes(AuctionHouseBidCmd::execute))
                .build());

        r.register(Commands.literal("leaderboard")
                .executes(DiamondLeaderboardCmd::execute)
                .build());
    }
}
