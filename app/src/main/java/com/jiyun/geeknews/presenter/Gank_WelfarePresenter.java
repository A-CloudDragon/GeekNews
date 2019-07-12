package com.jiyun.geeknews.presenter;

import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BasePresenter;
import com.jiyun.geeknews.bean.WelfareBean;
import com.jiyun.geeknews.model.Gank_WelfareModel;
import com.jiyun.geeknews.view.Gank_WelfareView;

public class Gank_WelfarePresenter extends BasePresenter<Gank_WelfareModel, Gank_WelfareView> implements BaseCallBack<WelfareBean, String> {
    public void gank_Welfare(int pagr){
        if (baseModel!=null){
            baseModel.gank_Welfare(this,pagr);
        }
    }

    @Override
    public void onSuccess(WelfareBean welfareBean) {
        baseView.onSuccess(welfareBean);
    }

    @Override
    public void onFail(String s) {
        baseView.onFail(s);
    }
}
