package com.example.hanhs.mychatapp.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hanhs.mychatapp.R;
import com.example.hanhs.mychatapp.TabsFriendPageAdapter;

public class FriendActivity extends AppCompatActivity {

    private ProgressDialog progressDialogFriend;
    private TabLayout tabFriendLayout;
    private ViewPager viewFriendPager;
    private TabsFriendPageAdapter tabsFriendPageAdapter;
    private Toolbar friendToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        friendToolbar = (Toolbar) findViewById(R.id.main_plus_friend_bar);
        setSupportActionBar(friendToolbar);
        getSupportActionBar().setTitle("Friends");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        progressDialogFriend = new ProgressDialog(this);

        viewFriendPager = (ViewPager) findViewById(R.id.main_friend_viewpager);
        tabsFriendPageAdapter = new TabsFriendPageAdapter(getSupportFragmentManager());
        viewFriendPager.setAdapter(tabsFriendPageAdapter);
        tabFriendLayout = (TabLayout) findViewById(R.id.main_tab__friend_layout);
        tabFriendLayout.setupWithViewPager(viewFriendPager);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                Toast.makeText(getApplicationContext(),"Back button clicked", Toast.LENGTH_SHORT).show();
                onBackPressed();
                return true;
        }
        return false;
    }
}
