package com.example.wechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.wechat.RoundRectImageView.getRoundBitmapByShader;

public class Frends_Circle extends AppCompatActivity implements View.OnClickListener {

    private ImageView creame;
    private ImageView backtodis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frends__circle);
        creame = (ImageView)findViewById(R.id.creame);
        backtodis = (ImageView)findViewById(R.id.backtodis);
        backtodis.setOnClickListener(this);
        creame = (ImageView) findViewById(R.id.creame);
        creame.setOnClickListener(this);
        //多item的RecyclerView
        RecyclerView recyclerView=findViewById(R.id.recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        All all=new All(getDynamic(),null);
        recyclerView.setAdapter(new FrendsCircleAdapter(all));

        //自己的头像设置圆角
        ImageView mine_tx = (ImageView)findViewById(R.id.pyq_tx);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pytx3);
        Bitmap outBitmap =getRoundBitmapByShader(bitmap, 500,500,50, 0);
        mine_tx.setImageBitmap(outBitmap);


        //悬停效果设置
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbarLayout.setTitle("朋友圈");

        //折叠和非折叠状态的控件效果
        AppBarLayout appBarLayout = findViewById(R.id.appBar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int color = Color.argb(200,0,0,0);
                collapsingToolbarLayout.setCollapsedTitleTextColor(color);
                TextView title = (TextView)findViewById(R.id.title_friendsCirle);
                if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){//折叠状态
                    collapsingToolbarLayout.setTitle("");
                    title.setVisibility(View.VISIBLE);
                    creame.setImageResource(R.drawable.ic_creame);
                    backtodis.setImageResource(R.drawable.ic_back_black);
                }else {//非折叠状态
                    collapsingToolbarLayout.setTitle("");
                    title.setVisibility(View.GONE);
                    creame.setImageResource(R.drawable.ic_creame_white);
                    backtodis.setImageResource(R.drawable.ic_back);
                }
            }
        });

    }

    //悬停 返回按钮
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.backtodis:
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private List<Dynamic> getDynamic(){
        List<Dynamic> dynamicList=new ArrayList<>();
        dynamicList.add(new Dynamic(R.drawable.pytx6,"小岚","今天好开心",R.drawable.pytx9,"今天 20:28",null));
        dynamicList.add(new Dynamic(R.drawable.pytx7,"小耳朵","小时候想不明白，节日的作用是什么？长大了才懂得，节日，是让幸福的人更幸福，孤独的人更孤独。代表中国最广大人民的根本利益。党的最高理想和最终目标是实现共产主义。中国共产党是中国工人阶级的先锋队，同时是中国人民和中华民族的先锋队，是中国特色社会主义事业的领导核心，代表中国先进生产力的发展要求，代表中国先进文化的前进方向，代表中国zui1",0,"今天 21:22","他：哈哈哈哈。"));
        dynamicList.add(new Dynamic(R.drawable.pytx5,"Merry","又是元气满满的一天",R.drawable.pyq_photo1,"今天 8:28",null));
        return dynamicList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.creame:
                Intent intent = new Intent(this,Send_dynamic.class);
                startActivity(intent);
                break;
            case R.id.backtodis:
                finish();
        }
    }
}