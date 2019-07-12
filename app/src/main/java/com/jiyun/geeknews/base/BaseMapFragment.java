package com.jiyun.geeknews.base;

public abstract class BaseMapFragment<P extends BasePresenter,M extends BaseModel,V extends BaseView> extends BaseFragment{
    protected P baserPresenter;

    @Override
    protected void initMvp() {
        super.initMvp();

        baserPresenter = initMvpPresenter();
       if (baserPresenter!=null){
           baserPresenter.setBaseView(initMvpView());
           baserPresenter.setBaseModel(initMvpModel());
       }
    }

    protected abstract M initMvpModel();

    protected abstract V initMvpView();

    protected abstract P initMvpPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        baserPresenter.destroy();
    }
}
