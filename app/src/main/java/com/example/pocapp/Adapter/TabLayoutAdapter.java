package com.example.pocapp.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pocapp.Fragment.CustomAmountForEach;
import com.example.pocapp.Fragment.FixedAmountFragment;
import com.example.pocapp.Fragment.SomeAmountForEachFragment;

public class TabLayoutAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public TabLayoutAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FixedAmountFragment packageTeamFragment = new FixedAmountFragment();
                return packageTeamFragment;
            case 1:
                SomeAmountForEachFragment myTeamFragment = new SomeAmountForEachFragment();
                return  myTeamFragment;
            case 2:
                CustomAmountForEach cricketFragment = new CustomAmountForEach();
                return cricketFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
