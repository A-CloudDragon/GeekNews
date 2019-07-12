package com.jiyun.geeknews.model;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.api.GankService;
import com.jiyun.geeknews.app.GeekApplication;
import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BaseModel;
import com.jiyun.geeknews.base.BaseObserver;
import com.jiyun.geeknews.bean.GankBean;
import com.jiyun.geeknews.utils.HttpUtil;
import com.jiyun.geeknews.utils.RxUtil;

public class Gank_listModel extends BaseModel {
    public void gank_list(final BaseCallBack<GankBean,String> callBack, String tech, int num, int pagr){
        HttpUtil.getHttpUtil().getServer(GankService.sBaseUrl,GankService.class)
                .getGankData(tech,num,pagr).compose(RxUtil.<GankBean>rxObservableTransformer())
                .subscribe(new BaseObserver<GankBean>() {
                    @Override
                    public void onNext(GankBean gankBean) {
                        if (gankBean!=null){
                            callBack.onSuccess(gankBean);

                        }else{
                            callBack.onFail(GeekApplication.getApp().getResources().getString(R.string.net_data_null));
                        }
                    }
                });
    }

}
