package com.jiyun.geeknews.presenter;

import com.jiyun.geeknews.base.BaseCallBack;
import com.jiyun.geeknews.base.BasePresenter;
import com.jiyun.geeknews.bean.Zhihu_ColumnBean;
import com.jiyun.geeknews.model.Zhihu_ColumnModer;
import com.jiyun.geeknews.view.Zhihu_ColumnView;

public class Zhihu_ColumnPresenter extends BasePresenter<Zhihu_ColumnModer, Zhihu_ColumnView> implements BaseCallBack<Zhihu_ColumnBean, String> {
    public void column(){
        if (baseModel!=null){
            baseModel.column(this);
        }
    }


    @Override
    public void onSuccess(Zhihu_ColumnBean zhihu_columnBean) {
        baseView.onSuccess(zhihu_columnBean);
    }

    @Override
    public void onFail(String s) {
        baseView.onFail(s);
    }
}
