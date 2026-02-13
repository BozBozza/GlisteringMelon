package org.vanillacraft.glisteringMelon.AuctionHouse;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.vanillacraft.glisteringMelon.Important.GlobalVariables;

public class AuctionHouseBidCmd {
    public static int execute(CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        int maxbid = 0;
        Player player = (Player)ctx.getSource().getExecutor();
        if (GlobalVariables.auctionhouseOn == false) {
            ctx.getSource().getSender().sendMessage(Component.text("Auction house not running at the moment"));
            return Command.SINGLE_SUCCESS;
        } else {
            String bidname = ctx.getSource().getSender().getName();
            int bidamount = ctx.getArgument("amount", Integer.class);
            Inventory inventory = player.getInventory();
            for (ItemStack item : inventory.getContents()) {
                if (item == null) {
                    continue;
                }
                if (item.getType().equals(Material.DIAMOND)) {
                    maxbid = maxbid + item.getAmount();
                }
            }
            if (bidamount > maxbid) {
                ctx.getSource().getSender().sendMessage(Component.text("You do not have enough diamonds to bid that amount"));
                return Command.SINGLE_SUCCESS;
            } else {
                if (bidamount > GlobalVariables.highestBidAmount) {
                    GlobalVariables.highestBidAmount = bidamount;
                    GlobalVariables.highestBidPlayer = bidname;
                    Bukkit.getServer().sendMessage(Component.text(GlobalVariables.highestBidPlayer + " has bid " + GlobalVariables.highestBidAmount + " diamonds"));
                } else {
                    ctx.getSource().getSender().sendMessage(Component.text("Bid not high enough"));
                }
            }
        }
        return Command.SINGLE_SUCCESS;
    }
}