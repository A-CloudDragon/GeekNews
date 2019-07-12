package com.jiyun.geeknews.presenter;

import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BasePresenter;
import com.jiyun.geeknews.bean.Zhihu_DailyBean;
import com.jiyun.geeknews.model.Zhihu_DailyModel;
import com.jiyun.geeknews.view.Zhihu_DailyView;

public class Zhihu_DailyPresenter extends BasePresenter<Zhihu_DailyModel, Zhihu_DailyView> implements BaseCallBack<Zhihu_DailyBean,String> {

    public void Daily(){
        if (baseModel!=null){
            baseModel.Daily(this);
        }
    }



    @Override
    public void onSuccess(Zhihu_DailyBean dailyBean) {
        baseView.onSuccess(dailyBean);
    }

    @Override
    public void onFail(String s) {
        baseView.onFail(s);
    }
}
