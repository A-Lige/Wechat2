package com.example.wechat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonalFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.personal_frag,container,false);

//        RecyclerView mRecy=(RecyclerView) view.findViewById(R.id.personal_recycler_view);
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),4);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) //决定占1行还是半行（return 4表示一行）
//            {
//                if(position==0)
//                    return 4;
//                else if (position==2||4<=position&&position<=7||position==9)
//                    return 4;
//                else
//                    return 4;
//            }
//        });
//        mRecy.setLayoutManager(gridLayoutManager);
//        //设置适配器
//        MyRecyclerAdapter adapter = new MyRecyclerAdapter();
//        mRecy.setAdapter(adapter);

        /*
        RecyclerView recyclerView=view.findViewById(R.id.personal_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        AllitemPersonal all=new AllitemPersonal(new ID(R.drawable.ic_tx5,"Lisa","微信号：dwoqy11"),getFunction());
        recyclerView.setAdapter(new MyRecyclerAdapter(all));*/
        return view;
    }
    /*
    private List<Function> getFunction(){

        List<Function> functionList=new ArrayList<>();
        functionList.add(new Function(R.drawable.ic_pay,"支付"));


        return functionList;
    }

    public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//        private  List<List> mlist;

//        public MyRecyclerAdapter(List<List> mlist) {
//            this.mlist = mlist;
//        }

        public final static int IDTYPE=1001;
        public final static int FUNCTIONTYPE=1002;
        public final static int LINETYPE=1003;
        private AllitemPersonal all;
        private Context context;
        private LayoutInflater Inflater;

        public MyRecyclerAdapter(AllitemPersonal all) {
            this.all = all;
        }

        public class VH extends RecyclerView.ViewHolder
        {
            TextView mTextView;
            TextView mIdnumbTextView;
            ImageView mIdtx;

            public VH(@NonNull View itemView) {
                super(itemView);
                mTextView = (TextView)itemView.findViewById(R.id.id_name);
                mIdnumbTextView=(TextView)itemView.findViewById(R.id.id_number);
                mIdtx=(ImageView)itemView.findViewById(R.id.id_tx);
            }
        }

        public class VH1 extends RecyclerView.ViewHolder {
            ImageView mImageView;
            TextView mTextView;
            public VH1(View itemView) {
                super(itemView);
                mImageView= (ImageView) itemView.findViewById(R.id.discovery_icon);
                mTextView= (TextView) itemView.findViewById(R.id.discovery__tab);
            }
        }

        public class VH2 extends RecyclerView.ViewHolder {
            View mTextView;
            public VH2(View itemView) {
                super(itemView);
                mTextView= (View) itemView.findViewById(R.id.aline);
            }
        }
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view=null;
//            RecyclerView.ViewHolder viewHolder=null;
//            switch (viewType)
//            {
//                case 0:
//                    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.id_item,parent,false);
//                    viewHolder=new VH(view);
//                    break;
//                case 1:
//                    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.discovery_item,parent,false);
//                    viewHolder=new VH1(view);
//                    break;
//                case 2:
//                    view= LayoutInflater.from(parent.getContext()).inflate(R.layout.line,parent,false);
//                    viewHolder=new VH2(view);
//                    break;
//
//            }
//            return viewHolder;
            if (context==null)
                context=parent.getContext();
            if (Inflater==null)
                Inflater=LayoutInflater.from(context);
            View view;
            switch (viewType){
                case IDTYPE:
                    view=Inflater.inflate(R.layout.id_item,parent,false);
                    return new VH(view);
                case FUNCTIONTYPE:
                    view=Inflater.inflate(R.layout.discovery_item,parent,false);
                    return new VH1(view);
                case LINETYPE:
                    view=Inflater.inflate(R.layout.line,parent,false);
                    return new VH2(view);
            }

            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

//            int itemViewType=getItemViewType(position);
//            switch (itemViewType)
//            {
//                case 0:
//                    VH vh=(VH) holder;
//                    break;
//                case 1:
//                    VH1 vh1=(VH1) holder;
//                    break;
//                case 2:
//                    VH2 vh2=(VH2) holder;
//                    break;
//            }
            if (holder instanceof VH){
                ID id=all.getId();
                VH vh=(VH)holder;
                vh.mIdtx.setImageResource(id.getIdtx());
                vh.mTextView.setText(id.getIdname());
                vh.mIdnumbTextView.setText(id.getIdnumb());
            }
            else if (holder instanceof VH1){
                List<Function> functionList=all.getFunctions();
                VH1 vh1=(VH1)holder;
                vh1.mImageView.setImageResource(functionList.get(position-2).getIcon());
                vh1.mTextView.setText(functionList.get(position-2).getTab());
            }
            else if (holder instanceof VH2)
            {
                VH2 vh2=(VH2)holder;
                vh2.mTextView.setVisibility(View.VISIBLE);

            }
        }

        @Override
        public int getItemCount() {
            return all.getFunctions().size()+2;
//            return 43;
        }

        @Override
        public int getItemViewType(int position) //决定改行是什么item
        {
//            if (position==0)
//                return 0;
//            else if (position==2||4<=position&&position<=7||position==9)
//                return 1;
//            else
//                return 2;
            if (position==0)
            {
                return IDTYPE;
            }
            else if (position==1)
                return LINETYPE;

            else
            {
                return FUNCTIONTYPE;
            }


        }

//        public class VH extends RecyclerView.ViewHolder
//        {
//            TextView mTextView;
//
//            public VH(@NonNull View itemView) {
//                super(itemView);
//                mTextView = (TextView)itemView.findViewById(R.id.id_name);
//            }
//        }
//
//        public class VH1 extends RecyclerView.ViewHolder {
//            ImageView mImageView;
//            TextView mTextView;
//            public VH1(View itemView) {
//                super(itemView);
//                mImageView= (ImageView) itemView.findViewById(R.id.discovery_icon);
//                mTextView= (TextView) itemView.findViewById(R.id.discovery__tab);
//            }
//        }
//
//        public class VH2 extends RecyclerView.ViewHolder {
//            View mTextView;
//            public VH2(View itemView) {
//                super(itemView);
//                mTextView= (View) itemView.findViewById(R.id.aline);
//            }
//        }
    }*/

}
