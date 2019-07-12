package com.jiyun.geeknews.view;

import com.jiyun.geeknews.base.BaseView;
import com.jiyun.geeknews.bean.Zhihu_PopularBean;

public interface Zhihu_PopularView extends BaseView {
        void onSuccess(Zhihu_PopularBean recentBeans);
            void onFail(String error);
}
