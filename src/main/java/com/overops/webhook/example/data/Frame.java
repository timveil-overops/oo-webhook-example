package com.overops.webhook.example.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Frame {

    @JsonProperty("class_name")
    private String className;

    @JsonProperty("method_name")
    private String methodName;

    @JsonProperty("method_desc")
    private String methodDescription;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("is_3rd_party")
    private boolean thirdParty;

    @JsonProperty("is_catch_frame")
    private boolean catchFrame;

    @JsonProperty("is_hit_frame")
    private boolean hitFrame;

    @JsonProperty("modification_timestamp")
    private String modificationTimestamp;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(boolean thirdParty) {
        this.thirdParty = thirdParty;
    }

    public boolean isCatchFrame() {
        return catchFrame;
    }

    public void setCatchFrame(boolean catchFrame) {
        this.catchFrame = catchFrame;
    }

    public boolean isHitFrame() {
        return hitFrame;
    }

    public void setHitFrame(boolean hitFrame) {
        this.hitFrame = hitFrame;
    }

    public String getModificationTimestamp() {
        return modificationTimestamp;
    }

    public void setModificationTimestamp(String modificationTimestamp) {
        this.modificationTimestamp = modificationTimestamp;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodDescription='" + methodDescription + '\'' +
                ", fullName='" + fullName + '\'' +
                ", thirdParty=" + thirdParty +
                ", catchFrame=" + catchFrame +
                ", hitFrame=" + hitFrame +
                ", modificationTimestamp='" + modificationTimestamp + '\'' +
                '}';
    }
}
