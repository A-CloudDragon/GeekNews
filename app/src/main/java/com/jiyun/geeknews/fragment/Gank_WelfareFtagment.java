package com.jiyun.geeknews.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.adapter.Gank_WelfareAdapter;
import com.jiyun.geeknews.base.BaseMapFragment;
import com.jiyun.geeknews.base.BaseView;
import com.jiyun.geeknews.bean.WelfareBean;
import com.jiyun.geeknews.model.Gank_WelfareModel;
import com.jiyun.geeknews.presenter.Gank_WelfarePresenter;
import com.jiyun.geeknews.utils.ToastUtil;
import com.jiyun.geeknews.view.Gank_WelfareView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Gank_WelfareFtagment extends BaseMapFragment<Gank_WelfarePresenter, Gank_WelfareModel, Gank_WelfareView> implements BaseView, Gank_WelfareView, OnRefreshListener, OnLoadmoreListener {


    @BindView(R.id.gank_welfare_rlv)
    RecyclerView mGankWelfareRlv;
    @BindView(R.id.gank_welfare_srl)
    SmartRefreshLayout mGankWelfareSrl;
    private ArrayList<WelfareBean.ResultsBean> list;
    private Gank_WelfareAdapter gank_welfareAdapter;
    int parg = 1;
    private View view;
    private Unbinder unbinder;


    @Override
    protected void initView() {
        super.initView();

        mGankWelfareRlv.setLayoutManager(new StaggeredGridLayoutManager(2, 1));

        list = new ArrayList<>();

        gank_welfareAdapter = new Gank_WelfareAdapter(getContext(), list);

        mGankWelfareRlv.setAdapter(gank_welfareAdapter);

        mGankWelfareSrl.setOnRefreshListener(this);
        mGankWelfareSrl.setOnLoadmoreListener(this);

    }

    @Override
    protected Gank_WelfareModel initMvpModel() {
        return new Gank_WelfareModel();
    }

    @Override
    protected Gank_WelfareView initMvpView() {
        return this;
    }

    @Override
    protected Gank_WelfarePresenter initMvpPresenter() {
        return new Gank_WelfarePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_welfare_ftagment;
    }


    @Override
    protected void initData() {
        super.initData();
        if (baserPresenter != null) {
            baserPresenter.gank_Welfare(parg);
        }
    }

    @Override
    public void onSuccess(WelfareBean welfareBean) {
        gank_welfareAdapter.getData(welfareBean.getResults());
        mGankWelfareSrl.finishRefresh();
        mGankWelfareSrl.finishLoadmore();
    }

    @Override
    public void onFail(String error) {
        ToastUtil.showLong(error);
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFail(Object o) {

    }


    //刷新
    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        parg=1;
        gank_welfareAdapter.getClear();
        initData();

    }


    //加载更多
    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        parg++;
        initData();
    }
}
