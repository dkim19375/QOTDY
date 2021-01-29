package me.dkim19375.qotdy.utils;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.jetbrains.annotations.NotNull;

public class SimpleEmbed {
    public static MessageEmbed getQuestion(@NotNull String question, int color) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle(question);
        builder.setColor(color);
        return builder.build();
    }


    public static MessageEmbed getImage(@NotNull String imageUrl, int color) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setImage(imageUrl);
        builder.setColor(color);
        return builder.build();
    }
}
