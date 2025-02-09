/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.tourapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class TourFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public TourFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    //Call the corresponding fragment.
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AttractionFragment();
        } else if (position == 1) {
            return new MuseumFragment();
        } else if (position == 2) {
            return new RelaxFragment();
        } else {
            return new RestaurantFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    //Assign Title for the Tab.
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_attraction);
        } else if (position == 1) {
            return mContext.getString(R.string.category_museum);
        } else if (position == 2) {
            return mContext.getString(R.string.category_bpark);
        } else {
            return mContext.getString(R.string.category_restaurant);
        }
    }
}
