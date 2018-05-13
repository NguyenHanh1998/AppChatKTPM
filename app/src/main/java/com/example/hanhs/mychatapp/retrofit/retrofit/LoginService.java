package com.example.hanhs.mychatapp.retrofit.retrofit;

import com.example.hanhs.mychatapp.retrofit.retrofit.response.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Hanhs on 5/4/2018.
 */

public interface LoginService {

    @FormUrlEncoded
    @POST("/api/login")
    Call<LoginResponse> login(@FieldMap Map<String, String> body);

    //@POST("/api/login")
    //Call<LoginResponse> signIn(@Body LoginRequest request);
}
