package com.jiyun.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.geeknews.R;
import com.jiyun.geeknews.bean.WelfareBean;

import java.util.List;

public class Gank_WelfareAdapter extends RecyclerView.Adapter<Gank_WelfareAdapter.welfareViewHolder> {

    private Context context;
    private List<WelfareBean.ResultsBean> list;

    public Gank_WelfareAdapter(Context context, List<WelfareBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public welfareViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gank_welfare_item, null);
        return new  welfareViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull welfareViewHolder welfareViewHolder, int i) {
        WelfareBean.ResultsBean resultsBean = list.get(i);

        Glide.with(context).load(resultsBean.getUrl()).into(welfareViewHolder.img);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }






    public void getClear(){
        list.clear();
    }


    public void getData(List<WelfareBean.ResultsBean> beans){
        list.addAll(beans);
        notifyDataSetChanged();
    }

    class welfareViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        public welfareViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.gank_welfare_img);
        }
    }
}
