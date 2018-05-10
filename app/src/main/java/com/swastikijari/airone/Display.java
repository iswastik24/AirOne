package com.swastikijari.airone;

/**
 * Created by swastik ijari on 06-04-2018.
 */

public class Display {
    String image;
    String title;
    String desc;
    public Display(){
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Display(String image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }
}
