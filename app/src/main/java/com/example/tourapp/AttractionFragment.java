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
import java.util.zip.Inflater;

public class AttractionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflate the layout for this fragment.
        View rootView = inflater.inflate(R.layout.tour_list, container, false);
        final ArrayList<Tour> tourArrayList = new ArrayList<Tour>();
        //Get the data from the resources.
        Resources res=getResources();
        tourArrayList.add(new Tour(res.getString(R.string.attraction1),R.drawable.alalam ,res.getString(R.string.alalam_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.attraction2), R.drawable.sinkhole,res.getString(R.string.sink_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.attraction3),R.drawable.corniche ,res.getString(R.string.corniche_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.attraction4), R.drawable.souq,res.getString(R.string.souq_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.attraction5), R.drawable.mosque,res.getString(R.string.mosque_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.attraction6), R.drawable.sand,res.getString(R.string.sand_Info)));
        TourAdapter itemsAdapter = new TourAdapter(getActivity(), tourArrayList);
        ListView listView = (ListView) rootView.findViewById(R.id.listTour);
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
