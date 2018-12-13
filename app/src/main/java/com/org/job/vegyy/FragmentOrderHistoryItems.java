package com.org.job.vegyy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOrderHistoryItems extends Fragment {
    ListView mListView;
    ArrayList<Class_historyitems> class_historyitems;

    public FragmentOrderHistoryItems() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_order_history_items, container, false);
        class_historyitems = new ArrayList<>();
        class_historyitems.add(new Class_historyitems("Item1","Rs.200","1kg"));
        class_historyitems.add(new Class_historyitems("Item2","Rs.210","2kg"));
        class_historyitems.add(new Class_historyitems("Item3","Rs.220","3kg"));
        class_historyitems.add(new Class_historyitems("Item4","Rs.230","4kg"));
        class_historyitems.add(new Class_historyitems("Item5","Rs.240","5kg"));
        class_historyitems.add(new Class_historyitems("Item6","Rs.250","6kg"));
        class_historyitems.add(new Class_historyitems("Item7","Rs.260","7kg"));
        class_historyitems.add(new Class_historyitems("Item8","Rs.270","8kg"));
        class_historyitems.add(new Class_historyitems("Item9","Rs.280","9kg"));
        class_historyitems.add(new Class_historyitems("Item10","Rs.290","10kg"));
        class_historyitems.add(new Class_historyitems("Item11","Rs.300","11kg"));
        mListView = (ListView) view.findViewById(R.id.hi_list);
        final Adapter_historyitems adapter_historyitems = new Adapter_historyitems(getActivity(),R.layout.custom_history_items,class_historyitems);
        mListView.setAdapter(adapter_historyitems);


        return view;
    }

}
