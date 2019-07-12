package com.jiyun.geeknews.view;

import com.jiyun.geeknews.base.BaseView;
import com.jiyun.geeknews.bean.Zhihu_DailyBean;

public interface Zhihu_DailyView extends BaseView {
        void onSuccess(Zhihu_DailyBean dailyBean);
            void onFail(String error);
}
