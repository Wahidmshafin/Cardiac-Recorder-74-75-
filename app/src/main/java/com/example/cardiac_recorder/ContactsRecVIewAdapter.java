package com.example.cardiac_recorder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsRecVIewAdapter extends RecyclerView.Adapter<ContactsRecVIewAdapter.ViewHolder> {
    private ArrayList<Measurement> measurement = new ArrayList<>();
    private Context context;


    ActivityResultLauncher<Intent>content;

    public ContactsRecVIewAdapter(Context context, ActivityResultLauncher<Intent> content) {
        this.content=content;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.time.setText(measurement.get(position).getTime());
        holder.date.setText(measurement.get(position).getDate());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,"selected", Toast.LENGTH_SHORT).show();
            }
        });
        holder.parent.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                new AlertDialog.Builder(holder.parent.getContext())
                        .setMessage("Are you sure you want to delete this file")
                        .setTitle("Delete this?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                measurement.remove(holder.getAbsoluteAdapterPosition());
                                notifyItemInserted(measurement.size());
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.cancel();
                            }
                        }).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return measurement.size();
    }

    public void setMeasurement(ArrayList<Measurement> measurement) {
        this.measurement = measurement;

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView time;
        private TextView date;
        private RelativeLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            date = itemView.findViewById(R.id.date);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
