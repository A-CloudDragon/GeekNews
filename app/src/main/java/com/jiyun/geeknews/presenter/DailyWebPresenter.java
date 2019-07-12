package com.jiyun.geeknews.presenter;

import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BasePresenter;
import com.jiyun.geeknews.bean.DailyWebBean;
import com.jiyun.geeknews.model.DailyWebModel;
import com.jiyun.geeknews.view.DailyWebView;

public class DailyWebPresenter extends BasePresenter<DailyWebModel, DailyWebView> implements BaseCallBack<DailyWebBean, String> {
    public void DailyWeb(int newId){
        if (baseModel!=null){
            baseModel.DailyWeb(this,newId);
        }

    }

    @Override
    public void onSuccess(DailyWebBean dailyBean) {
        baseView.onSuccess(dailyBean);
    }

    @Override
    public void onFail(String s) {
        baseView.onFail(s);
    }
}
