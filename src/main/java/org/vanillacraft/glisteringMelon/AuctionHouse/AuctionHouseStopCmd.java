package org.vanillacraft.glisteringMelon.AuctionHouse;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.vanillacraft.glisteringMelon.Important.GlobalVariables;

public class AuctionHouseStopCmd {
    public static int execute(CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        GlobalVariables.auctionhouseOn = false;
        Bukkit.getServer().sendMessage(Component.text(GlobalVariables.highestBidPlayer + " has won the bid with " + GlobalVariables.highestBidAmount + " diamonds"));
        return Command.SINGLE_SUCCESS;
    }
}
