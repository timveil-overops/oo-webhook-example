package com.overops.webhook.example.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class ThresholdPayload extends Payload {

    private int threshold;
    private long times;

    @JsonProperty("from_timestamp")
    private long from;

    @JsonProperty("to_timestamp")
    private long to;

    @JsonProperty("top_events")
    private ThresholdEvent[] topEvents;

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public ThresholdEvent[] getTopEvents() {
        return topEvents;
    }

    public void setTopEvents(ThresholdEvent[] topEvents) {
        this.topEvents = topEvents;
    }

    @Override
    public String toString() {
        return "ThresholdPayload{" +
                "threshold=" + threshold +
                ", times=" + times +
                ", from=" + from +
                ", to=" + to +
                ", topEvents=" + Arrays.toString(topEvents) +
                '}';
    }
}
