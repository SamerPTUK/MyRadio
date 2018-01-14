package com.samer.myradio.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samer.myradio.R;
import com.samer.myradio.adapters.StationsAdapter;
import com.samer.myradio.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class StationsFragment extends Fragment {

    private static final String ARG_STATION_TYPE = "station_type";

    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;

    private int stationType;


    public StationsFragment() {
        // Required empty public constructor
    }



    public static StationsFragment newInstance(int stationType) {
        StationsFragment fragment = new StationsFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);
        fragment.setArguments(args);

        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stations, container, false);

        RecyclerView recyclerStations = view.findViewById(R.id.recycler_stations);
        recyclerStations.setHasFixedSize(true);

        LinearLayoutManager llManager = new LinearLayoutManager(getContext());
        llManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerStations.setLayoutManager(llManager);


        StationsAdapter adapter;

        if(stationType == STATION_TYPE_FEATURED) {
            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
        } else {
            adapter = new StationsAdapter(DataService.getInstance().getRecentStations());
        }

        recyclerStations.setAdapter(adapter);


        return view;
    }

}



