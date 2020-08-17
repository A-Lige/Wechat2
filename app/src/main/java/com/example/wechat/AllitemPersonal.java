package com.example.wechat;

import java.util.List;

public class AllitemPersonal {
    private ID id;
    private List<Function> functions;


    public AllitemPersonal(ID id, List<Function> functions) {
        this.id = id;
        this.functions = functions;

    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }



}
