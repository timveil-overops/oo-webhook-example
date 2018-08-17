package com.overops.webhook.example.data;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

    public enum Type {
        ALERT,TEST
    }

    @JsonProperty("api_version")
    private String apiVersion;

    private long date;

    private Type type;

    private String username;

    @JsonProperty("service_id")
    private String serviceId;

    @JsonProperty("service_name")
    private String serviceName;

    private Data data;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Event{" +
                "apiVersion='" + apiVersion + '\'' +
                ", date=" + date +
                ", type=" + type +
                ", username='" + username + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", data=" + data +
                '}';
    }
}
