package com.example.hanhs.mychatapp.retrofit.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hanhs on 5/3/2018.
 */

public class LoginInfor {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
