package me.dkim19375.qotdy.configuration;

import me.mattstudios.config.SettingsHolder;
import me.mattstudios.config.annotations.Path;
import me.mattstudios.config.properties.Property;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Configs implements SettingsHolder {
    @Path("token")
    public static final Property<String> TOKEN = Property.create("token");

    @Path("message.content")
    public static final Property<String> CONTENT = Property.create("Question of the Day!%newline%(DATE)");

    @Path("embeds")
    public static final Property<List<EmbedConfiguration>> EMBEDS = Property.create(new ArrayList<EmbedConfiguration>());

    @Path("prefix")
    public static final Property<String> PREFIX = Property.create("!");

    @Path("suggestions")
    public static final Property<Set<String>> SUGGESTIONS = Property.create(new HashSet<>());
}
