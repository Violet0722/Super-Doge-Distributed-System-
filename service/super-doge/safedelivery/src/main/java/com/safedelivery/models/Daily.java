package com.safedelivery.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Daily {

    public String[] weathercode;
    public String[] time;

    public Daily() {
    }

    public Daily(String[] weathercode, String[] time) {
        this.weathercode = weathercode;
        this.time = time;
    }

    public String[] getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(String[] weathercode) {
        this.weathercode = weathercode;
    }

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }
}
