package com.jiyun.geeknews.model;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.api.WeChatService;
import com.jiyun.geeknews.app.GeekApplication;
import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BaseModel;
import com.jiyun.geeknews.base.BaseObserver;
import com.jiyun.geeknews.bean.WeChatBean;
import com.jiyun.geeknews.utils.HttpUtil;
import com.jiyun.geeknews.utils.RxUtil;

public class WechatModel extends BaseModel {
    public void Wechat(final BaseCallBack<WeChatBean,String> callBack, String key, int num, int pagr){
        HttpUtil.getHttpUtil().getServer(WeChatService.url,WeChatService.class)
                .getWechatData(key,num,pagr).compose(RxUtil.<WeChatBean>rxObservableTransformer())
                .subscribe(new BaseObserver<WeChatBean>() {
                    @Override
                    public void onNext(WeChatBean weChatBean) {
                        if (weChatBean.getNewslist()!=null){
                            callBack.onSuccess(weChatBean);
                        }else{
                            callBack.onFail(GeekApplication.getApp().getResources().getString(R.string.net_data_null));
                        }
                    }
                });
    }

}
