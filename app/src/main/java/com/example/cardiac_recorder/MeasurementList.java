package com.example.cardiac_recorder;

import android.icu.util.Measure;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class that keeps track of list of measurement
 */

public class MeasurementList
{
    List<Measurement>mList=new ArrayList<>();

    /**
     * This adds measure to the arrayList
     * @param measure
     *      This is the measure to add
     */

    public void add(Measurement measure)
    {
        if(mList.contains(measure))
        {
            throw new IllegalArgumentException();
        }
        mList.add(measure);
    }

    /**
     * This removes a measure from the list
     * @param measurement
     *      This is the measure to delete
     */

    public void remove(Measurement measurement)
    {
        if(mList.contains(measurement))
        {
            mList.remove(measurement);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This is edits a measure in given position
     * @param pos
     *      the position where we will edit
     * @param measurement
     *      the measure which will update the values
     */

    public void edit(int pos, Measurement measurement)
    {
        mList.set(pos,measurement);
    }

    /**
     * This returns the list
     * @return
     *      return the list
     */

    public List<Measurement>getMeasure()
    {
        return mList;
    }
}
