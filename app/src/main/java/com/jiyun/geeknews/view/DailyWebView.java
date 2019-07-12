package com.jiyun.geeknews.view;

import com.jiyun.geeknews.base.BaseView;
import com.jiyun.geeknews.bean.DailyWebBean;

public interface DailyWebView extends BaseView {
        void onSuccess(DailyWebBean bean);
            void onFail(String error);
}
