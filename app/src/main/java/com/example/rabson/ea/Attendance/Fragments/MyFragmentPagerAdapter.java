package com.example.rabson.ea.Attendance.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Rabson on 10/11/2016.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> pages = new ArrayList<>();

    public MyFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    public void addPage(Fragment f){
        pages.add(f);
    }

    public CharSequence getPageTitle(int position){
        return pages.get(position).toString();
    }
}
