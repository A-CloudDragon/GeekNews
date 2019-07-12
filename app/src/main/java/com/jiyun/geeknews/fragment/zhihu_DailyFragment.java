package com.jiyun.geeknews.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.activity.DailyWebActivity;
import com.jiyun.geeknews.adapter.Zhihu_dailyAdapter;
import com.jiyun.geeknews.base.BaseMapFragment;
import com.jiyun.geeknews.bean.Zhihu_DailyBean;
import com.jiyun.geeknews.model.Zhihu_DailyModel;
import com.jiyun.geeknews.presenter.Zhihu_DailyPresenter;
import com.jiyun.geeknews.utils.ToastUtil;
import com.jiyun.geeknews.view.Zhihu_DailyView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class zhihu_DailyFragment extends BaseMapFragment<Zhihu_DailyPresenter, Zhihu_DailyModel, Zhihu_DailyView> implements Zhihu_DailyView, OnRefreshListener {

    @BindView(R.id.zhihu_daily_rlv)
    RecyclerView mZhihuDailyRlv;
    @BindView(R.id.zhihu_daily_srl)
    SmartRefreshLayout mZhihuDailySrl;
    private ArrayList<Zhihu_DailyBean.StoriesBean> storiesBeans;
    private ArrayList<Zhihu_DailyBean.TopStoriesBean> topStoriesBeans;
    private Zhihu_dailyAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu__daily;
    }






    @Override
    protected void initView() {
        super.initView();

        //布局管理器（表格）
        mZhihuDailyRlv.setLayoutManager(new LinearLayoutManager(mContext));

        //
        storiesBeans = new ArrayList<>();
        topStoriesBeans = new ArrayList<>();

        adapter = new Zhihu_dailyAdapter(getContext(), storiesBeans, topStoriesBeans);

        mZhihuDailyRlv.setAdapter(adapter);

        mZhihuDailySrl.setOnRefreshListener(this);

        adapter.setmListener(new Zhihu_dailyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Zhihu_DailyBean.StoriesBean pos) {
                Intent intent = new Intent(mContext, DailyWebActivity.class);
                intent.putExtra("data", pos.getId());
                startActivity(intent);
                ToastUtil.showLong(pos.getTitle());
            }
        });
    }


    @Override
    protected void initData() {
        super.initData();
        if (baserPresenter != null) {
            baserPresenter.Daily();
        }
    }

    @Override
    protected Zhihu_DailyModel initMvpModel() {
        return new Zhihu_DailyModel();
    }

    @Override
    protected Zhihu_DailyView initMvpView() {
        return this;
    }

    @Override
    protected Zhihu_DailyPresenter initMvpPresenter() {
        return new Zhihu_DailyPresenter();
    }


    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
    }

    @Override
    public void onSuccess(Zhihu_DailyBean dailyBean) {
        adapter.setData(dailyBean);
        mZhihuDailySrl.finishRefresh();
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
}
