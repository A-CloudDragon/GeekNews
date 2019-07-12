package com.jiyun.geeknews.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.adapter.WechatAdapter;
import com.jiyun.geeknews.base.BaseMapFragment;
import com.jiyun.geeknews.bean.WeChatBean;
import com.jiyun.geeknews.bean.WechatSearchbean;
import com.jiyun.geeknews.model.WechatModel;
import com.jiyun.geeknews.presenter.WechatPresenter;
import com.jiyun.geeknews.utils.ToastUtil;
import com.jiyun.geeknews.view.WechatView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends BaseMapFragment<WechatPresenter, WechatModel, WechatView> implements WechatView {


    @BindView(R.id.wechat_rlv)
    RecyclerView mWechatRlv;
    private ArrayList<WeChatBean.NewslistBean> list;
    private WechatAdapter adapter;
    private String key = "52b7ec3471ac3bec6846577e79f20e4c";
    private int num = 20;
    private int pagr = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }


    @Override
    protected void initView() {
        super.initView();
        EventBus.getDefault().register(this);

        mWechatRlv.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        adapter = new WechatAdapter(getContext(), list);

        mWechatRlv.setAdapter(adapter);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void queryData(WechatSearchbean wechatSearchbean) {
        baserPresenter.wechat(wechatSearchbean.getQuery(),num,pagr);
        Toast.makeText(getContext(),"搜索中，请稍后....",Toast.LENGTH_LONG).show();
    }


    @Override
    protected void initData() {
        super.initData();
        if (baserPresenter!=null){
            baserPresenter.wechat(key,num,pagr);
        }
    }

    @Override
    protected WechatModel initMvpModel() {
        return new WechatModel();
    }

    @Override
    protected WechatView initMvpView() {
        return this;
    }

    @Override
    protected WechatPresenter initMvpPresenter() {
        return new WechatPresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onSuccess(WeChatBean weChatBean) {
        List<WeChatBean.NewslistBean> newslist = weChatBean.getNewslist();
        Log.e("TAG",newslist+":解析结果");
        adapter.getData(newslist);
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
