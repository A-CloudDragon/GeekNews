package com.jiyun.geeknews.api;

import com.jiyun.geeknews.bean.WeChatBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeChatService {

    String url = "http://api.tianapi.com/";


    @GET("wxnew/?")
    Observable<WeChatBean> getWechatData(@Query("key") String key,@Query("num") int num,@Query("page") int page);





    @GET("wxnew/?")
    Observable<WeChatBean> getSearchData(@Query("key") String key,@Query("num") int num,@Query("page") int page);


}
