package com.jiyun.geeknews.view;

import com.jiyun.geeknews.base.BaseView;
import com.jiyun.geeknews.bean.WeChatBean;

public interface WechatView extends BaseView {
        void onSuccess(WeChatBean weChatBean);
            void onFail(String error);
}
