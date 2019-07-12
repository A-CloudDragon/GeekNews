package com.jiyun.geeknews.model;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.api.ZhihuServer;
import com.jiyun.geeknews.app.GeekApplication;
import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BaseModel;
import com.jiyun.geeknews.base.BaseObserver;
import com.jiyun.geeknews.bean.Zhihu_DailyBean;
import com.jiyun.geeknews.utils.HttpUtil;
import com.jiyun.geeknews.utils.RxUtil;


public class Zhihu_DailyModel extends BaseModel {
    public void Daily(final BaseCallBack<Zhihu_DailyBean,String> callBack){
        HttpUtil.getHttpUtil().getServer(ZhihuServer.zhiuUrl,ZhihuServer.class)
                .getDaily().compose(RxUtil.<Zhihu_DailyBean>rxObservableTransformer())
                .subscribe(new BaseObserver<Zhihu_DailyBean>() {
                    @Override
                    public void onNext(Zhihu_DailyBean dailyBean) {
                        if (dailyBean != null){
                            callBack.onSuccess(dailyBean);
                        }else{
                            callBack.onFail(GeekApplication.getApp().getResources().getString(R.string.net_data_null));
                        }
                    }
                });


    }
}
