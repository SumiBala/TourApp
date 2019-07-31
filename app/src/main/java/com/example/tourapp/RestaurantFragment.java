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

public class RestaurantFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflate the layout for this fragment.
        View rootView = inflater.inflate(R.layout.tour_list, container, false);
        final ArrayList<Tour> tourArrayList = new ArrayList<Tour>();
        //Get the data from the resources.
        Resources res=getResources();
        tourArrayList.add(new Tour(res.getString(R.string.restaurant1),R.drawable.ananthapuri ,res.getString(R.string.res1_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.restaurant2), R.drawable.golden,res.getString(R.string.res2_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.restaurant3),R.drawable.kargeen ,res.getString(R.string.res3_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.restaurant4), R.drawable.omanexp,res.getString(R.string.res4_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.restaurant5), R.drawable.cave,res.getString(R.string.res5_Info)));
        tourArrayList.add(new Tour(res.getString(R.string.restaurant6), R.drawable.jungle,res.getString(R.string.res6_Info)));
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
