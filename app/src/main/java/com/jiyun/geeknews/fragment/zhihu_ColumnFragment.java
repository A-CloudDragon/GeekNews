package com.jiyun.geeknews.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.adapter.Zhihu_columnAdapter;
import com.jiyun.geeknews.base.BaseMapFragment;
import com.jiyun.geeknews.bean.Zhihu_ColumnBean;
import com.jiyun.geeknews.model.Zhihu_ColumnModer;
import com.jiyun.geeknews.presenter.Zhihu_ColumnPresenter;
import com.jiyun.geeknews.utils.ToastUtil;
import com.jiyun.geeknews.view.Zhihu_ColumnView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class zhihu_ColumnFragment extends BaseMapFragment<Zhihu_ColumnPresenter, Zhihu_ColumnModer, Zhihu_ColumnView> implements Zhihu_ColumnView, OnRefreshListener {
    @BindView(R.id.zhihu_column_rlv)
    RecyclerView mZhihuColumnRlv;
    @BindView(R.id.zhihu_column_srl)
    SmartRefreshLayout mZhihuColumnSrl;


    private ArrayList<Zhihu_ColumnBean.DataBean> dataBeans;
    private Zhihu_columnAdapter adapter;

    @Override
    protected Zhihu_ColumnModer initMvpModel() {
        return new Zhihu_ColumnModer();
    }

    @Override
    protected Zhihu_ColumnView initMvpView() {
        return this;
    }

    @Override
    protected Zhihu_ColumnPresenter initMvpPresenter() {
        return new Zhihu_ColumnPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu__column;
    }


    @Override
    protected void initView() {
        super.initView();

        mZhihuColumnRlv.setLayoutManager(new GridLayoutManager(mContext, 2));

        dataBeans = new ArrayList<>();

        adapter = new Zhihu_columnAdapter(mContext, dataBeans);

        mZhihuColumnRlv.setAdapter(adapter);

        mZhihuColumnSrl.setOnRefreshListener(this);
    }


    @Override
    protected void initData() {
        super.initData();
        if (baserPresenter != null) {
            baserPresenter.column();
        }
    }


    @Override
    public void onSuccess(Zhihu_ColumnBean zhihu_columnBean) {
        adapter.getData(zhihu_columnBean);
        Log.e("TAG","专题：:"+zhihu_columnBean);
        mZhihuColumnSrl.finishRefresh();
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

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
    }


}
