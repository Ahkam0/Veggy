package com.org.job.vegyy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Adapter_history extends RecyclerView.Adapter<ViewHolderOrderHistory> {
    private ArrayList<Class_history> list;
    CustomItemClickListener listener;
    Context mContext;

    public Adapter_history(ArrayList<Class_history> Data)
    {
        list = Data;
    }

    @Override
    public ViewHolderOrderHistory onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_orderhistory, parent, false);
        final ViewHolderOrderHistory holder = new ViewHolderOrderHistory(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolderOrderHistory holder, int position) {
        holder.mTotal.setText(list.get(position).getTotal());
        holder.mTime.setText(list.get(position).getTime());
        holder.mStatus.setText(list.get(position).getStatus());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //adding adapter for on item click
    public Adapter_history(Context mContext, ArrayList<Class_history> list, CustomItemClickListener listener) {
        this.list = list;
        this.mContext = mContext;
        this.listener = listener;
    }
}
