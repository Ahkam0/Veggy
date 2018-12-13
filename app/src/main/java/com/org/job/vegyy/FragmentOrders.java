package com.org.job.vegyy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by LENOVO on 7/8/2018.
 */

public class FragmentOrders extends Fragment {
    private ArrayList<Class_history> orderList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter_history mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_orders, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.h_list);

        orderList.add(new Class_history("01:00","delivered","Rs.500"));
        orderList.add(new Class_history("02:00","delivered","Rs.600"));
        orderList.add(new Class_history("03:00","delivered","Rs.700"));
        orderList.add(new Class_history("04:00","delivered","Rs.800"));
        orderList.add(new Class_history("05:00","delivered","Rs.900"));
        orderList.add(new Class_history("06:00","pending","Rs.1000"));
        orderList.add(new Class_history("07:00","delivered","Rs.1100"));
        orderList.add(new Class_history("08:00","delivered","Rs.1200"));
        orderList.add(new Class_history("09:00","delivered","Rs.1300"));
        orderList.add(new Class_history("10:00","delivered","Rs.1400"));
        orderList.add(new Class_history("11:00","delivered","Rs.1500"));
        orderList.add(new Class_history("12:00","delivered","Rs.1600"));
        orderList.add(new Class_history("13:00","delivered","Rs.1700"));
        orderList.add(new Class_history("14:00","pending","Rs.1800"));

        mAdapter = new Adapter_history(getActivity(), orderList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                FragmentOrderHistoryItems fragmentItemDes = new FragmentOrderHistoryItems();
                getFragmentManager().beginTransaction().replace(R.id.content_frame, fragmentItemDes).commit();
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("My Orders");
    }
}
