package com.jiyun.geeknews.view;

import com.jiyun.geeknews.base.BaseView;
import com.jiyun.geeknews.bean.Zhihu_ColumnBean;

public interface Zhihu_ColumnView extends BaseView {
        void onSuccess(Zhihu_ColumnBean zhihu_columnBean);
            void onFail(String error);
}
