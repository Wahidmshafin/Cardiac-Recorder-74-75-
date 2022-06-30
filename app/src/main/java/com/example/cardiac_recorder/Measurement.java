package com.example.cardiac_recorder;

import java.sql.Time;
import java.util.Date;

public class Measurement {
    private Date date;
    private Time time;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartrate;
    private String comment;
    public Measurement(Date date, Time time, int systolicPressure, int diastolicPressure, int heartrate, String comment) {
        this.date = date;
        this.time = time;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartrate = heartrate;
        this.comment = comment;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public int getHeartrate() {
        return heartrate;
    }

    public String getComment() {
        return comment;
    }
}
