package com.example.hanhs.mychatapp.retrofit.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

   private static Retrofit retrofit;
    public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();//link server
       }
        return retrofit;
   }
}
