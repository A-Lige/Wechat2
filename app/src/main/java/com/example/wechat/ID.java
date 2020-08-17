package com.example.wechat;

public class ID {
    private int idtx;
    private String idname;
    private String idnumb;

    public ID(int idtx, String idname, String idnumb) {
        this.idtx = idtx;
        this.idname = idname;
        this.idnumb = idnumb;
    }

    public int getIdtx() {
        return idtx;
    }

    public void setIdtx(int idtx) {
        this.idtx = idtx;
    }

    public String getIdname() {
        return idname;
    }

    public void setIdname(String idname) {
        this.idname = idname;
    }

    public String getIdnumb() {
        return idnumb;
    }

    public void setIdnumb(String idnumb) {
        this.idnumb = idnumb;
    }
}
