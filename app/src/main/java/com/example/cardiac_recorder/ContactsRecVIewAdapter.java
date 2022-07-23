package com.example.cardiac_recorder;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
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
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ContactsRecVIewAdapter extends RecyclerView.Adapter<ContactsRecVIewAdapter.ViewHolder> {
    private ArrayList<Measurement> measurement = new ArrayList<>();
    private Context context;
    String TAG="Error";
    String time;
    ActivityResultLauncher<Intent>content;
    String key;

    public ContactsRecVIewAdapter(Context context) {
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
        holder.sys.setText(Integer.toString(measurement.get(position).getSystolicPressure()));
        holder.dia.setText(Integer.toString(measurement.get(position).getDiastolicPressure()));
        if((measurement.get(position).getSystolicPressure()<90 || measurement.get(position).getDiastolicPressure()<60) ||(measurement.get(position).getSystolicPressure()>140 || measurement.get(position).getDiastolicPressure()>90) )
        {
            holder.time.setTextColor(Color.RED);
            holder.date.setTextColor(Color.RED);
            holder.sys.setTextColor(Color.RED);
            holder.dia.setTextColor(Color.RED);
            holder.diatext.setTextColor(Color.RED);
            holder.systext.setTextColor(Color.RED);
        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.parent.getContext(), ConditionDetails.class);
                intent.putExtra("add", false);
                intent.putExtra("position", holder.getAdapterPosition());

                intent.putExtra("info",measurement.get(holder.getAdapterPosition()));
                context.startActivity(intent);
                Toast.makeText(context,"selected", Toast.LENGTH_SHORT).show();
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
        private TextView sys;
        private TextView dia;
        private TextView diatext;
        private TextView systext;
        private RelativeLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            date = itemView.findViewById(R.id.date);
            sys = itemView.findViewById(R.id.sys);
            dia = itemView.findViewById(R.id.dia);
            diatext=itemView.findViewById(R.id.tv2);
            systext=itemView.findViewById(R.id.tv1);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
