package com.jiyun.geeknews.model;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.api.ZhihuServer;
import com.jiyun.geeknews.app.GeekApplication;
import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BaseModel;
import com.jiyun.geeknews.base.BaseObserver;
import com.jiyun.geeknews.bean.Zhihu_PopularBean;
import com.jiyun.geeknews.utils.HttpUtil;
import com.jiyun.geeknews.utils.RxUtil;

public class Zhihu_PopularModel extends BaseModel {
    public void popular(final BaseCallBack<Zhihu_PopularBean,String> callBack){
        HttpUtil.getHttpUtil().getServer(ZhihuServer.zhiuUrl,ZhihuServer.class)
                .getPopular().compose(RxUtil.<Zhihu_PopularBean>rxObservableTransformer())
                .subscribe(new BaseObserver<Zhihu_PopularBean>() {
                    @Override
                    public void onNext(Zhihu_PopularBean zhihu_popularBean) {
                        if (zhihu_popularBean!=null){
                            callBack.onSuccess(zhihu_popularBean);
                        }else {
                            callBack.onFail(GeekApplication.getApp().getResources().getString(R.string.net_data_null));
                        }
                    }
                });
    }
}
