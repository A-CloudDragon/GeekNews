package com.jiyun.geeknews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.geeknews.R;
import com.jiyun.geeknews.bean.WeChatBean;

import java.util.ArrayList;
import java.util.List;

public class WechatAdapter extends RecyclerView.Adapter<WechatAdapter.WechatViewHolder> {

    private Context context;
    private List<WeChatBean.NewslistBean> list;

    public WechatAdapter(Context context, ArrayList<WeChatBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }






    @NonNull
    @Override
    public WechatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wechat_item, null);
        return new WechatViewHolder(inflate);
    }






    @Override
    public void onBindViewHolder(@NonNull WechatViewHolder wechatViewHolder, int i) {
        WeChatBean.NewslistBean newslistBean = list.get(i);

        wechatViewHolder.title.setText(newslistBean.getTitle());
        wechatViewHolder.name.setText(newslistBean.getDescription());
        wechatViewHolder.pppp.setText(newslistBean.getCtime());
        Glide.with(context).load(newslistBean.getPicUrl()).into(wechatViewHolder.img);

    }







    @Override
    public int getItemCount() {
        return list.size();
    }






    public void getData(List<WeChatBean.NewslistBean> beans){
        Log.e("TAG","解析结果:"+beans);
        list.clear();
        list.addAll(beans);
        notifyDataSetChanged();
    }






    class WechatViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title,name,pppp;
        public WechatViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.wechat_img);
            title = itemView.findViewById(R.id.wechat_title);
            name = itemView.findViewById(R.id.wechat_name);
            pppp = itemView.findViewById(R.id.wechat_pppp);
        }
    }
}
