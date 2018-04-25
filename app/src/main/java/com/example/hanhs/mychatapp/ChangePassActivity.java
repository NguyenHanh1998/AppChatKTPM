package com.example.hanhs.mychatapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class ChangePassActivity extends AppCompatActivity {

    private Toolbar changePassBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        changePassBar = (Toolbar) findViewById(R.id.change_pass_bar);
        setSupportActionBar(changePassBar);
        getSupportActionBar().setTitle("Change PassWord");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
