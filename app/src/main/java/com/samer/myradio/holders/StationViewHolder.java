package com.samer.myradio.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.samer.myradio.R;
import com.samer.myradio.models.Station;

/**
 * Created by Samer AlShurafa on 1/11/2018.
 */

public class StationViewHolder extends RecyclerView.ViewHolder {

    ImageView image_card;
    TextView text_card;

    public StationViewHolder(View itemView) {
        super(itemView);

        image_card = itemView.findViewById(R.id.image_card);
        text_card = itemView.findViewById(R.id.text_card);

        itemView.setMinimumWidth(210);
    }

    public void updateUI(Station station) {
        String uri = station.getStationUri();
        int resource = image_card.getResources().getIdentifier(uri, null, image_card.getContext().getPackageName());
        image_card.setImageResource(resource);

        text_card.setText(station.getStationTitle());
    }


}
