package com.jiyun.geeknews.presenter;

import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BasePresenter;
import com.jiyun.geeknews.bean.Zhihu_PopularBean;
import com.jiyun.geeknews.model.Zhihu_PopularModel;
import com.jiyun.geeknews.view.Zhihu_PopularView;

public class Zhihu_PopularPresenter extends BasePresenter<Zhihu_PopularModel,Zhihu_PopularView> implements BaseCallBack<Zhihu_PopularBean, String> {
    public void popular(){
        if (baseModel!=null){
            baseModel.popular(this);
        }
    }

    @Override
    public void onSuccess(Zhihu_PopularBean zhihu_popularBean) {
        baseView.onSuccess(zhihu_popularBean);
    }

    @Override
    public void onFail(String s) {
        baseView.onFail(s);
    }
}
