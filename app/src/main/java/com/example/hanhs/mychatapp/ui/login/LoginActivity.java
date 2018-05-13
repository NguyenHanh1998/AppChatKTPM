package com.example.hanhs.mychatapp.ui.login;

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

import com.example.hanhs.mychatapp.MainPlusActivity;
import com.example.hanhs.mychatapp.R;
import com.example.hanhs.mychatapp.retrofit.retrofit.API;
import com.example.hanhs.mychatapp.retrofit.retrofit.LoginService;
import com.example.hanhs.mychatapp.retrofit.retrofit.response.LoginResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                    Map<String, String> body = new HashMap<>();
                    body.put("username", email);
                    body.put("password", password);
                    API.createService(LoginService.class)
                            .login(body)
                            .enqueue(new Callback<LoginResponse>() {
                                @Override
                                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                                    LoginResponse body = response.body();
                                    int code = body.getCode();
                                    if (code != 400) {
                                        return;
                                    }
                                    Intent mainTentLogin = new Intent(LoginActivity.this, MainPlusActivity.class);
                                    mainTentLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(mainTentLogin);
                                    finish();
                                }

                                @Override
                                public void onFailure(Call<LoginResponse> call, Throwable t) {
                                    t.printStackTrace();
                                }
                            });

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
