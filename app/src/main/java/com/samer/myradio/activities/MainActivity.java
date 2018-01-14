package com.samer.myradio.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;

import com.samer.myradio.R;
import com.samer.myradio.fragments.DetailsFragment;
import com.samer.myradio.fragments.MainFragment;
import com.samer.myradio.models.Station;

public class MainActivity extends AppCompatActivity {

    ImageButton playBtn;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    private static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.setMainActivity(this);

        playBtn = findViewById(R.id.playBtn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playBtn.getTag() != null) {
                    int tag = Integer.valueOf(String.valueOf(playBtn.getTag()));

                    if (tag == 10) {
                        playBtn.setImageResource(R.drawable.pausebutton);
                        playBtn.setTag((Integer) 20);
                    } else {
                        playBtn.setImageResource(R.drawable.playbutton);
                        playBtn.setTag((Integer) 10);
                    }
                }
            }
        });


        loadMainFragment();

    }

    public void loadMainFragment() {
        FragmentManager manager = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)manager.findFragmentById(R.id.fragment_container);

        if(mainFragment == null) {
            mainFragment = MainFragment.newInstance("main", "fragment");
            manager.beginTransaction().add(R.id.fragment_container, mainFragment).commit();
        }
    }

    public void returnToMain() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance("main", "fragment"))
                .addToBackStack(null).commit();
    }

    public void loadDetailsFragment(Station selectedStation) {

        Bundle bundle = new Bundle();
        bundle.putString("title", selectedStation.getBriefStationUri());

        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, detailsFragment)
                .addToBackStack(null).commit();
    }

}
