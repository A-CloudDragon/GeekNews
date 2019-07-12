package com.jiyun.geeknews.model;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.api.ZhihuServer;
import com.jiyun.geeknews.app.GeekApplication;
import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BaseModel;
import com.jiyun.geeknews.base.BaseObserver;
import com.jiyun.geeknews.bean.Zhihu_ColumnBean;
import com.jiyun.geeknews.utils.HttpUtil;
import com.jiyun.geeknews.utils.RxUtil;

public class Zhihu_ColumnModer extends BaseModel {
    public void column(final BaseCallBack<Zhihu_ColumnBean,String> callBack){
        HttpUtil.getHttpUtil().getServer(ZhihuServer.zhiuUrl,ZhihuServer.class)
                .getColumn().compose(RxUtil.<Zhihu_ColumnBean>rxObservableTransformer())
                .subscribe(new BaseObserver<Zhihu_ColumnBean>() {
                    @Override
                    public void onNext(Zhihu_ColumnBean zhihu_columnBean) {
                        if (zhihu_columnBean!=null){
                            callBack.onSuccess(zhihu_columnBean);
                        }else {
                            callBack.onFail(GeekApplication.getApp().getResources().getString(R.string.net_data_null));
                        }

                    }
                });






    }
}
