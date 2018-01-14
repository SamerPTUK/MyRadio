package com.samer.myradio.services;

import com.samer.myradio.models.Station;

import java.util.ArrayList;

/**
 * Created by Samer AlShurafa on 1/11/2018.
 */

public class DataService {

    private static final DataService ourInstance = new DataService();

    public static final String[] titles = {
            "Flight Plan (Tunes for Travel)",
            "Two-Wheeling' (Biking Playlist)",
            "Kids Jams (Music for Children)",
            "Vinyl Music",
            "Social Music",
            "Key Music"
    };

    public static DataService getInstance() {
        return ourInstance;
    }


    public ArrayList<Station> getFeaturedStations() {
        ArrayList<Station> list = new  ArrayList<>();

        list.add(new Station(titles[0], "flightplanmusic"));
        list.add(new Station(titles[1], "bicyclemusic"));
        list.add(new Station(titles[2], "kidsmusic"));

        return  list;
    }


    public ArrayList<Station> getRecentStations() {
        ArrayList<Station> list = new  ArrayList<>();

        list.add(new Station(titles[3], "vinylmusic"));
        list.add(new Station(titles[4], "socialmusic"));
        list.add(new Station(titles[5], "keymusic"));

        return  list;
    }

}
