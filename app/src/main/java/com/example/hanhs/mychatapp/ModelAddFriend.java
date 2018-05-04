package com.example.hanhs.mychatapp;

/**
 * Created by Hanhs on 4/30/2018.
 */

public class ModelAddFriend {
    private  int image;
    private String name;

    public ModelAddFriend(int image, String name) {
        this.image = image;
        this.name = name;
        //this.check = check;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   // public String getTime() {
    //    return check;
   // }

    //public void setTime(String time) {
      //  this.check = check;
    //}
}
