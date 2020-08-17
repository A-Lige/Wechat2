package com.example.wechat;

import android.widget.ImageView;

public class Message {
    private String id;
    private String content;
    private int tx;

    public Message(String id, String content, int tx) {
        this.id = id;
        this.content = content;
        this.tx = tx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTx() {
        return tx;
    }

    public void setTx(int tx) {
        this.tx = tx;
    }
}
