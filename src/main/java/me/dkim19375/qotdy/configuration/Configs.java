package me.dkim19375.qotdy.configuration;

import me.mattstudios.config.SettingsHolder;
import me.mattstudios.config.annotations.Path;
import me.mattstudios.config.properties.Property;

import java.util.ArrayList;
import java.util.List;

public class Configs implements SettingsHolder {
    @Path("token")
    public static final Property<String> token = Property.create("token");

    @Path("message.content")
    public static final Property<String> content = Property.create("Question of the Day!%newline%(DATE)");

    @Path("embeds")
    public static final Property<List<EmbedConfiguration>> embeds = Property.create(new ArrayList<EmbedConfiguration>());
}
