package com.jiyun.geeknews.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.geeknews.R;
import com.jiyun.geeknews.base.BaseMvpActivity;
import com.jiyun.geeknews.bean.DailyWebBean;
import com.jiyun.geeknews.bean.Zhihu_DailyBean;
import com.jiyun.geeknews.model.DailyWebModel;
import com.jiyun.geeknews.presenter.DailyWebPresenter;
import com.jiyun.geeknews.utils.HtmlUtil;
import com.jiyun.geeknews.utils.ToastUtil;
import com.jiyun.geeknews.view.DailyWebView;

import java.util.List;

import butterknife.BindView;

public class DailyWebActivity extends BaseMvpActivity<DailyWebPresenter, DailyWebModel, DailyWebView> implements View.OnClickListener, DailyWebView {


    @BindView(R.id.dailyweb_img)
    ImageView mDailywebImg;
    @BindView(R.id.dailyweb_toolbar)
    Toolbar mDailywebToolbar;
    @BindView(R.id.dailyweb_appbar)
    AppBarLayout mDailywebAppbar;
    @BindView(R.id.dailyweb_web)
    WebView mDailywebWeb;
    @BindView(R.id.dailyweb_nsv)
    NestedScrollView mdailywebNsv;
    @BindView(R.id.dailyweb_like)
    FloatingActionButton mdailywebLike;
    @BindView(R.id.dailyweb_ctl)
    CollapsingToolbarLayout mdailywebCtl;
    private Zhihu_DailyBean.StoriesBean storiesBean;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_daily_web;
    }

    @Override
    protected void initData() {
        super.initData();
//        storiesBean = (Zhihu_DailyBean.StoriesBean)getIntent().getSerializableExtra("data");
//        int id = storiesBean.getId();

        String data = getIntent().getStringExtra("data");

        int i = Integer.parseInt(data);
        if (presenter != null){
            presenter.DailyWeb(i);
        }


    }

    @Override
    protected void initView() {
        super.initView();
        initData();
        mDailywebToolbar.setTitle("");
        setSupportActionBar(mDailywebToolbar);
        //snackbar点击事件
        mdailywebLike.setOnClickListener(this);
    }








    //snackbar点击事件
    @Override
    public void onClick(View v) {

    }

    @Override
    protected DailyWebView initMvpView() {
        return this;
    }

    @Override
    protected DailyWebModel initMvpModel() {
        return new DailyWebModel();
    }

    @Override
    protected DailyWebPresenter initMvpPresenter() {
        return new DailyWebPresenter();
    }


    @Override
    public void onSuccess(DailyWebBean bean) {
        Glide.with(this).load(bean.getImages().get(0)).into(mDailywebImg);
        mDailywebWeb.setWebViewClient(new WebViewClient());
        String htmlData = HtmlUtil.createHtmlData(bean.getBody(), bean.getCss(), (List<String>) bean.getJs());
        mDailywebWeb.loadUrl(htmlData);
        mdailywebCtl.setTitle(bean.getTitle());
        mdailywebCtl.setExpandedTitleColor(getResources().getColor(R.color.colorPrimary));
        mdailywebCtl.setCollapsedTitleTextColor(getResources().getColor(R.color.colorWhite));

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
