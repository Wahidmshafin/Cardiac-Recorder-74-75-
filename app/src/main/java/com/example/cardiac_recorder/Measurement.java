package com.example.cardiac_recorder;

import android.os.Parcelable;

import java.io.Serializable;
import java.sql.Time;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Measurement implements Serializable, Comparable<Measurement>
{
    private String date;
    private String time;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartrate;
    private String comment;

    /**
     * This is the parameterized constructor
     * @param date
     *      date value
     * @param time
     *      time value
     * @param systolicPressure
     *      systolicPressure value
     * @param diastolicPressure
     *      diastolicPressure value
     * @param heartrate
     *      heartrate value
     * @param comment
     *      comment
     */
    public Measurement(String date, String time, int systolicPressure, int diastolicPressure, int heartrate, String comment) {
        this.date = date;
        this.time = time;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartrate = heartrate;
        this.comment = comment;
    }

    /**
     * Check if two Measurement object are equals
     * @param o
     *      another object o
     * @return
     *      return if both are equals or not
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return systolicPressure == that.systolicPressure && diastolicPressure == that.diastolicPressure && heartrate == that.heartrate && date.equals(that.date) && time.equals(that.time) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time, systolicPressure, diastolicPressure, heartrate, comment);
    }

    /**
     * Default parameter
     */
    public Measurement()
    {

    }

    /**
     * Set data
     * @param date
     *      input date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Set time
     * @param time
     * input time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Set systolicPressure
     * @param systolicPressure
     * input systolicPressure
     */
    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }


    /**
     * Set diastolicPressure
     * @param diastolicPressure
     * input diastolicPressure
     */
    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }


    /**
     * Set heartrate
     * @param heartrate
     * input heartrate
     */
    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }


    /**
     * Set comment
     * @param comment
     * input comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Get date
     * @return
     * return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Get time
     * @return
     * return time
     */
    public String getTime() {
        return time;
    }


    /**
     * Get systolicPressure
     * @return
     * return systolicPressure
     */
    public int getSystolicPressure() {
        return systolicPressure;
    }

    /**
     * Get diastolicPressure
     * @return
     * return diastolicPressure
     */

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    /**
     * Get heartrate
     * @return
     * return heartrate
     */
    public int getHeartrate() {
        return heartrate;
    }

    /**
     * Get comment
     * @return
     * return comment
     */
    public String getComment() {
        return comment;
    }


    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Measurement o)
    {
        return this.time.compareTo(o.getTime());
    }
}
