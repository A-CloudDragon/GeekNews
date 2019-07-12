package com.jiyun.geeknews.fragment;


import android.annotation.SuppressLint;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.adapter.GanklistAdapter;
import com.jiyun.geeknews.base.BaseMapFragment;
import com.jiyun.geeknews.bean.GankBean;
import com.jiyun.geeknews.model.Gank_listModel;
import com.jiyun.geeknews.presenter.Gank_listPresenter;
import com.jiyun.geeknews.utils.ToastUtil;
import com.jiyun.geeknews.view.Gannk_listView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Gank_ListFragment extends BaseMapFragment<Gank_listPresenter, Gank_listModel, Gannk_listView> implements Gannk_listView {


    @BindView(R.id.gank_img)
    ImageView mGankImg;
    @BindView(R.id.gank_toolbar)
    Toolbar mGankToolbar;
    @BindView(R.id.gank_appBar)
    AppBarLayout mGankAppBar;
    @BindView(R.id.gank_rlv)
    RecyclerView mGankRlv;
    @BindView(R.id.gank_ctl)
    CollapsingToolbarLayout mGankCtl;
    private String tech;
    private int unm = 10;
    private int page = 1;
    private ArrayList<GankBean.ResultsBean> list;
    private GanklistAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_list;
    }


    @Override
    protected void initView() {
        super.initView();
        mGankRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new GanklistAdapter(getContext(), list);
        mGankRlv.setAdapter(adapter);


        mGankToolbar.setTitle(tech);
    }


    @SuppressLint("ValidFragment")
    public Gank_ListFragment(String tech) {
        this.tech = tech;
    }




    @Override
    protected void initData() {
        super.initData();
        if (baserPresenter!=null){
            baserPresenter.gank_list(tech,unm,page);
        }
    }





    @Override
    protected Gank_listModel initMvpModel() {
        return new Gank_listModel();
    }

    @Override
    protected Gannk_listView initMvpView() {
        return this;
    }

    @Override
    protected Gank_listPresenter initMvpPresenter() {
        return new Gank_listPresenter();
    }

    @Override
    public void onSuccess(final GankBean gankBean) {

        list.clear();

        list.addAll(gankBean.getResults());

        adapter.setList(gankBean.getResults());

        adapter.notifyDataSetChanged();



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
