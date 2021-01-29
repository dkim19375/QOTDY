package me.dkim19375.qotdy.configuration;

public class EmbedConfiguration {
    private final String title;
    private final int color;
    private String image;

    public EmbedConfiguration(String title, int color, String image) {
        this.title = title;
        this.color = color;
        this.image = image;
    }

    public EmbedConfiguration(String title, int color) {
        this.title = title;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public int getColor() {
        return color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
