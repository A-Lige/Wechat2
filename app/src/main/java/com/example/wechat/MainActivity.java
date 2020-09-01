package com.example.wechat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private TextView weixin;
//    private TextView lxren;
//    private TextView faxian;
//    private TextView me;
    TabLayout tabLayout;
    ViewPager viewPager;
    List<Fragment> fglist=new ArrayList<>();
    List<String> list=new ArrayList<>();
    MyFragmentAdapter myFragmentAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        getWindow().setStatusBarColor(0xff24cf5f);
        setContentView(R.layout.activity_main);
        initView();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//
//            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//        }
    }
    private void initView(){
        fglist.add(new MessageFragment());
        fglist.add(new ContactsFragment());
        fglist.add(new DiscoveryFragment());
        fglist.add(new PersonalFragment());

        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),fglist,this);
        viewPager.setAdapter(myFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i=0;i<4;i++){
            TabLayout.Tab tab=tabLayout.getTabAt(i);
            tab.setCustomView(myFragmentAdapter.getView(i));

            if (i==0){
                ((TextView)tab.getCustomView().findViewById(R.id.message_btn)).setSelected(true);
                ((ImageView)tab.getCustomView().findViewById(R.id.aicon)).setSelected(true);
            }
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ((ImageView) tab.getCustomView().findViewById(R.id.aicon)).setSelected(true);
                ((TextView) tab.getCustomView().findViewById(R.id.message_btn)).setSelected(true);
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((ImageView) tab.getCustomView().findViewById(R.id.aicon)).setSelected(false);
                ((TextView) tab.getCustomView().findViewById(R.id.message_btn)).setSelected(false);
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
////        weixin=(TextView) findViewById(R.id.message_btn);
////        lxren=(TextView) findViewById(R.id.contacts_btn);
////        faxian=(TextView) findViewById(R.id.discovery_btn);
////        me=(TextView) findViewById(R.id.personal_btn);
//        tabLayout=findViewById(R.id.tab_layout);
//        viewPager=findViewById(R.id.viewpager);
//
////        weixin.setOnClickListener(l);
////        lxren.setOnClickListener(l);
////        faxian.setOnClickListener(l);
////        me.setOnClickListener(l);
//        fglist.add(new MessageFragment());
//        fglist.add(new ContactsFragment());
//        fglist.add(new DiscoveryFragment());
//        fglist.add(new PersonalFragment());
//
//        list.add("微信");
//        list.add("通讯录");
//        list.add("发现");
//        list.add("我");
//
//        MyFragmentAdapter myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),fglist,list);
//        viewPager.setAdapter(myFragmentAdapter);
//        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_message_selected);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_contacts);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_dicovery);
//        tabLayout.getTabAt(3).setIcon(R.drawable.ic_personal);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition())
//                {
//                    case 0:
//                        tab.setIcon(R.drawable.ic_message_selected);
//                        break;
//                    case 1:
//                        tab.setIcon(R.drawable.ic_contacts_selected);
//                        break;
//                    case 2:
//                        tab.setIcon(R.drawable.ic_dicovery_selected);
//                        break;
//                    case 3:
//                        tab.setIcon(R.drawable.ic_personal_selected);
//                        break;
//                    default:break;
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                switch (tab.getPosition())
//                {
//                    case 0:
//                        tab.setIcon(R.drawable.ic_message);
//                        break;
//                    case 1:
//                        tab.setIcon(R.drawable.ic_contacts);
//                        break;
//                    case 2:
//                        tab.setIcon(R.drawable.ic_dicovery);
//                        break;
//                    case 3:
//                        tab.setIcon(R.drawable.ic_personal);
//                        break;
//                    default:break;
//                }
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//
////        lxren.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                replaceFragment(new ContactsFragment());
//////                Toast.makeText(MainActivity.this,"QWQ",Toast.LENGTH_SHORT).show();
////            }
////        });
////
////        faxian.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                replaceFragment(new DiscoveryFragment());
////                //Toast.makeText(MainActivity.this,"QWQ",Toast.LENGTH_SHORT).show();
////            }
////        });
////
////        weixin.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                replaceFragment(new MessageFragment());
////            }
////        });
//
//    }
//
////    View.OnClickListener l=new View.OnClickListener() {
////        @Override
////        public void onClick(View v) {
////            FragmentManager fragmentManager=getSupportFragmentManager();
////            FragmentTransaction transaction = fragmentManager.beginTransaction();
////            Fragment f=null;
////            switch (v.getId())
////            {
////                case R.id.message_btn:
////                    f=new MessageFragment();
////                    break;
////
////                case R.id.contacts_btn:
////                    f=new ContactsFragment();
////                    break;
////
////                case R.id.discovery_btn:
////                    f=new DiscoveryFragment();
////                    break;
////
////                case R.id.personal_btn:
////                    f=new PersonalFragment();
////                    break;
////
////                default:break;
////            }
////            transaction.replace(R.id.qwq_layout,f);
////            transaction.commit();
////        }
////    };
//
////    public void  replaceFragment(Fragment fragment){
////        FragmentManager fragmentManager = getSupportFragmentManager();
////        FragmentTransaction transaction = fragmentManager.beginTransaction();
////        transaction.replace(R.id.qwq_layout,fragment);
////        transaction.commit();
////    }
}