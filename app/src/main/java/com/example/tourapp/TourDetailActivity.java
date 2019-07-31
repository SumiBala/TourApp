package com.example.tourapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.BindView;

public class TourDetailActivity extends AppCompatActivity {
    String Title;
   @BindView(R.id.titleText) TextView titleText;
   @BindView(R.id.detailText) TextView detailText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourdetail);
        ButterKnife.bind(this);

        //Get that intent that Start this activity.
        Intent intent = getIntent();
        //Get the params from the parent.
        Bundle bundle = intent.getExtras();
        Title = bundle.getString("Title");
        getSupportActionBar().setTitle(Title);
        titleText.setText(Title);
        titleText.setCompoundDrawablesWithIntrinsicBounds(0, bundle.getInt("ImageId"), 0, 0);
        detailText.setText(bundle.getString("Detail"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
