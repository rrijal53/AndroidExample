package com.rowsun.kcmit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rowsun on 5/30/17.
 */

public class AdapterStudent  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class ViewHolderStudent extends RecyclerView.ViewHolder{
        TextView name, address, phone;
        public ViewHolderStudent(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
            phone = (TextView) itemView.findViewById(R.id.phone);

        }
    }
}
