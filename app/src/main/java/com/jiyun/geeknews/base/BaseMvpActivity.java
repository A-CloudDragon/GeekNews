package com.jiyun.geeknews.base;

public abstract class BaseMvpActivity<P extends BasePresenter, M extends BaseModel, V extends BaseView> extends BaseActivity {

    protected P presenter;

    @Override
    protected void initMvp() {
        super.initMvp();
        presenter = initMvpPresenter();
        if (presenter != null) {
            presenter.setBaseModel(initMvpModel());
            presenter.setBaseView(initMvpView());
        }
    }

    protected abstract V initMvpView();

    protected abstract M initMvpModel();

    protected abstract P initMvpPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}
