package com.example.wechat;

import android.os.Bundle;
import android.util.Log;
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

public class ContactsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.contacts_frag,container,false);

        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.contacts_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        ContactsAdapter adapter=new ContactsAdapter(getContacts());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<Contacts> getContacts()
    {
        List<Contacts> contactsList=new ArrayList<>();
        Contacts c1=new Contacts(R.drawable.ic_tx1,"小米");
        contactsList.add(c1);
        Contacts c2=new Contacts(R.drawable.ic_tx2,"NaNa");
        contactsList.add(c2);
        Contacts c3=new Contacts(R.drawable.ic_tx3,"山崎贤人");
        contactsList.add(c3);
        Contacts c4=new Contacts(R.drawable.ic_tx4,"小爱");
        contactsList.add(c4);
        Contacts c5=new Contacts(R.drawable.ic_tx5,"张老师");
        contactsList.add(c5);
        Contacts c6=new Contacts(R.drawable.ic_tx6,"代购AAA");
        contactsList.add(c6);
        Contacts c7=new Contacts(R.drawable.ic_tx7,"臭弟弟");
        contactsList.add(c7);
        Contacts c8=new Contacts(R.drawable.ic_tx8,"哥哥");
        contactsList.add(c8);
        Contacts c9=new Contacts(R.drawable.ic_tx9,"娜姐");
        contactsList.add(c9);

        return contactsList;
    }


    class ContactsAdapter extends RecyclerView.Adapter<ContactsFragment.ContactsAdapter.ViewHolder>{

        private List<Contacts> mContactsList;

        public ContactsAdapter(List<Contacts> mContactsList) {
            this.mContactsList = mContactsList;
        }

        @NonNull
        @Override
        public ContactsFragment.ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_item,parent,false);
            ViewHolder holder=new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ContactsFragment.ContactsAdapter.ViewHolder holder, int position) {
            Contacts contacts=mContactsList.get(position);
            holder.contactaTx.setImageResource(contacts.getTxId());
            holder.contactsText.setText(contacts.getContacter());

        }

        @Override
        public int getItemCount() {
            return mContactsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView contactaTx;
            TextView contactsText;
            public ViewHolder(View view)
            {
                super(view);
                contactaTx=(ImageView) view.findViewById(R.id.contacts_tx);
                contactsText=(TextView) view.findViewById(R.id.contacts_content);
            }
        }
    }
}
