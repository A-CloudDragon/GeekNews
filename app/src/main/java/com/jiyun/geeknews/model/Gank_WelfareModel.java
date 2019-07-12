package com.jiyun.geeknews.model;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.api.GankService;
import com.jiyun.geeknews.app.GeekApplication;
import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BaseModel;
import com.jiyun.geeknews.base.BaseObserver;
import com.jiyun.geeknews.bean.WelfareBean;
import com.jiyun.geeknews.utils.HttpUtil;
import com.jiyun.geeknews.utils.RxUtil;

public class Gank_WelfareModel extends BaseModel {
    public void gank_Welfare(final BaseCallBack<WelfareBean,String> callBack, int pagr){
        HttpUtil.getHttpUtil().getServer(GankService.weflBaseUrl,GankService.class)
                .welfareData(pagr).compose(RxUtil.<WelfareBean>rxObservableTransformer())
                .subscribe(new BaseObserver<WelfareBean>() {
                    @Override
                    public void onNext(WelfareBean welfareBean) {
                    if (welfareBean!=null){
                     callBack.onSuccess(welfareBean);
                    }else{
                        callBack.onFail(GeekApplication.getApp().getResources().getString(R.string.net_data_null));
                    }
                    }
                });
    }
}
