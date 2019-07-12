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
import com.bumptech.glide.request.RequestOptions;
import com.jiyun.geeknews.R;
import com.jiyun.geeknews.bean.Zhihu_DailyBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Zhihu_dailyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Zhihu_DailyBean.StoriesBean> dailyBean;
    private List<Zhihu_DailyBean.TopStoriesBean> topStoriesBeans ;
    private String date = "";
    private static int VIEW_TYPE_BANNER = 0;
    private static int VIEW_TYPE_TIME = 1;
    private static int VIEW_TYPE_NEWS = 2;
    private OnItemClickListener mListener;


    public Zhihu_dailyAdapter(Context context, List<Zhihu_DailyBean.StoriesBean> dailyBean, List<Zhihu_DailyBean.TopStoriesBean> topStoriesBeans) {
        this.context = context;
        this.dailyBean = dailyBean;
        this.topStoriesBeans = topStoriesBeans;
    }

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        if (i == VIEW_TYPE_BANNER){
//            View inflate1 = LayoutInflater.from(context).inflate(R.layout.zhihu_daily_item1, null);
//            return new DailyViewHolder1(inflate1);
//        }else if (i == VIEW_TYPE_TIME){
//            View inflate2 = LayoutInflater.from(context).inflate(R.layout.zhihu_daily_item2, null);
//            return new DailyViewHolder2(inflate2);
//        }else {
//            View inflate3 = LayoutInflater.from(context).inflate(R.layout.zhihu_daily_item3, null);
//            return new DailyViewHolder3(inflate3);
//        }
//    }





    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0){
            View inflate1 = LayoutInflater.from(context).inflate(R.layout.zhihu_daily_item1, null);
            return new DailyViewHolder1(inflate1);
        }else if (i == 1){
            View inflate2 = LayoutInflater.from(context).inflate(R.layout.zhihu_daily_item2, null);
            return new DailyViewHolder2(inflate2);
        }else {
            View inflate3 = LayoutInflater.from(context).inflate(R.layout.zhihu_daily_item3, null);
            return new DailyViewHolder3(inflate3);
        }
    }







    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        if (type == 0){
            DailyViewHolder1 d1 = (DailyViewHolder1) viewHolder;

            ArrayList<String> strings = new ArrayList<>();
            for (int s = 0;s<topStoriesBeans.size();s++){
                strings.add(topStoriesBeans.get(s).getImage());
            }

            d1.banner.setImages(strings);
            d1.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
//                    RequestOptions placeholder = new RequestOptions().placeholder(R.mipmap.bg_drawer);
//                    Glide.with(context).load(path).apply(placeholder).into(imageView);
                    Glide.with(context).load(path).into(imageView);
                }
            });
            d1.banner.start();

            Log.e("TAG","轮播图:"+strings+"");








        }else if (type == 1){
            DailyViewHolder2 d2 = (DailyViewHolder2) viewHolder;

        }else {
            int i1 = i - 1;
            if (topStoriesBeans.size() > 0){
                i1 -= 1;
            }

            DailyViewHolder3 d3 = (DailyViewHolder3) viewHolder;
            final Zhihu_DailyBean.StoriesBean storiesBean = dailyBean.get(i1);
            d3.title.setText(storiesBean.getTitle());
            List<String> images = storiesBean.getImages();
            if (images != null && images.size() > 0){
                RequestOptions requestOptions = new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher);
                Glide.with(context).load(images.get(0)).apply(requestOptions).into(d3.img);
            }


            int i11 = i1;
            final Zhihu_DailyBean.StoriesBean sss = dailyBean.get(i11);

            d3.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(sss);
                }
            });

        }
    }

//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
//        int type = getItemViewType(i);
//        if (type == VIEW_TYPE_BANNER){
//            DailyViewHolder1 d1 = (DailyViewHolder1) viewHolder;
//
//            d1.banner.setImages(topStoriesBeans)
//            .setImageLoader(new ImageLoader() {
//                @Override
//                public void displayImage(Context context, Object path, ImageView imageView) {
//                    Zhihu_DailyBean.TopStoriesBean bean1 = (Zhihu_DailyBean.TopStoriesBean) path;
//
//                    RequestOptions placeholder = new RequestOptions().placeholder(R.mipmap.bg_drawer);
//                    Glide.with(context).load(bean1.getImage()).apply(placeholder).into(imageView);
//                }
//            }).start();
//
//
//        }else if (type == VIEW_TYPE_TIME){
//            DailyViewHolder2 d2 = (DailyViewHolder2) viewHolder;
//
//        }else {
//            int i1 = i - 1;
//            if (topStoriesBeans.size() > 0){
//                i1 -= 1;
//            }
//
//            DailyViewHolder3 d3 = (DailyViewHolder3) viewHolder;
//            Zhihu_DailyBean.StoriesBean storiesBean = dailyBean.get(i1);
//            d3.title.setText(storiesBean.getTitle());
//            List<String> images = storiesBean.getImages();
//            if (images != null && images.size() > 0){
//                RequestOptions requestOptions = new RequestOptions()
//                        .placeholder(R.mipmap.ic_launcher);
//                Glide.with(context).load(images.get(0)).apply(requestOptions).into(d3.img);
//            }
//
//
//            final int i11 = i1;
//            d3.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mListener != null){
//                        mListener.onItemClick(v,i11);
//                    }
//                }
//            });
//        }
//    }




//    @Override
//    public int getItemViewType(int position) {
//        if (topStoriesBeans.size() > 0) {
//            if (position == 0) {
//                return VIEW_TYPE_BANNER;
//            } else if (position == 1) {
//                return VIEW_TYPE_TIME;
//            } else {
//                return VIEW_TYPE_NEWS;
//            }
//        } else {
//            if (position == 0) {
//                return VIEW_TYPE_TIME;
//            } else {
//                return VIEW_TYPE_NEWS;
//            }
//        }
//
//    }

//    @Override
//    public int getItemCount() {
//        if (topStoriesBeans.size() > 0) {
//            return dailyBean.size() + 1 + 1;
//        } else {
//            return dailyBean.size() + 1;
//        }
//    }
    @Override
    public int getItemCount() {
            return dailyBean.size();
    }


    public int  getItemViewType(int position) {
            if (position == 0) {
                return 0;
            } else if (position == 1){
                return 1;
            }else{
                return 2;
            }

        }









    public void setData(Zhihu_DailyBean bean){
        date = bean.getDate();
        //轮播图
        List<Zhihu_DailyBean.TopStoriesBean> top_stories = bean.getTop_stories();
        topStoriesBeans.clear();
        topStoriesBeans.addAll(top_stories);



        //
        List<Zhihu_DailyBean.StoriesBean> stories = bean.getStories();
        dailyBean.clear();
        dailyBean.addAll(stories);
        notifyDataSetChanged();

    }







        class DailyViewHolder1 extends RecyclerView.ViewHolder {
        private Banner banner;
            public DailyViewHolder1(@NonNull View itemView) {
                super(itemView);
                banner = itemView.findViewById(R.id.daily_banner);
            }
        }


        class DailyViewHolder2 extends RecyclerView.ViewHolder {
        private TextView text;
            public DailyViewHolder2(@NonNull View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.daily_text);
            }
        }


        class DailyViewHolder3 extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private View view;
            public DailyViewHolder3(@NonNull View itemView) {
                super(itemView);
            img = itemView.findViewById(R.id.daily_image);
            title = itemView.findViewById(R.id.daily_title);
            view = itemView;
            }
        }




    public interface OnItemClickListener {
        void onItemClick(Zhihu_DailyBean.StoriesBean pos);
    }

    public void setmListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }
}
