package com.overops.webhook.example.integrations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MattermostMessage {

    private String channel;
    private String username;

    @JsonProperty("icon_url")
    private String iconUrl;

    private String text;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
