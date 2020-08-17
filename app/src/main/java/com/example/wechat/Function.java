package com.example.wechat;

public class Function {
    private int icon;
    private String tab;

    public Function(int icon, String tab) {
        this.icon = icon;
        this.tab = tab;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }
}
