package com.samer.myradio.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samer.myradio.R;
import com.samer.myradio.activities.MainActivity;
import com.samer.myradio.services.DataService;


public class DetailsFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);;

        ImageButton backBtn = view.findViewById(R.id.backBtu);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getMainActivity().returnToMain();
            }
        });


        LinearLayout topLL = view.findViewById(R.id.topLL);
        ImageView selectedImage = view.findViewById(R.id.selectedImage);
        TextView selectedText = view.findViewById(R.id.selectedText);


        Bundle bundle = this.getArguments();

        int color = R.color.color_flightplanmusic;

        if(bundle != null) {
            switch (bundle.getString("title")) {
                case "flightplanmusic":
                    color = R.color.color_flightplanmusic;
                    selectedImage.setImageResource(R.drawable.flightplanmusic);
                    selectedText.setText(DataService.titles[0]);
                    break;
                case "bicyclemusic":
                    color = R.color.color_bicyclemusic;
                    selectedImage.setImageResource(R.drawable.bicyclemusic);
                    selectedText.setText(DataService.titles[1]);
                    break;
                case "kidsmusic":
                    color = R.color.color_kidsmusic;
                    selectedImage.setImageResource(R.drawable.kidsmusic);
                    selectedText.setText(DataService.titles[2]);
                    break;
                case "vinylmusic":
                    color = R.color.color_vinylmusic;
                    selectedImage.setImageResource(R.drawable.vinylmusic);
                    selectedText.setText(DataService.titles[3]);
                    break;
                case "socialmusic":
                    color = R.color.color_socialmusic;
                    selectedImage.setImageResource(R.drawable.socialmusic);
                    selectedText.setText(DataService.titles[4]);
                    break;
                case "keymusic":
                    color = R.color.color_keymusic;
                    selectedImage.setImageResource(R.drawable.keymusic);
                    selectedText.setText(DataService.titles[5]);
                    break;
            }
        }


        topLL.setBackgroundResource(color);

        return view;
    }



}
