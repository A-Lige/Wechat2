package com.example.wechat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.view.View.generateViewId;
import static com.example.wechat.RoundRectImageView.getRoundBitmapByShader;

public class FrendsCircleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final static int METYPE=0;
    public final static int DYNAMIC=1;

    private All all;
    private Context context;
    private LayoutInflater inflater;

    Activity activity;

    public FrendsCircleAdapter(All all) {
        this.all = all;
    }

    public class VH extends RecyclerView.ViewHolder{
        ImageView Tx;

        public VH(@NonNull View itemView) {
            super(itemView);
            Tx = (ImageView)itemView.findViewById(R.id.pyq_tx);
        }
    }

    public class VH1 extends RecyclerView.ViewHolder{
        ImageView frendstx;
        TextView frendsid;
        ExpandTextView pyqtext;
        ImageView pyqimage;
        TextView time;
        TextView pinglun;

        public VH1(@NonNull View itemView) {
            super(itemView);
            frendstx = (ImageView)itemView.findViewById(R.id.pyq_friends_tx);Log.d("QWQ","kj1");
            frendsid = (TextView)itemView.findViewById(R.id.pyq_friends_id);Log.d("QWQ","kj2");
            pyqtext = (ExpandTextView) itemView.findViewById(R.id.friendscircle_text);Log.d("QWQ","kj3");
            pyqimage = (ImageView) itemView.findViewById(R.id.pyq_friends_image);Log.d("QWQ","kj4");
            time = (TextView)itemView.findViewById(R.id.pyq_time);Log.d("QWQ","kj5");
            pinglun = (TextView)itemView.findViewById(R.id.pinglun);Log.d("QWQ","kj6");
        }
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("QWQ","test2");
        if (all.getMe()!=null){
            if (position==0)
                return METYPE;
        }
        else
            return DYNAMIC;
        return DYNAMIC;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context==null)
            context=parent.getContext();
        if (inflater==null)
            inflater=LayoutInflater.from(context);
        View view;
        switch (viewType){
            case METYPE:
                Log.d("QWQ","test4");
                view=inflater.inflate(R.layout.me_item,parent,false);
                return new VH(view);

            case DYNAMIC:
                Log.d("QWQ","test5");
                view=inflater.inflate(R.layout.dynamic_item,parent,false); Log.d("QWQ","test99");
                return new VH1(view);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VH)
        {
                Me me=all.getMe();Log.d("QWQ","test6");
                VH vh=(VH)holder;
                vh.Tx.setImageResource(me.getTx());

        }

        else if (holder instanceof VH1)
        {
            //position要视情况做调整
            Log.d("QWQ","test7");
            List<Dynamic> list=all.getDynamicList();
            VH1 vh1=(VH1)holder;
            vh1.frendstx.setImageResource(list.get(position).getFrends_tx());
            vh1.frendsid.setText(list.get(position).getFrends_id());

//            DisplayMetrics dm2 = vh1.pyqtext.getResources().getDisplayMetrics();
            vh1.pyqtext.setText(list.get(position).getPyq_text());
//            vh1.pyqtext.initWidth(dm2.widthPixels);//vh1.pyqtext.getResources().getDisplayMetrics()
//            // 设置最大行数
//            vh1.pyqtext.setMaxLines(7);
//            vh1.pyqtext.setCloseText(list.get(position).getPyq_text());

            vh1.pyqimage.setImageResource(list.get(position).getPyq_image());
            vh1.time.setText(list.get(position).getTime());
            vh1.pinglun.setText(list.get(position).getPinglun());

            //给图片加圆角
            Bitmap bitmap = BitmapFactory.decodeResource(vh1.frendstx.getResources(), list.get(position).getFrends_tx());
            Bitmap outBitmap =getRoundBitmapByShader(bitmap, 500,500,50, 0);
            vh1.frendstx.setImageBitmap(outBitmap);


        }

    }



    @Override
    public int getItemCount() {
        //同position一起调整
        return all.getDynamicList().size();
    }


}
