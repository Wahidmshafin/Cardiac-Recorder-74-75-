package com.example.cardiac_recorder;

import java.util.ArrayList;
import java.util.List;

public class MeasurementList
{
    List<Measurement>mList=new ArrayList<>();

    public void add(Measurement measure)
    {
        if(mList.contains(measure))
        {
            throw new IllegalArgumentException();
        }
        mList.add(measure);
    }

    public List<Measurement>getMeasure()
    {
        return mList;
    }
}
