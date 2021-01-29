package me.dkim19375.qotdy.configuration;

import me.mattstudios.config.SettingsManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FileManager {
    private SettingsManager config;
    private SettingsManager backup;

    public FileManager() {
        final File configFile = Paths.get("data", "config.yml").toFile();
        if (!configFile.getParentFile().mkdirs()) {
            System.out.println("Could not make directories for config.yml!");
        }
        try {
            if (!configFile.createNewFile()) {
                System.out.println("Could not make file for config.yml!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        config = SettingsManager.from(configFile).configurationData(Configs.class).create();

        final File backupFile = Paths.get("data", "backup.yml").toFile();
        if (!backupFile.getParentFile().mkdirs()) {
            System.out.println("Could not make directories for backup.yml!");
        }
        try {
            if (!backupFile.createNewFile()) {
                System.out.println("Could not make file for backup.yml!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        config = SettingsManager.from(backupFile).configurationData(BackupFile.class).create();
    }

    public SettingsManager getConfig() {
        return config;
    }

    public SettingsManager getBackup() {
        return backup;
    }

    public String getToken() {
        return config.get(Configs.token);
    }
}
