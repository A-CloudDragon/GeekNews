package com.jiyun.geeknews.view;

import com.jiyun.geeknews.base.BaseView;
import com.jiyun.geeknews.bean.WelfareBean;

public interface Gank_WelfareView extends BaseView {
        void onSuccess(WelfareBean welfareBean);
            void onFail(String error);
}
