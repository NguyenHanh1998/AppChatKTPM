package com.example.hanhs.mychatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SettingActivity extends AppCompatActivity {

    private Button changeProfile;
    private Button changePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        changePass = (Button) findViewById(R.id.setting_pass);
        changeProfile = (Button) findViewById(R.id.setting_profile);
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changePassIntent = new Intent(SettingActivity.this,ChangePassActivity.class);
                startActivity(changePassIntent);
            }
        });

        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeProfileIntent = new Intent(SettingActivity.this,ChangeProfileActivity.class);
                startActivity(changeProfileIntent);
            }
        });
    }
}
