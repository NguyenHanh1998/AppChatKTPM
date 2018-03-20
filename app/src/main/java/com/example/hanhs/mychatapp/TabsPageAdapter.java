package com.example.hanhs.mychatapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class TabsPageAdapter extends FragmentPagerAdapter {
    public TabsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       switch (position)
       {
           case 0:
               FriendsFragment friendsFragment = new FriendsFragment();
               return friendsFragment;
           case 1:
               ChatsFragment chatsFragment = new ChatsFragment();
               return chatsFragment;
           case 2:
               InforFragment inforFragment = new InforFragment();
               return inforFragment;
           default:
               return null;
       }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Friends";
            case 1:
                return "Chats";
            case 2:
                return "Information";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
