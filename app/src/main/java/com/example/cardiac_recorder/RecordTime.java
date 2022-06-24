package com.example.cardiac_recorder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecordTime
{
    public int date,year,hour,minute, month;

    public RecordTime(int date, int month, int year, int hour, int minute)
    {
        this.date = date;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.month = month;
    }

    @Override
    public String toString()
    {
        LocalDateTime localDateTime=LocalDateTime.of(year, month, date, hour, minute);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm");
        return localDateTime.format(formatter);
    }
}
