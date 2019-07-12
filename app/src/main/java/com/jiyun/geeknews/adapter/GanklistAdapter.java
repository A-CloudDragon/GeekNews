package com.jiyun.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.bean.GankBean;

import java.util.List;

public class GanklistAdapter extends RecyclerView.Adapter<GanklistAdapter.GankViewHolder> {

    private Context context;
    private List<GankBean.ResultsBean> list;

    public GanklistAdapter(Context context, List<GankBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gank_item, null);
        return new GankViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull GankViewHolder gankViewHolder, int i) {
        GankBean.ResultsBean resultsBean = list.get(i);

        gankViewHolder.naem1.setText(resultsBean.getDesc());
        gankViewHolder.name2.setText(resultsBean.getWho());

        String publishedAt = resultsBean.getPublishedAt();
        String[] split = publishedAt.split("T");
        gankViewHolder.name3.setText(split[0]);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<GankBean.ResultsBean> lis){

        list.clear();
        list.addAll(lis);
        notifyDataSetChanged();

    }

    class GankViewHolder extends RecyclerView.ViewHolder {
        private ImageView img1,img2;
        private TextView naem1,name2,name3;
        public GankViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.gank_img_img1);
            img2 = itemView.findViewById(R.id.gank_ima_img2);
            naem1 = itemView.findViewById(R.id.gank_desc);
            name2 = itemView.findViewById(R.id.gank_who);
            name3 = itemView.findViewById(R.id.gank_publishedAt);
        }
    }
}
