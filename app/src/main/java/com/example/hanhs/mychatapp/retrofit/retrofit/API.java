package com.example.hanhs.mychatapp.retrofit.retrofit;


public class API {

    public static <ServiceClass> ServiceClass createService(Class<ServiceClass> service) {
       return RetrofitClient.getClient().create(service);

   }
}
