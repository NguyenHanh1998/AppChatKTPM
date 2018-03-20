package com.example.hanhs.mychatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    private EditText registerUserName;
    private EditText registerUserEmail;
    private EditText registerUserPass;
    private Toolbar registerBar;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        registerButton = (Button) findViewById(R.id.register_button);
        registerUserName = (EditText) findViewById(R.id.register_name);
        registerUserEmail = (EditText) findViewById(R.id.register_email);
        registerUserPass = (EditText) findViewById(R.id.register_pass);
        registerUserPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        loadingBar = new ProgressDialog(this);

        registerBar = (Toolbar) findViewById(R.id.register_app_bar);
        setSupportActionBar(registerBar);
        getSupportActionBar().setTitle("Sign up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//add return button

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = registerUserName.getText().toString();
                String email = registerUserEmail.getText().toString();
                String password = registerUserPass.getText().toString();

                RegisterUserAcount(name, email, password);
            }

        });
    }

    private void RegisterUserAcount(String name, String email, String password) {

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(RegisterActivity.this, " Please write your name", Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(RegisterActivity.this, " Please write your email", Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(RegisterActivity.this, " Please write your password", Toast.LENGTH_LONG).show();
        } else {

            loadingBar.setTitle("Creating a new acount");
            loadingBar.setMessage("Please wait. we are checking the progress");
            loadingBar.show();
         /*  mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {*/
                        Intent mainTentRegister = new Intent(RegisterActivity.this, MainPlusActivity.class);
                        mainTentRegister.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(mainTentRegister);
                        finish();
                 /*  } else {
                        Toast.makeText(RegisterActivity.this, "Error ocurred...  Try again!", Toast.LENGTH_SHORT).show();
                    }
                    loadingBar.dismiss();
                }
            });*/
        }
    }
}
