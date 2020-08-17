package com.example.wechat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.message_frag,container,false);

        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.message_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        MessageAdapter adapter=new MessageAdapter(getMessage());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Message> getMessage()
    {
        List<Message> messagesList=new ArrayList<>();

            Message m1=new Message("小米",getRandomLengthContent("你好鸭"),R.drawable.ic_tx2);
            messagesList.add(m1);
            Message m2=new Message("小爱",getRandomLengthContent("你好鸭"),R.drawable.ic_tx1);
            messagesList.add(m2);
            Message m3=new Message("nana",getRandomLengthContent("你好鸭"),R.drawable.ic_tx3);
            messagesList.add(m3);
            Message m4=new Message("张老师",getRandomLengthContent("你好鸭"),R.drawable.ic_tx4);
            messagesList.add(m4);
            Message m5=new Message("妈咪",getRandomLengthContent("你好鸭"),R.drawable.ic_tx5);
            messagesList.add(m5);
            Message m6=new Message("山崎贤人",getRandomLengthContent("你好鸭"),R.drawable.ic_tx6);
            messagesList.add(m6);
            Message m7=new Message("哥哥",getRandomLengthContent("你好鸭"),R.drawable.ic_tx7);
            messagesList.add(m7);
            Message m8=new Message("臭弟弟",getRandomLengthContent("你好鸭"),R.drawable.ic_tx8);
            messagesList.add(m8);
            Message m9=new Message("娜姐",getRandomLengthContent("你好鸭"),R.drawable.ic_tx9);
            messagesList.add(m9);
            Message m10=new Message("Helen",getRandomLengthContent("你好鸭"),R.drawable.ic_tx1);
            messagesList.add(m10);
            Message m11=new Message("带刺的玫瑰",getRandomLengthContent("你好鸭"),R.drawable.ic_tx2);
            messagesList.add(m11);
            Message m12=new Message("代购AAA",getRandomLengthContent("你好鸭"),R.drawable.ic_tx8);
            messagesList.add(m12);

        return messagesList;
    }
    private String getRandomLengthContent(String content)
    {
        Random random=new Random();
        int length=random.nextInt(10)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++)
        {
            builder.append(content);
        }
        return builder.toString();
    }

    class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{

        private List<Message> mMessageList;

        public MessageAdapter(List<Message> mMessageList) {
            this.mMessageList = mMessageList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false);
            ViewHolder holder=new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Message message=mMessageList.get(position);
            holder.mId.setText(message.getId());
            holder.mtx.setImageResource(message.getTx());
            holder.messageText.setText(message.getContent());

        }

        @Override
        public int getItemCount() {
            return mMessageList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView mId;
            ImageView mtx;
            TextView messageText;

            public ViewHolder(View view)
            {
                super(view);
                mId=(TextView) view.findViewById(R.id.contacts_id);
                mtx=(ImageView) view.findViewById(R.id.touxiang);
                messageText=(TextView) view.findViewById(R.id.message_content);
            }
        }
    }
}
