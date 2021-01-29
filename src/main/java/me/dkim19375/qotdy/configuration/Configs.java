package me.dkim19375.qotdy.configuration;

import me.mattstudios.config.SettingsHolder;
import me.mattstudios.config.annotations.Path;
import me.mattstudios.config.properties.Property;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Configs implements SettingsHolder {
    private static final Map<String, EmbedConfiguration> embedDefault;
    static {
        embedDefault = new HashMap<>();
        embedDefault.put("example", new EmbedConfiguration("a", 2));
    }

    @Path("token")
    public static final Property<String> TOKEN = Property.create("token");

    @Path("message.content")
    public static final Property<String> CONTENT = Property.create("Question of the Day!%newline%(DATE)");

    @Path("embeds")
    public static final Property<Map<String, EmbedConfiguration>> EMBEDS = Property.create(EmbedConfiguration.class, embedDefault);

    @Path("prefix")
    public static final Property<String> PREFIX = Property.create("!");

    @Path("suggestions")
    public static final Property<Set<String>> SUGGESTIONS = Property.create(new HashSet<>());
}
