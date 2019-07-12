package com.jiyun.geeknews.view;

import com.jiyun.geeknews.base.BaseView;
import com.jiyun.geeknews.bean.GankBean;

public interface Gannk_listView extends BaseView {
        void onSuccess(GankBean gankBean);
            void onFail(String error);
}
