package com.example.cardiac_recorder;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeasurementListTest
{
    private MeasurementList mockList()
    {
        MeasurementList mList=new MeasurementList();
        mList.add(mockMeasure());
        return mList;
    }
    private Measurement mockMeasure()
    {
        return new Measurement("22/07/2022","11:20pm",130,80,80,"healthy");
    }


    @Test
    public void testAdd()
    {
        MeasurementList mList=mockList();
        assertEquals(1,mList.getMeasure().size());

        Measurement m=new Measurement("23/07/2022","8:45pm",120,70,85,"Lively");
        mList.add(m);

        assertEquals(2,mList.getMeasure().size());
        assertTrue(mList.getMeasure().contains(m));
    }

    @Test
    public void testAddException()
    {
        MeasurementList mList=mockList();
        assertThrows(IllegalArgumentException.class,()->{
            mList.add(mockMeasure());
        });
    }



    @Test
    public void testGetMeasure()
    {
        MeasurementList mList = mockList();
        assertEquals(0, mockMeasure().compareTo(mockList().getMeasure().get(0)));

        Measurement measure = new Measurement("23/07/2022","8:45pm",120,70,85,"Lively");
        mList.add(measure);

        assertEquals(0, measure.compareTo(mList.getMeasure().get(1)));
        assertEquals(0, mockMeasure().compareTo(mList.getMeasure().get(0)));
    }

    @Test
    public void testRemove()
    {
        MeasurementList mList=mockList();
        Measurement measure = new Measurement("23/07/2022","8:45pm",120,70,85,"Lively");
        mList.add(measure);
        assertTrue(mList.getMeasure().contains(measure));
        mList.remove(measure);
        assertFalse(mList.getMeasure().contains(measure));

    }
    @Test
    public void testRemoveException()
    {
        MeasurementList mList=mockList();
        Measurement measure = new Measurement("23/07/2022","8:45pm",120,70,85,"Lively");
       assertThrows(IllegalArgumentException.class,()->{
           mList.remove(measure);
       });
    }

    @Test
    public void testEdit()
    {
        MeasurementList mList=mockList();
        Measurement measure = new Measurement("23/07/2022","8:45pm",120,70,85,"Lively");
        mList.add(measure);
        assertTrue(mList.getMeasure().contains(measure));
        Measurement another=new Measurement("28/07/2022","1:45am",110,90,95,"Fit");
        mList.edit(1,another);
        assertFalse(mList.getMeasure().contains(measure));
        assertTrue(mList.getMeasure().contains(another));
    }
}
//This is a random comment