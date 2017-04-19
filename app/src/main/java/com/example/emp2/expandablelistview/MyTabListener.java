package com.example.emp2.expandablelistview;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by EMP2 on 3/27/2017.
 */

public class MyTabListener extends FragmentPagerAdapter {

    private List<Fragment> fragments;
            public MyTabListener(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
            this.fragments=fragments;

    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
