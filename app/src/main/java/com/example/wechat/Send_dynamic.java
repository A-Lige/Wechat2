package com.example.wechat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.widget.EditText;


public class Send_dynamic extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_dynamic_text);

        EditText editText = (EditText)findViewById(R.id.edit_text);
        setEditTextHintSize(editText,"这一刻的想法...",16);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_send);
        setSupportActionBar(toolbar);
        //隐藏Toolbar标题
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    //自定义Hint文字的大小及文本
    public static void  setEditTextHintSize(EditText editText, String hintText, int size){
        SpannableString ss = new SpannableString(hintText);//定义hint的值
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(size,true);//设置字体大小 true表示单位是sp
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        editText.setHint(new SpannedString(ss));
    }
}