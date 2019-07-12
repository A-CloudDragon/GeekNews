package com.jiyun.geeknews.presenter;

import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BasePresenter;
import com.jiyun.geeknews.bean.GankBean;
import com.jiyun.geeknews.model.Gank_listModel;
import com.jiyun.geeknews.view.Gannk_listView;

public class Gank_listPresenter extends BasePresenter<Gank_listModel, Gannk_listView> implements BaseCallBack<GankBean, String> {

    public void gank_list(String tech,int num,int pager){
        if (baseModel!=null){
            baseModel.gank_list(this,tech,num,pager);
        }
    }

    @Override
    public void onSuccess(GankBean gankBean) {
        baseView.onSuccess(gankBean);
    }

    @Override
    public void onFail(String s) {
        baseView.onFail(s);
    }
}
