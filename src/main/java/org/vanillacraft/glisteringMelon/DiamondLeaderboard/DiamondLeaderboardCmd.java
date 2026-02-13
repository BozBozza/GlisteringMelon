package org.vanillacraft.glisteringMelon.DiamondLeaderboard;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.vanillacraft.glisteringMelon.GlisteringMelon;
import org.vanillacraft.glisteringMelon.Important.GlobalVariables;

import java.util.ArrayList;
import java.util.UUID;

import static org.vanillacraft.glisteringMelon.Important.GlobalVariables.*;

public class DiamondLeaderboardCmd {
    public static int execute(CommandContext<CommandSourceStack> ctx) throws CommandSyntaxException {
        //ArrayList<Integer> scores = new ArrayList<Integer>();
        //for (int i = 0; i < 9; i++) {
        //    scores.add(0);
        //}
        //ArrayList<String> msgs = new ArrayList<String>();
        //for (UUID player : playerDiamonds.keySet()) {
        //    String playername = Bukkit.getOfflinePlayer(player).getName();
        //    for (int j = 0; j < 9; j++) {
        //        if (playerDiamonds.get(player) > scores.get(j)) {
        //            scores.set(j, playerDiamonds.get(player));
        //            String newmsg = (j + 1) + ") " + playername + " - " + playerDiamonds.get(player) + "\n";
        //            msgs.add(newmsg);
        //            break;
        //        }
        //    }
        //}
        //Component message = Component.empty();
        //for (int i = 0; i < leaderboardMsg.size(); i++) {
        //    message = message.append(Component.text(leaderboardMsg.get(i)));
        //}
        GlisteringMelon.plugin.getLogger().info(GlobalVariables.playerDiamonds.toString() );
        ctx.getSource().getSender().sendMessage(leaderboardMsg);
        return Command.SINGLE_SUCCESS;
    }
}