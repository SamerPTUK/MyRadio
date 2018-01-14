package com.samer.myradio.models;

/**
 * Created by Samer AlShurafa on 1/11/2018.
 */

public class Station {

    final String DRAWABLE = "drawable/";


    public Station(String stationTitle, String stationUri) {
        this.stationTitle = stationTitle;
        this.stationUri = stationUri;
    }


    public String getBriefStationUri() {return stationUri;}

    public String getStationUri() {
        return DRAWABLE + stationUri;
    }

    public void setStationUri(String stationUri) {
        this.stationUri = stationUri;
    }

    private String stationUri;



    public String getStationTitle() {
        return stationTitle;
    }

    public void setStationTitle(String stationTitle) {
        this.stationTitle = stationTitle;
    }

    private String stationTitle;


}
