package com.example.cardiac_recorder;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsRecVIewAdapter extends RecyclerView.Adapter<ContactsRecVIewAdapter.ViewHolder> {
    private ArrayList<Measurement> measurement = new ArrayList<>();
    private Context context;
    String TAG="Error";

    ActivityResultRegistry registry;
    ActivityResultLauncher<Intent> content;

    public ContactsRecVIewAdapter(Context context, ActivityResultRegistry registry) {
        this.registry=registry;
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

                Intent intent=new Intent(holder.parent.getContext(), showActivity.class);
                intent.putExtra("add", false);
                intent.putExtra("position", holder.getAbsoluteAdapterPosition());

                intent.putExtra("info",measurement.get(holder.getAbsoluteAdapterPosition()));

                holder.parent.getContext().startActivity(intent);

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
        Log.e(TAG, "onClick: Miss korse");
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
