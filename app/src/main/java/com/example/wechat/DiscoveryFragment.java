package com.example.wechat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DiscoveryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.discovery_frag,container,false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_dis);
        toolbar.setTitle("发现");
        toolbar.inflateMenu(R.menu.toolbarmenu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.sousuo:
                        Toast.makeText(getContext(),"QWQ",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.faqiqunliao:
                        Toast.makeText(getContext(),"QWQ",Toast.LENGTH_SHORT).show();
                        break;
                    default:break;
                }
                return false;
            }
        });

        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.discovery_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        DiscoveryAdapter adapter=new DiscoveryAdapter(getDiscovery());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Discovery> getDiscovery()
    {
        List<Discovery> newsList=new ArrayList<>();

            Discovery news1=new Discovery(R.drawable.ic_pyq,R.drawable.ic_tx4,"朋友圈");
            newsList.add(news1);
            Discovery news2=new Discovery(R.drawable.ic_saiyisao_yuan,0,"扫一扫");
            newsList.add(news2);
            Discovery news3=new Discovery(R.drawable.ic_yaoyiyao,0,"摇一摇");
            newsList.add(news3);
            Discovery news4=new Discovery(R.drawable.ic_kanyikan,0,"看一看");
            newsList.add(news4);
            Discovery news5=new Discovery(R.drawable.ic_souyisou,0,"搜一搜");
            newsList.add(news5);
            Discovery news6=new Discovery(R.drawable.ic_fujinderen,0,"附近的人");
            newsList.add(news6);
            Discovery news7=new Discovery(R.drawable.ic_shopping,0,"购物");
            newsList.add(news7);
            Discovery news8=new Discovery(R.drawable.ic_game,0,"游戏");
            newsList.add(news8);
            Discovery news9=new Discovery(R.drawable.ic_xiaocxu,0,"小程序");
            newsList.add(news9);

        return newsList;
    }


    class DiscoveryAdapter extends RecyclerView.Adapter<DiscoveryFragment.DiscoveryAdapter.ViewHolder>{

        private List<Discovery> mDiscoveryList;

        public DiscoveryAdapter(List<Discovery> mDiscoveryList) {
            this.mDiscoveryList = mDiscoveryList;
        }

        @NonNull
        @Override
        public DiscoveryFragment.DiscoveryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.discovery_item,parent,false);
            final DiscoveryFragment.DiscoveryAdapter.ViewHolder holder=new DiscoveryFragment.DiscoveryAdapter.ViewHolder(view);
            holder.friendsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=holder.getAdapterPosition();
                    Discovery discovery=mDiscoveryList.get(position);
                    if (discovery.getDs()=="朋友圈") {
                        Intent intent = new Intent(getContext(),Frends_Circle.class);
                        startActivity(intent);
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull DiscoveryFragment.DiscoveryAdapter.ViewHolder holder, int position) {
            Discovery discovery=mDiscoveryList.get(position);
            holder.discoveryIcon.setImageResource(discovery.getIcon());
            holder.discoveryText.setText(discovery.getDs());
            holder.discoveryImage.setImageResource(discovery.getImage());

        }

        @Override
        public int getItemCount() {
            return mDiscoveryList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            View friendsView;
            ImageView discoveryIcon;
            TextView discoveryText;
            ImageView discoveryImage;
            public ViewHolder(View view)
            {
                super(view);
                friendsView=view;
                discoveryIcon=(ImageView) view.findViewById(R.id.discovery_icon);
                discoveryText=(TextView) view.findViewById(R.id.discovery__tab);
                discoveryImage=(ImageView) view.findViewById(R.id.discovery_image);
            }
        }
    }
}
