package com.example.hanhs.mychatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainPlusActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

     private Toolbar ptoolbar;
    private TabLayout myTablayout;
    private ViewPager myViewpager;
    private TabsPageAdapter tabsPageAdapter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView username;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_plus);


        ptoolbar = (Toolbar) findViewById(R.id.main_plus_bar);
        setSupportActionBar(ptoolbar);
        getSupportActionBar().setTitle("MyAppChat");



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,ptoolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        myViewpager = (ViewPager) findViewById(R.id.main_viewpager);
        tabsPageAdapter = new TabsPageAdapter(getSupportFragmentManager());
        myViewpager.setAdapter(tabsPageAdapter);
        myTablayout = (TabLayout) findViewById(R.id.main_tab_layout);
        myTablayout.setupWithViewPager(myViewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.menu_logout_main )
        {
            Intent startpagetent = new Intent(MainPlusActivity.this, StartPageActivity.class);
            startpagetent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(startpagetent);
            finish();
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.home)
        {
            ptoolbar.setTitle("Home");
        }else if(id == R.id.setting)
        {
            Intent intentSetting = new Intent(MainPlusActivity.this,SettingActivity.class);
            startActivity(intentSetting);
            return false;
        }
        else if(id == R.id.friends)
        {
            Intent intentFriends = new Intent(MainPlusActivity.this,FriendActivity.class);
            startActivity(intentFriends);
            return false;
        }
        return false;
    }


}
