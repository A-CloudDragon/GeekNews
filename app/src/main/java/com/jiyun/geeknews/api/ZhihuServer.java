package com.jiyun.geeknews.api;

import com.jiyun.geeknews.bean.DailyWebBean;
import com.jiyun.geeknews.bean.Zhihu_ColumnBean;
import com.jiyun.geeknews.bean.Zhihu_DailyBean;
import com.jiyun.geeknews.bean.Zhihu_PopularBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ZhihuServer {
    String zhiuUrl = "http://news-at.zhihu.com/api/4/";


    //日报
    @GET("news/latest")
    Observable<Zhihu_DailyBean> getDaily();


    //专栏
    @GET("sections")
    Observable<Zhihu_ColumnBean> getColumn();


    //热门
    @GET("news/hot")
    Observable<Zhihu_PopularBean> getPopular();



    @GET("news/{news_id}")
    Observable<DailyWebBean> getDailyWeb(@Path("news_id") int newsId);


}
