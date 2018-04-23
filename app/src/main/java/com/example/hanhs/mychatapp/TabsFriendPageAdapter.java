package com.example.hanhs.mychatapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Hanhs on 4/21/2018.
 */

public class TabsFriendPageAdapter extends FragmentPagerAdapter {
    public TabsFriendPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                AddFragment addFragment = new AddFragment();
                return addFragment;
            case 1:
                RequestFragment requestFragment = new RequestFragment();
                return requestFragment;
            default:
                return null;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Add";
            case 1:
                return "Request";
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return 2;
    }
}
