package me.dkim19375.qotdy.commands;

import me.dkim19375.qotdy.utils.CommandHandler;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.HashSet;
import java.util.Set;

public class QOTDCommands extends CommandHandler {
    public QOTDCommands(JDA jda) {
        super(jda);
    }

    @Override
    public void onGuildMessageReceived(String cmd, String[] args, String prefix, String all, GuildMessageReceivedEvent event) {
        final Set<String> totalArgs = new HashSet<>();
        totalArgs.add("send");
        totalArgs.add("help");
        totalArgs.add("role");
        totalArgs.add("add");
        totalArgs.add("suggest");
        totalArgs.add("channel");
        if (!cmd.equalsIgnoreCase("qotd")) {
            return;
        }
        if (args.length < 1) {

            return;
        }
    }
}
