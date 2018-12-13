package com.org.job.vegyy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LENOVO on 7/8/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderHorizontalView> {

    public interface OnItemClickListener {
        void onItemClick(String str);
    }

    private List<String> list;
    private final OnItemClickListener listener;

    public RecyclerAdapter(List<String> list, OnItemClickListener listener) {

        this.list = list;
        this.listener = listener;
    }

    @Override
    public ViewHolderHorizontalView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        ViewHolderHorizontalView holder = new ViewHolderHorizontalView(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolderHorizontalView holder, int position) {
        //holder.mImageView.setImageResource(list.get(position).getImageId());
        holder.bind(list.get(position), listener);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolderHorizontalView extends RecyclerView.ViewHolder {
        // ImageView mImageView;
        TextView mProductName;
        // CardView mCardView;

        public ViewHolderHorizontalView(View itemView) {
            super(itemView);

//        mCardView = (CardView) itemView.findViewById(R.id.cvHorizontal);
//            mImageView = (ImageView) itemView.findViewById(R.id.product_photo);
            mProductName = (TextView) itemView.findViewById(R.id.text_item);
        }

        public void bind(final String item, final OnItemClickListener listener) {
            mProductName.setText(item);
            // Picasso.with(itemView.getContext()).load(item.imageUrl).into(image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}

