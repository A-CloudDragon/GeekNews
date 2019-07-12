package com.jiyun.geeknews.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.adapter.Zhihu_popularAdapter;
import com.jiyun.geeknews.base.BaseMapFragment;
import com.jiyun.geeknews.bean.Zhihu_PopularBean;
import com.jiyun.geeknews.model.Zhihu_PopularModel;
import com.jiyun.geeknews.presenter.Zhihu_PopularPresenter;
import com.jiyun.geeknews.view.Zhihu_PopularView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class zhihu_PopularFragment extends BaseMapFragment<Zhihu_PopularPresenter, Zhihu_PopularModel, Zhihu_PopularView> implements Zhihu_PopularView {


    @BindView(R.id.zhihu__popular_rlv)
    RecyclerView mZhihuPopularRlv;
    @BindView(R.id.zhihu_popular_srl)
    SmartRefreshLayout mZhihuPopularSrl;
    private Zhihu_popularAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu__popular;
    }


    @Override
    protected void initView() {
        super.initView();

        mZhihuPopularRlv.setLayoutManager(new LinearLayoutManager(mContext));

        ArrayList<Zhihu_PopularBean.RecentBean> recentBeans = new ArrayList<>();

        adapter = new Zhihu_popularAdapter(mContext, recentBeans);

        mZhihuPopularRlv.setAdapter(adapter);
    }

    @Override
    protected Zhihu_PopularModel initMvpModel() {
        return new Zhihu_PopularModel();
    }

    @Override
    protected Zhihu_PopularView initMvpView() {
        return this;
    }

    @Override
    protected Zhihu_PopularPresenter initMvpPresenter() {
        return new Zhihu_PopularPresenter();
    }


    @Override
    protected void initData() {
        super.initData();
        if (baserPresenter!=null){
            baserPresenter.popular();
        }
    }

    @Override
    public void onSuccess(Zhihu_PopularBean recentBeans) {
        adapter.getData(recentBeans);
    }

    @Override
    public void onFail(String error) {

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFail(Object o) {

    }
}
