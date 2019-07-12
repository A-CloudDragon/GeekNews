package com.jiyun.geeknews.presenter;

import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BasePresenter;
import com.jiyun.geeknews.bean.WeChatBean;
import com.jiyun.geeknews.model.WechatModel;
import com.jiyun.geeknews.view.WechatView;

public class WechatPresenter extends BasePresenter<WechatModel, WechatView> implements BaseCallBack<WeChatBean, String> {
    public void wechat(String key,int num,int pagr){
        if (baseModel!=null){
            baseModel.Wechat(this,key,num,pagr );
        }

    }

    @Override
    public void onSuccess(WeChatBean weChatBean) {
        baseView.onSuccess(weChatBean);
    }

    @Override
    public void onFail(String s) {
        baseView.onFail(s);
    }
}
