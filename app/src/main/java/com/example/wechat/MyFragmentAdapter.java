package com.example.wechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> fgList;
    List<String> list;
    final int PAGE_COUNT=4;
    private Context context;

//    public MyFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fgList, List<String> list) {
//        super(fm);
//        this.fgList = fgList;
//        this.list = list;
//    }
    public MyFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fgList, Context context) {
        super(fm);
        this.fgList = fgList;
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fgList.get(position);
    }

    @Override
    public int getCount() {
        return fgList.size();
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return  list.get(position);
//    }
public View getView(int position){
    View view= LayoutInflater.from(context).inflate(R.layout.tab_item,null);
    TextView textView=(TextView) view.findViewById(R.id.message_btn);
    ImageView imageView=(ImageView) view.findViewById(R.id.aicon);
    switch (position){
        case 0:
            textView.setText("微信");
            imageView.setImageResource(R.drawable.message_icon);
            break;
        case 1:
            textView.setText("通讯录");
            imageView.setImageResource(R.drawable.contacts_icon);
            break;
        case 2:
            textView.setText("发现");
            imageView.setImageResource(R.drawable.discovery_icon);
            break;
        case 3:
            textView.setText("我");
            imageView.setImageResource(R.drawable.personal_icon);
            break;
    }
    return view;
}
}
