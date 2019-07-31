package com.example.tourapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RelaxFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflate the layout for this fragment.
        View rootView = inflater.inflate(R.layout.tour_list, container, false);
        final ArrayList<Tour> tourArrayList = new ArrayList<Tour>();
        //Get the data from the resources.
        Resources res=getResources();
        tourArrayList.add(new Tour(res.getString(R.string.beach1),R.drawable.sifa ,res.getString(R.string.sifa_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.beach2), R.drawable.pebble,res.getString(R.string.pebble_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.beach3),R.drawable.qantab,res.getString(R.string.qantab_Info)) );
        tourArrayList.add(new Tour(res.getString(R.string.park1), R.drawable.kalbouh,res.getString(R.string.kalbou_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.park2), R.drawable.qurum,res.getString(R.string.qurum_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.park3), R.drawable.riyampark,res.getString(R.string.riyam_Info)));
        TourAdapter itemsAdapter = new TourAdapter(getActivity(), tourArrayList);
        ListView listView = (ListView) rootView.findViewById(R.id.listTour);
        listView.setDrawSelectorOnTop(false);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), TourDetailActivity.class);
                //Pass the params to child activity.
                Bundle bundle = new Bundle();
                Tour tour = tourArrayList.get(position);
                bundle.putString("Title", tour.getTitle());
                bundle.putInt("ImageId", tour.getImage());
                bundle.putString("Detail",tour.getDetail());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
