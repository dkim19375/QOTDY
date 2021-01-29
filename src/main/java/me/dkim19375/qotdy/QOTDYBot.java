package me.dkim19375.qotdy;

import me.dkim19375.qotdy.configuration.FileManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class QOTDYBot {
    private static final FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault(fileManager.getToken());
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        try {
            JDA jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
