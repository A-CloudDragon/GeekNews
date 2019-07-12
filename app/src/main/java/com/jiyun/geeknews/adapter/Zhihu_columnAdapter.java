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
import com.jiyun.geeknews.bean.Zhihu_ColumnBean;

import java.util.List;

public class Zhihu_columnAdapter extends RecyclerView.Adapter<Zhihu_columnAdapter.ColumnViewHolder> {

    private Context context;
    private List<Zhihu_ColumnBean.DataBean> list;

    public Zhihu_columnAdapter(Context context, List<Zhihu_ColumnBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ColumnViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zhihu_column_item1, null);
        return new ColumnViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ColumnViewHolder columnViewHolder, int i) {
        Zhihu_ColumnBean.DataBean dataBean = list.get(i);
        Glide.with(context).load(dataBean.getThumbnail()).into(columnViewHolder.rec);

        columnViewHolder.title.setText(dataBean.getDescription());
        columnViewHolder.name.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }








    public void getData(Zhihu_ColumnBean bean){
        List<Zhihu_ColumnBean.DataBean> data = bean.getData();
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

    class ColumnViewHolder extends RecyclerView.ViewHolder {
        private ImageView rec;
        private TextView title,name;
        public ColumnViewHolder(@NonNull View itemView) {
            super(itemView);
            rec = itemView.findViewById(R.id.zhihu_column_img);
            title = itemView.findViewById(R.id.zhihu_column_description);
            name = itemView.findViewById(R.id.zhihu_column_name);

        }
    }
}
