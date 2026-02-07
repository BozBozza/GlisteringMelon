package org.vanillacraft.glisteringMelon;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.google.common.base.Ticker;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.command.brigadier.argument.ArgumentTypes;
import io.papermc.paper.command.brigadier.argument.resolvers.PlayerProfileListResolver;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.scanner.Constant;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;

public final class GlisteringMelon extends JavaPlugin {

    public static boolean auctionhouseOn = false;
    public static int highestBidAmount = 0;
    public static String highestBidPlayer = "";

    @Override
    public void onEnable() {
        Boolean auctionhouseon = false;
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS,commandregister->{
            commandregister.registrar().register(
                    Commands.literal("playtime")
                            .then(Commands.argument("arg", ArgumentTypes.players())
                                    .executes(GlisteringMelon::playtimeCommand))
                            .build());
            commandregister.registrar().register(
                    Commands.literal("scoreboard")
                            .executes(GlisteringMelon::scoreboardCommand)
                            .build());
            commandregister.registrar().register(
                    Commands.literal("auctionhousestart")
                            .executes(GlisteringMelon::auctionhousestartCommand)
                            .build());
            commandregister.registrar().register(
                    Commands.literal("auctionhousestop")
                            .executes(GlisteringMelon::auctionhousestopCommand)
                            .build());
            commandregister.registrar().register(
                    Commands.literal("bid")
                            .then(Commands.argument("amount", IntegerArgumentType.integer())
                                    .executes(GlisteringMelon::auctionhousebidCommand))
                            .build());
        });
    }

    public static int playtimeCommand(CommandContext<CommandSourceStack>ctx) throws CommandSyntaxException {
        Player executor = (Player)ctx.getSource().getExecutor();
        final PlayerSelectorArgumentResolver targetResolver = ctx.getArgument("arg", PlayerSelectorArgumentResolver.class);
        final List<Player> players = targetResolver.resolve(ctx.getSource());
        for(Player player: players){
            double playtimehours = (double) player.getStatistic(Statistic.TOTAL_WORLD_TIME) / 20 / 60 / 60;
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(2);
            String playtimeString = decimalFormat.format(playtimehours);
            Component message = Component.empty();
            message = message.append(player.name().color(NamedTextColor.GOLD));
            message = message.append(Component.text(" has spent ",NamedTextColor.GOLD));
            message = message.append(Component.text(playtimeString,NamedTextColor.GREEN));
            message = message.append(Component.text(" hours on the server ",NamedTextColor.GOLD));
            executor.sendMessage(message);
        }
        return Command.SINGLE_SUCCESS;
    }

    public static int scoreboardCommand(CommandContext<CommandSourceStack>ctx) throws CommandSyntaxException {
        OfflinePlayer[]allplayers = Bukkit.getOfflinePlayers();
        Player executor = (Player)ctx.getSource().getExecutor();
        double score1st = 0, score2nd = 0, score3rd = 0, score4th = 0, score5th = 0, score6th = 0, score7th = 0, score8th = 0, score9th = 0, score10th = 0;
        String msg1st = "", msg2nd = "", msg3rd = "", msg4th = "", msg5th = "", msg6th = "", msg7th = "", msg8th = "", msg9th = "", msg10th = "";
        for (OfflinePlayer player : allplayers) {
            double playtimehours = (double) player.getStatistic(Statistic.TOTAL_WORLD_TIME) / 20 / 60 / 60;
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(2);
            String playtimeString = decimalFormat.format(playtimehours);
            if(playtimehours > score1st){
                score1st = playtimehours;
                msg1st = player.getName() + " - " + playtimeString;
            }
            else if(playtimehours > score2nd){
                score2nd = playtimehours;
                msg2nd = player.getName() + " - " + playtimeString;
            }
            else if(playtimehours > score3rd){
                score3rd = playtimehours;
                msg3rd = player.getName() + " - " + playtimeString;
            }
            else if(playtimehours > score4th){
                score4th = playtimehours;
                msg4th = player.getName() + " - " + playtimeString;
            }
            else if(playtimehours > score5th){
                score5th = playtimehours;
                msg5th = player.getName() + " - " + playtimeString;
            }
            else if(playtimehours > score6th){
                score6th = playtimehours;
                msg6th = player.getName() + " - " + playtimeString;
            }
            else if(playtimehours > score7th){
                score7th = playtimehours;
                msg7th = player.getName() + " - " + playtimeString;
            }
            else if(playtimehours > score8th){
                score8th = playtimehours;
                msg8th = player.getName() + " - " + playtimeString;
            }
            else if(playtimehours > score9th){
                score9th = playtimehours;
                msg9th = player.getName() + " - " + playtimeString;
            }
            else if(playtimehours > score10th){
                score10th = playtimehours;
                msg10th = player.getName() + " - " + playtimeString;
            }
        }
        Component message = Component.empty();
        message = message.append(Component.text("----------\n"));
        message = message.append(Component.text("1- " + msg1st + "\n"));
        message = message.append(Component.text("2- " + msg2nd + "\n"));
        message = message.append(Component.text("3- " + msg3rd + "\n"));
        message = message.append(Component.text("4- " + msg4th + "\n"));
        message = message.append(Component.text("5- " + msg5th + "\n"));
        message = message.append(Component.text("6- " + msg6th + "\n"));
        message = message.append(Component.text("7- " + msg7th + "\n"));
        message = message.append(Component.text("8- " + msg8th + "\n"));
        message = message.append(Component.text("9- " + msg9th + "\n"));
        message = message.append(Component.text("10- " + msg10th + "\n"));
        message = message.append(Component.text("----------"));
        executor.sendMessage(message);
        return Command.SINGLE_SUCCESS;
    }

    public static int auctionhousestartCommand(CommandContext<CommandSourceStack>ctx) throws CommandSyntaxException{
        highestBidAmount = 0;
        highestBidPlayer = "";
        auctionhouseOn = true;
        Bukkit.getServer().sendMessage(Component.text("Auction house has started"));
        return Command.SINGLE_SUCCESS;
    }

    public static int auctionhousestopCommand(CommandContext<CommandSourceStack>ctx) throws CommandSyntaxException{
        auctionhouseOn = false;
        Bukkit.getServer().sendMessage(Component.text(highestBidPlayer + " has won the bid with " + highestBidAmount + " diamonds"));
        return Command.SINGLE_SUCCESS;
    }

    public static int auctionhousebidCommand(CommandContext<CommandSourceStack>ctx) throws CommandSyntaxException{
        if (auctionhouseOn == false){
            ctx.getSource().getSender().sendMessage(Component.text("Auction house not running at the moment"));
            return Command.SINGLE_SUCCESS;
        }
        else{
            String bidname = ctx.getSource().getSender().getName();
            int bidamount = ctx.getArgument("amount", Integer.class);
            if (bidamount > highestBidAmount){
                highestBidAmount = bidamount;
                highestBidPlayer = bidname;
                Bukkit.getServer().sendMessage(Component.text(highestBidPlayer + " has bid " + highestBidAmount + " diamonds"));
            }
            else {
                ctx.getSource().getSender().sendMessage(Component.text("Bid not high enough"));
            }
            return Command.SINGLE_SUCCESS;
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}


