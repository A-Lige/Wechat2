package com.example.wechat;

import java.util.List;

public class All {
    private List<Dynamic> dynamicList;
    private Me me;

    public All(List<Dynamic> dynamicList, Me me) {
        this.dynamicList = dynamicList;
        this.me = me;
    }

    public List<Dynamic> getDynamicList() {
        return dynamicList;
    }

    public void setDynamicList(List<Dynamic> dynamicList) {
        this.dynamicList = dynamicList;
    }

    public Me getMe() {
        return me;
    }

    public void setMe(Me me) {
        this.me = me;
    }
}
