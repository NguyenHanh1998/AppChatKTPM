package com.example.hanhs.mychatapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ChangeProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Toolbar changeProfileToolbar;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Spinner spinnerFavor;
    private Spinner spinnerWork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        changeProfileToolbar = (Toolbar) findViewById(R.id.change_profile_bar);
        setSupportActionBar(changeProfileToolbar);
        getSupportActionBar().setTitle("Change Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinnerWork = (Spinner) findViewById(R.id.spinner_work);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Work,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWork.setAdapter(adapter);
        spinnerWork.setOnItemSelectedListener(this);

        spinnerFavor = (Spinner) findViewById(R.id.spinner_favor);
        ArrayAdapter<CharSequence> adapterFavor = ArrayAdapter.createFromResource(this,R.array.Favor,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFavor.setAdapter(adapterFavor);
        spinnerFavor.setOnItemSelectedListener(this);

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
     public void checkButton(View v) {
         int radioId = radioGroup.getCheckedRadioButtonId();
         radioButton = (RadioButton) findViewById(radioId);

         Toast.makeText(getBaseContext(),radioButton.getText(),Toast.LENGTH_SHORT).show();
     }
}
