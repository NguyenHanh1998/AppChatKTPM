package com.example.hanhs.mychatapp;

/**
 * Created by Hanhs on 4/30/2018.
 */

public class ModelRequest  {
    private  int image_request;
    private String name_request;

    public ModelRequest(int image, String name) {
        this.image_request = image;
        this.name_request = name;
        //this.check = check;
    }

    public int getImage() {
        return image_request;
    }

    public void setImage(int image) {
        this.image_request = image;
    }

    public String getName() {
        return name_request;
    }

    public void setName(String name) {
        this.name_request = name;
    }

}
