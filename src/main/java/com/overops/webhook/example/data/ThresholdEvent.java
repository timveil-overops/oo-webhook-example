package com.overops.webhook.example.data;

public class ThresholdEvent {

    private String title;

    private Frame frame;

    private long times;

    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ThresholdEvent{" +
                "title='" + title + '\'' +
                ", frame=" + frame +
                ", times=" + times +
                ", link='" + link + '\'' +
                '}';
    }
}
