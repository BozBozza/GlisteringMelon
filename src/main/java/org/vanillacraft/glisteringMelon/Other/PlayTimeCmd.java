package org.vanillacraft.glisteringMelon.Other;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.argument.resolvers.selector.PlayerSelectorArgumentResolver;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.List;

public class PlayTimeCmd {
    public static int execute(CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
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
}
