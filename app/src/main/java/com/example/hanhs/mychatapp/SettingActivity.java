package com.example.hanhs.mychatapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingActivity extends AppCompatActivity {

    private Button changeProfile;
    private Button changePass;
    private CircleImageView user_image;

    private final static int Gallery_PICK = 1;

    String[] items = {"Gallery","Camera","Avatar Facebook"};
    ListView listView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        user_image = (CircleImageView) findViewById(R.id.user_image);
        user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,Gallery_PICK);
            }
        });
        listView = new ListView(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,items);
        listView.setAdapter(adapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ViewGroup vg = (ViewGroup)view;
                TextView txt = (TextView) vg.findViewById(R.id.txtitem);
                Intent galleryIntent = new Intent();
                    galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                    galleryIntent.setType("image/*");
                    startActivityForResult(galleryIntent,Gallery_PICK);

                Toast.makeText(SettingActivity.this,txt.getText().toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        user_image = (CircleImageView) findViewById(R.id.user_image);
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
//    public void showDialogListview(View view){
//        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
//        builder.setTitle("Choose Avatar");
////        builder.setItems(items, new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialog, int which) {
//////                if(which == 0)
//////                {
//////                    Intent galleryIntent = new Intent();
//////                    galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
//////                    galleryIntent.setType("image/*");
//////                    startActivityForResult(galleryIntent,Gallery_PICK);
//////                }
////                Toast.makeText(getApplicationContext(),items[which],Toast.LENGTH_LONG).show();
////            }
////        });
//        builder.setCancelable(true);
//        builder.setView(listView);
//        AlertDialog dialog = builder.create();
//        dialog.show();
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Gallery_PICK && resultCode == RESULT_OK && data != null)
        {
            Uri ImageUri = data.getData();
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);
        }
    }
}
