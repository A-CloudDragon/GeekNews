package com.jiyun.geeknews.base;

import java.util.ArrayList;

public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {
    protected V baseView;
    protected M baseModel;

    ArrayList<BaseModel> list = new ArrayList<>();

    public void setBaseView(V baseView) {
        this.baseView = baseView;
    }

    public void setBaseModel(M baseModel) {
        this.baseModel = baseModel;
        list.add(baseModel);
    }


    public void destroy() {

        //当activity销毁的时候，观察者与被观察者的断开
        if (list != null && list.size() > 0) {
            for (BaseModel baseModel : list) {
                baseModel.destroy();
            }
        }

        //当activity销毁的时候,将view置空，防止内存泄漏
        if (baseView != null) {
            baseView = null;
        }

        //当activity销毁的时候,将model置空，防止内存泄漏
        if (baseModel != null) {
            baseModel = null;
        }
    }
}
