package com.overops.webhook.example.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Arrays;

public class ThresholdPayload extends Payload {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");

    private int threshold;
    private long times;

    @JsonProperty("from_timestamp")
    @JsonDeserialize(using = DateDeserializer.class)
    private DateTime from;

    @JsonProperty("to_timestamp")
    @JsonDeserialize(using = DateDeserializer.class)
    private DateTime to;

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

    public DateTime getFrom() {
        return from;
    }

    public void setFrom(DateTime from) {
        this.from = from;
    }

    public DateTime getTo() {
        return to;
    }

    public void setTo(DateTime to) {
        this.to = to;
    }

    public ThresholdEvent[] getTopEvents() {
        return topEvents;
    }

    public void setTopEvents(ThresholdEvent[] topEvents) {
        this.topEvents = topEvents;
    }


    public long getDurationInMinutes() {
        Duration duration = new Duration(from, to);

        return duration.getStandardMinutes();
    }

    public String getFromString() {
        return DATE_TIME_FORMATTER.print(from);
    }

    public String getToString() {
        return DATE_TIME_FORMATTER.print(to);
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

    @Override
    public String getLink() {

        if (topEvents != null && topEvents.length > 0) {
            return topEvents[0].getLink();
        }

        return null;

    }
}
