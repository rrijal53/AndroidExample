package com.rowsun.kcmit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rowsun on 6/20/17.
 */

public class AdapterContact extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Student> studentList;
    private Context context;
    private LayoutInflater inflater;
    public AdapterContact( Context context, List<Student> studentList) {
        this.studentList = studentList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.row_student, parent , false );
        return new ViewHolderContact(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolderContact){
            ViewHolderContact vh = (ViewHolderContact) holder;
            Student s = studentList.get(position);
            vh.name.setText(s.getName());
            vh.address.setText(s.getAddress());
            vh.phone.setText(s.getPhone());
        }
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class ViewHolderContact extends RecyclerView.ViewHolder{

        TextView name, address, phone;
        public ViewHolderContact(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
            phone = (TextView) itemView.findViewById(R.id.phone);
        }
    }
}
