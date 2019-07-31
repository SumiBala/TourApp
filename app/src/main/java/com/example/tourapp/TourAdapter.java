package com.example.tourapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourAdapter extends ArrayAdapter<Tour> {
    public TourAdapter(Context context, ArrayList<Tour> tours) {
        super(context, 0, tours);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.controls, parent, false);
        }
        Tour local_tour = getItem(position);
        TextView tourTitle = (TextView) listItemView.findViewById(R.id.titleTxt);
        tourTitle.setText(local_tour.getTitle());
        tourTitle.setCompoundDrawablesWithIntrinsicBounds(0, local_tour.getImage(), 0, 0);
        return listItemView;
    }
}
