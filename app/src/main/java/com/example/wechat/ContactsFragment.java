package com.example.wechat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.wechat.RoundRectImageView.getRoundBitmapByShader;

public class ContactsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.contacts_frag,container,false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_con);
        toolbar.setTitle("通讯录");
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
        Contacts c1=new Contacts(R.drawable.pytx19,"小米");
        contactsList.add(c1);
        Contacts c2=new Contacts(R.drawable.pytx18,"NaNa");
        contactsList.add(c2);
        Contacts c3=new Contacts(R.drawable.pytx17,"山崎贤人");
        contactsList.add(c3);
        Contacts c4=new Contacts(R.drawable.pytx16,"小爱");
        contactsList.add(c4);
        Contacts c5=new Contacts(R.drawable.pytx15,"张老师");
        contactsList.add(c5);
        Contacts c6=new Contacts(R.drawable.pytx14,"代购AAA");
        contactsList.add(c6);
        Contacts c7=new Contacts(R.drawable.pytx13,"臭弟弟");
        contactsList.add(c7);
        Contacts c8=new Contacts(R.drawable.pytx12,"哥哥");
        contactsList.add(c8);
        Contacts c9=new Contacts(R.drawable.pytx11,"娜姐");
        contactsList.add(c9);
        Contacts c10=new Contacts(R.drawable.pytx10,"小米");
        contactsList.add(c10);
        Contacts c11=new Contacts(R.drawable.pytx9,"Merry");
        contactsList.add(c11);
        Contacts c12=new Contacts(R.drawable.pytx8,"周周");
        contactsList.add(c12);
        Contacts c13=new Contacts(R.drawable.pytx7,"小也");
        contactsList.add(c13);
        Contacts c14=new Contacts(R.drawable.pytx6,"阿树");
        contactsList.add(c14);
        Contacts c15=new Contacts(R.drawable.pytx5,"风浔");
        contactsList.add(c15);
        Contacts c16=new Contacts(R.drawable.pytx4,"小可爱");
        contactsList.add(c16);
        Contacts c17=new Contacts(R.drawable.pytx3,"胖胖");
        contactsList.add(c17);
        Contacts c18=new Contacts(R.drawable.pytx2,"咪咪");
        contactsList.add(c18);
        Contacts c19=new Contacts(R.drawable.pytx1,"小箱儿");
        contactsList.add(c19);



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

            Bitmap bitmap = BitmapFactory.decodeResource(holder.contactaTx.getResources(), mContactsList.get(position).getTxId());
            Bitmap outBitmap =getRoundBitmapByShader(bitmap, 500,500,50, 0);
            holder.contactaTx.setImageBitmap(outBitmap);

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
