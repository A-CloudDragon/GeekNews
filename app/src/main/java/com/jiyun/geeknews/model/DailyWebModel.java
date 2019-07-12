package com.jiyun.geeknews.model;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.api.ZhihuServer;
import com.jiyun.geeknews.app.GeekApplication;
import com.jiyun.geeknews.base.BaseModel;
import com.jiyun.geeknews.base.BaseObserver;
import com.jiyun.geeknews.bean.DailyWebBean;
import com.jiyun.geeknews.presenter.DailyWebPresenter;
import com.jiyun.geeknews.utils.HttpUtil;
import com.jiyun.geeknews.utils.RxUtil;

public class DailyWebModel extends BaseModel {
    public void DailyWeb(final DailyWebPresenter callBack, int newId){
        HttpUtil.getHttpUtil().getServer(ZhihuServer.zhiuUrl,ZhihuServer.class)
                .getDailyWeb(newId).compose(RxUtil.<DailyWebBean>rxObservableTransformer())
                .subscribe(new BaseObserver<DailyWebBean>() {
                    @Override
                    public void onNext(DailyWebBean dailyWebBean) {
                    if (dailyWebBean!=null){
                        callBack.onSuccess(dailyWebBean);
                    }    else{
                        callBack.onFail(GeekApplication.getApp().getResources().getString(R.string.net_data_null));
                    }
                    }
                });
    }



}
