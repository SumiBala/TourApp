package com.example.tourapp;

public class Tour {
    private String mTitle;
    private int mTourImageID;
    private String mDetail;

    public Tour(String Title, int imageId, String detail) {
        mTitle = Title;
        mTourImageID = imageId;
        mDetail = detail;
    }

    //Get the Title.
    public String getTitle() {
        return mTitle;
    }

    //Get the Image.
    public int getImage() {
        return mTourImageID;
    }

    //Get the Info.
    public String getDetail() {
        return mDetail;
    }
}
