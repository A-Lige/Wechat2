package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Frends_Circle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frends__circle);

        RecyclerView recyclerView=findViewById(R.id.recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        Log.d("QWQ","test1");
        All all=new All(getDynamic(),new Me(R.drawable.tx));
        recyclerView.setAdapter(new FrendsCircleAdapter(all));
        Log.d("QWQ","test0");
    }

    private List<Dynamic> getDynamic(){
        List<Dynamic> dynamicList=new ArrayList<>();
        dynamicList.add(new Dynamic(R.drawable.pytx6,"小岚","今天好开心",R.drawable.pytx9,"今天 20:28",null));
        dynamicList.add(new Dynamic(R.drawable.pytx7,"小耳朵","小时候想不明白，节日的作用是什么？长大了才懂得，节日，是让幸福的人更幸福，孤独的人更孤独。",0,"今天 21:22","他：哈哈哈哈。"));

        return dynamicList;
    }
}