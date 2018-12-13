package com.org.job.vegyy;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter_historyitems extends ArrayAdapter<Class_historyitems> {

    public Adapter_historyitems(Context context, int resource, List<Class_historyitems> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.custom_history_items, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.hi_name);
        TextView quantity = (TextView) convertView.findViewById(R.id.hi_quantity);
        TextView price = (TextView) convertView.findViewById(R.id.hi_price);

        Class_historyitems class_historyitems = getItem(position);
        name.setText(class_historyitems.getName());
        quantity.setText(class_historyitems.getQuantity());
        price.setText(class_historyitems.getPrice());

        return convertView;
    }
}
