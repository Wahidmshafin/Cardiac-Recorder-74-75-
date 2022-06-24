package com.example.cardiac_recorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomList extends ArrayAdapter<RecordTime>
{
    private ArrayList<RecordTime> arrayList;
    private Context context;

    public CustomList(@NonNull Context context, ArrayList<RecordTime> arrayList)
    {
        super(context, 0, arrayList);
        this.arrayList = arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.record_list_view, parent, false);
        }

        RecordTime recordTime=arrayList.get(position);

        TextView showTime= view.findViewById(R.id.record_txt);
        showTime.setText(recordTime.toString());
        return view;
    }
}
