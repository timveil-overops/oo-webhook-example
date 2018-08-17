package com.overops.webhook.example.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class NewEventPayload extends Payload {

    public enum Type {
        EXCEPTION, LOG, HTTP_ERROR
    }

    public enum Level {
        FATAL, ERROR, WARN
    }

    private Frame location;

    @JsonProperty("entry_point")
    private Frame entryPoint;

    private Frame[] stacktrace;

    private String link;

    @JsonProperty("server_name")
    private String serverName;

    @JsonProperty("app_name")
    private String appName;

    @JsonProperty("deployment_name")
    private String deploymentName;

    @JsonProperty("name")
    private String exceptionName;

    @JsonProperty("is_caught")
    private boolean exceptionCaught;

    @JsonProperty("message")
    private String message;

    @JsonProperty("level")
    private Level logLevel;

    @JsonProperty("error_code")
    private String httpErrorCode;

    // todo - lets have lets have different field names for different "messsage"


    public Frame getLocation() {
        return location;
    }

    public void setLocation(Frame location) {
        this.location = location;
    }

    public Frame getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(Frame entryPoint) {
        this.entryPoint = entryPoint;
    }

    public Frame[] getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(Frame[] stacktrace) {
        this.stacktrace = stacktrace;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDeploymentName() {
        return deploymentName;
    }

    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public boolean isExceptionCaught() {
        return exceptionCaught;
    }

    public void setExceptionCaught(boolean exceptionCaught) {
        this.exceptionCaught = exceptionCaught;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Level getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Level logLevel) {
        this.logLevel = logLevel;
    }

    public String getHttpErrorCode() {
        return httpErrorCode;
    }

    public void setHttpErrorCode(String httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }

    @Override
    public String toString() {
        return "NewEventPayload{" +
                "location=" + location +
                ", entryPoint=" + entryPoint +
                ", stacktrace=" + Arrays.toString(stacktrace) +
                ", link='" + link + '\'' +
                ", serverName='" + serverName + '\'' +
                ", appName='" + appName + '\'' +
                ", deploymentName='" + deploymentName + '\'' +
                ", exceptionName='" + exceptionName + '\'' +
                ", exceptionCaught=" + exceptionCaught +
                ", message='" + message + '\'' +
                ", logLevel=" + logLevel +
                ", httpErrorCode='" + httpErrorCode + '\'' +
                '}';
    }
}
