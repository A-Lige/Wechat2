package com.example.wechat;

public class Dynamic {
    private int frends_tx;
    private String frends_id;
    private String pyq_text;
    private int pyq_image;
    private String time;
    private String pinglun;

    public Dynamic(int frends_tx, String frends_id, String pyq_text, int pyq_image, String time, String pinglun) {
        this.frends_tx = frends_tx;
        this.frends_id = frends_id;
        this.pyq_text = pyq_text;
        this.pyq_image = pyq_image;
        this.time = time;
        this.pinglun = pinglun;
    }

    public int getFrends_tx() {
        return frends_tx;
    }

    public void setFrends_tx(int frends_tx) {
        this.frends_tx = frends_tx;
    }

    public String getFrends_id() {
        return frends_id;
    }

    public void setFrends_id(String frends_id) {
        this.frends_id = frends_id;
    }

    public String getPyq_text() {
        return pyq_text;
    }

    public void setPyq_text(String pyq_text) {
        this.pyq_text = pyq_text;
    }

    public int getPyq_image() {
        return pyq_image;
    }

    public void setPyq_image(int pyq_image) {
        this.pyq_image = pyq_image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPinglun() {
        return pinglun;
    }

    public void setPinglun(String pinglun) {
        this.pinglun = pinglun;
    }
}
