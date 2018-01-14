package com.samer.myradio.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samer.myradio.R;
import com.samer.myradio.activities.MainActivity;
import com.samer.myradio.holders.StationViewHolder;
import com.samer.myradio.models.Station;

import java.util.ArrayList;

/**
 * Created by Administrator on 1/11/2018.
 */

public class StationsAdapter extends RecyclerView.Adapter<StationViewHolder> {

    private ArrayList<Station> stations;

    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View station_card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station, parent, false);

        return new StationViewHolder(station_card);
    }

    @Override
    public void onBindViewHolder(StationViewHolder stationViewHolder, final int position) {
        final Station station = stations.get(position);
        stationViewHolder.updateUI(station);

        stationViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getMainActivity().loadDetailsFragment(station);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}




