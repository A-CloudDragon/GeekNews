package com.jiyun.geeknews.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.adapter.GankPagerAdapter;
import com.jiyun.geeknews.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankFragment extends BaseFragment {


    @BindView(R.id.gank_tab)
    TabLayout mGankTab;
    @BindView(R.id.gank_vp)
    ViewPager mGankVp;
    private View view;
    private String[] arr = {"Android","iOS","前端"};
    private ArrayList<Fragment> list;
    private ArrayList<String> titles;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }


    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        titles = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            titles.add(arr[i]);
            list.add(new Gank_ListFragment(arr[i]));
        }



        list.add(new Gank_WelfareFtagment());
        titles.add("福利");




        GankPagerAdapter gankPagerAdapter = new GankPagerAdapter(getChildFragmentManager(),list, titles);

        mGankVp.setAdapter(gankPagerAdapter);

        mGankTab.setupWithViewPager(mGankVp);
    }
}
