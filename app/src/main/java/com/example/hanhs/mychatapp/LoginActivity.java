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

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog loadingBar;

    private Toolbar mLoginbar;
    private EditText loginEmail;
    private EditText loginPassword;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = (EditText) findViewById(R.id.login_email);
        loginPassword = (EditText) findViewById(R.id.login_password);
        loginButton = (Button) findViewById(R.id.login_button);
        loginPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        loadingBar = new ProgressDialog(this);

        mLoginbar = (Toolbar) findViewById(R.id.login_page_bar);
        setSupportActionBar(mLoginbar);
        getSupportActionBar().setTitle("Sign in");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();

                LoginUserAcount(email, password);
            }

            private void LoginUserAcount(String email, String password) {

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this, " Please write your email", Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, " Please write your password", Toast.LENGTH_LONG).show();
                } else {

                    loadingBar.setTitle("Creating a new acount");
                    loadingBar.setMessage("Please wait. we are checking the progress");
                    loadingBar.show();
         /*  mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {*/
                    Intent mainTentLogin = new Intent(LoginActivity.this, MainPlusActivity.class);
                    mainTentLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(mainTentLogin);
                    finish();
                 /*  } else {
                        Toast.makeText(RegisterActivity.this, "Error ocurred...  Try again!", Toast.LENGTH_SHORT).show();
                    }
                    loadingBar.dismiss();
                }
            });*/
                }
            }

        });
    }
}
