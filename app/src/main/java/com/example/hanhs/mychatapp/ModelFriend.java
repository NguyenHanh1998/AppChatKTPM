package com.example.hanhs.mychatapp;

/**
 * Created by Hanhs on 3/27/2018.
 */

public class ModelFriend {
    private  int image;
    private String name,content,time;

    public ModelFriend(int image, String name, String content, String time) {
        this.image = image;
        this.name = name;
        this.content = content;
        this.time = time;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
