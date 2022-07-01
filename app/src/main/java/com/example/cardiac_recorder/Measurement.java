package com.example.cardiac_recorder;

import android.os.Parcelable;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Measurement implements Serializable
{
    private String date;
    private String time;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartrate;
    private String comment;
    public Measurement(String date, String time, int systolicPressure, int diastolicPressure, int heartrate, String comment) {
        this.date = date;
        this.time = time;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartrate = heartrate;
        this.comment = comment;
    }
    public Measurement()
    {

    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
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

    public String getDate() {
        return date;
    }

    public String getTime() {
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
