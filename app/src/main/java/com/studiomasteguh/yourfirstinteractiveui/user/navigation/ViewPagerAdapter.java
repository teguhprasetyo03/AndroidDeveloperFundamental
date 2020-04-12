package com.studiomasteguh.yourfirstinteractiveui.user.navigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int numTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumTabs)  {
        super(fm);
        this.numTabs = NumTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new OneFragment();
            case 1 : return new TwoFragment();
            case 2 : return new ThreeFragment();
            default:  return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
