package com.org.job.vegyy;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolderOrderHistory extends RecyclerView.ViewHolder {
    TextView mTotal;
    TextView mStatus;
    TextView mTime;
    TextView mCount;

    public ViewHolderOrderHistory(View itemView) {
        super(itemView);
        mStatus = (TextView) itemView.findViewById(R.id.h_status);
        mTime = (TextView) itemView.findViewById(R.id.h_time);
        mTotal = (TextView) itemView.findViewById(R.id.h_total);
    }
}
