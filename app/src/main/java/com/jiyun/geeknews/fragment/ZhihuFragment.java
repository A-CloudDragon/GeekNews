package com.jiyun.geeknews.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.geeknews.R;
import com.jiyun.geeknews.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuFragment extends BaseFragment {



    @BindView(R.id.zhihu_tab)
    TabLayout mZhihuTab;
    @BindView(R.id.zhihu_vp)
    ViewPager mZhihuVp;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu;
    }


    @Override
    protected void initView() {
        super.initView();
        fragments = new ArrayList<>();

        fragments.add(new zhihu_DailyFragment());
        fragments.add(new zhihu_ThemeFragment());
        fragments.add(new zhihu_ColumnFragment());
        fragments.add(new zhihu_PopularFragment());



        titles = new ArrayList<>();

        titles.add(mContext.getResources().getString(R.string.zhihu_Daily));
        titles.add(mContext.getResources().getString(R.string.zhihu_Theme));
        titles.add(mContext.getResources().getString(R.string.zhihu_Column));
        titles.add(mContext.getResources().getString(R.string.zhihu_Popular));



        mZhihuVp.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mZhihuTab.setupWithViewPager(mZhihuVp);

        mZhihuTab.getTabAt(0).setText(titles.get(0));
        mZhihuTab.getTabAt(1).setText(titles.get(1));
        mZhihuTab.getTabAt(2).setText(titles.get(2));
        mZhihuTab.getTabAt(3).setText(titles.get(3));
    }
}


