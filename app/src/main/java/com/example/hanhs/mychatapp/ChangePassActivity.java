package com.example.hanhs.mychatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

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
}
