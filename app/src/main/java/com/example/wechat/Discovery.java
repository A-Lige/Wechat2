package com.example.wechat;

import android.widget.ImageView;

public class Discovery {

    private int icon;
    private int image;
    private String ds;

    public Discovery(int icon, int image, String ds) {
        this.icon = icon;
        this.image = image;
        this.ds = ds;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }
}
