package com.example.bottomnavi.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bottomnavi.fragment.FragmentCafe;
import com.example.bottomnavi.fragment.FragmentHome;
import com.example.bottomnavi.fragment.FragmentNotification;
import com.example.bottomnavi.fragment.FragmentSearch;



public class ViewPageAdapter extends FragmentStatePagerAdapter {
    private static final int NUM_PAGES = 4;


    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentHome();
            case 1: return new FragmentNotification();
            case 2: return new FragmentSearch();
            case 3: return new FragmentCafe();
            default:
                throw new IllegalStateException("Invalid position: " + position);

        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
