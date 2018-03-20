package com.example.hanhs.mychatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartPageActivity extends AppCompatActivity {


    private Button newAcount;
    private Button alreadyHaveAcount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        newAcount = (Button) findViewById(R.id.need_new_acount);
        alreadyHaveAcount = (Button) findViewById(R.id.already_have_acount);

        alreadyHaveAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login_tent = new Intent(StartPageActivity.this, LoginActivity.class);
                startActivity(login_tent);
            }
        });
        newAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register_intent = new Intent(StartPageActivity.this, RegisterActivity.class);
                startActivity(register_intent);
            }
        });
    }
}
