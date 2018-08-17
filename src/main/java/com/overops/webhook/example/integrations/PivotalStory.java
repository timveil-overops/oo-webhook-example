package com.overops.webhook.example.integrations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PivotalStory {

    private String name;

    @JsonProperty("story_type")
    private String storyType;

    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStoryType() {
        return storyType;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
