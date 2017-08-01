package com.rowsun.kcmit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rowsun on 8/1/17.
 */

public class AdapterDoctor extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private Context context;
    private List<Doctor> list;

    public AdapterDoctor(Context context, List<Doctor> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_doc, parent, false);
        return new DoctorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        DoctorViewHolder vh = (DoctorViewHolder) holder;
        vh.name.setText(list.get(position).getName());
        vh.gender.setText(list.get(position).getGender());
        vh.hospital.setText(list.get(position).getHospital());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class DoctorViewHolder extends RecyclerView.ViewHolder{
        TextView name, gender, hospital;

        public DoctorViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            gender = (TextView) itemView.findViewById(R.id.gender);
            hospital = (TextView) itemView.findViewById(R.id.hospital);
        }
    }
}
