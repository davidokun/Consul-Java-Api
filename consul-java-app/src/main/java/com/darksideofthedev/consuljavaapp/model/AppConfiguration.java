package com.darksideofthedev.consuljavaapp.model;

import org.springframework.stereotype.Component;

@Component
public class AppConfiguration {

    private int timeToLive;

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }
}