package com.example.wechat;

public class Contacts {

    private int txId;
    private String contacter;

    public Contacts(int txId, String contacter) {
        this.txId = txId;
        this.contacter = contacter;
    }

    public int getTxId() {
        return txId;
    }

    public void setTxId(int txId) {
        this.txId = txId;
    }

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }
}
