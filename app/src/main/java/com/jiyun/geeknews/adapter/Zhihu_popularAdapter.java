package com.jiyun.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.geeknews.R;
import com.jiyun.geeknews.bean.Zhihu_PopularBean;

import java.util.List;

public class Zhihu_popularAdapter extends RecyclerView.Adapter<Zhihu_popularAdapter.PopularViewHolder> {

    private Context context;
    private List<Zhihu_PopularBean.RecentBean> list;

    public Zhihu_popularAdapter(Context context, List<Zhihu_PopularBean.RecentBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zhihu_popular_item1, null);
        return new PopularViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder popularViewHolder, int i) {
        Zhihu_PopularBean.RecentBean recentBean = list.get(i);

        popularViewHolder.text.setText(recentBean.getTitle());
        Glide.with(context).load(recentBean.getThumbnail()).into(popularViewHolder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public void getData(Zhihu_PopularBean bean){
        List<Zhihu_PopularBean.RecentBean> recent = bean.getRecent();
        list.clear();
        list.addAll(recent);
        notifyDataSetChanged();
    }

    class PopularViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        private ImageView img;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.zhihu_popular_img);
            text = itemView.findViewById(R.id.zhihu_popular_text);
        }
    }
}
