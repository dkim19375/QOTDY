package me.dkim19375.qotdy.configuration;

import me.mattstudios.config.SettingsHolder;
import me.mattstudios.config.annotations.Path;
import me.mattstudios.config.properties.Property;

import java.util.ArrayList;
import java.util.List;

public class BackupFile implements SettingsHolder {
    @Path("used")
    public static final Property<List<String>> USED_LIST = Property.create(new ArrayList<>());
}
