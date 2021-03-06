package me.dkim19375.qotdy.utils;

import me.dkim19375.dkim19375jdautils.holders.MessageRecievedHolder;
import me.dkim19375.qotdy.QOTDYBot;
import me.dkim19375.qotdy.configuration.Configs;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler extends ListenerAdapter {
    private final JDA jda;

    public CommandHandler(JDA jda) {
        this.jda = jda;
    }

    @Nullable
    public MessageRecievedHolder getMessage(@NotNull String message) {
        final String prefix;
        if (message.startsWith(jda.getSelfUser().getAsMention().replaceFirst("@", "@!"))) {
            prefix = jda.getSelfUser().getAsMention().replaceFirst("@", "@!");
        } else {
            if (message.toLowerCase().startsWith(QOTDYBot.getFileManager().getConfig().get(Configs.PREFIX).toLowerCase())) {
                prefix = QOTDYBot.getFileManager().getConfig().get(Configs.PREFIX);
            } else {
                return null;
            }
        }
        if (message.length() <= prefix.length()) {
            return null;
        }
        String command = message;
        command = command.substring(prefix.length());
        command = command.trim();
        final String[] allArray = command.split(" ");
        command = command.split(" ")[0];
        List<String> argsList = new ArrayList<>();
        boolean first = true;
        for (String s : allArray) {
            if (!first) {
                argsList.add(s);
            }
            first = false;
        }
        String[] args = argsList.toArray(new String[0]);
        return new MessageRecievedHolder(command, args, prefix, message);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageRecievedHolder msg = getMessage(event.getMessage().getContentRaw());
        if (msg != null) {
            onMessageReceived(msg.getCommand(), msg.getArgs(), msg.getPrefix(), msg.getAll(), event);
        }
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        MessageRecievedHolder msg = getMessage(event.getMessage().getContentRaw());
        if (msg != null) {
            onGuildMessageReceived(msg.getCommand(), msg.getArgs(), msg.getPrefix(), msg.getAll(), event);
        }
    }

    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event) {
        MessageRecievedHolder msg = getMessage(event.getMessage().getContentRaw());
        if (msg != null) {
            onPrivateMessageReceived(msg.getCommand(), msg.getArgs(), msg.getPrefix(), msg.getAll(), event);
        }
    }

    @SuppressWarnings("unused")
    public void onMessageReceived(String cmd, String[] args, String prefix, String all, MessageReceivedEvent event) {  }

    @SuppressWarnings("unused")
    public void onGuildMessageReceived(String cmd, String[] args, String prefix, String all, GuildMessageReceivedEvent event) {  }

    @SuppressWarnings("unused")
    public void onPrivateMessageReceived(String cmd, String[] args, String prefix, String all, PrivateMessageReceivedEvent event) {  }

    public JDA getJDA() {
        return jda;
    }
}