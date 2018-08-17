package com.overops.webhook.example.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Arrays;

public class Data {


    public enum Type {
        NEW_EVENT, RESURFACED, THRESHOLD
    }

    private Type type;
    private String summary;

    @JsonProperty("view_name")
    private String viewName;

    @JsonProperty("added_by")
    private String[] addedBy;

    @JsonProperty("data")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
    @JsonSubTypes(value = {
            @JsonSubTypes.Type(value = NewEventPayload.class, name = "NEW_EVENT"),
            @JsonSubTypes.Type(value = ThresholdPayload.class, name = "THRESHOLD")
    })
    private Payload payload;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String[] getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String[] addedBy) {
        this.addedBy = addedBy;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }


    @Override
    public String toString() {
        return "Data{" +
                "type=" + type +
                ", summary='" + summary + '\'' +
                ", viewName='" + viewName + '\'' +
                ", addedBy=" + Arrays.toString(addedBy) +
                ", payload=" + payload +
                '}';
    }
}
