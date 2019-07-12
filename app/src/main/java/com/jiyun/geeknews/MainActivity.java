package com.jiyun.geeknews;

import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.jiyun.geeknews.base.BaseActivity;
import com.jiyun.geeknews.bean.WechatSearchbean;
import com.jiyun.geeknews.fragment.AboutFragment;
import com.jiyun.geeknews.fragment.CollectFragment;
import com.jiyun.geeknews.fragment.GankFragment;
import com.jiyun.geeknews.fragment.GoldFragment;
import com.jiyun.geeknews.fragment.SettingsFragment;
import com.jiyun.geeknews.fragment.V2exFragment;
import com.jiyun.geeknews.fragment.WechatFragment;
import com.jiyun.geeknews.fragment.ZhihuFragment;
import com.jiyun.geeknews.utils.FragmentType;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tb_main)
    Toolbar mTbMain;
    @BindView(R.id.fl_main)
    FrameLayout mFlMain;
    @BindView(R.id.NavigationView)
    NavigationView mNavigationView;
    @BindView(R.id.DrawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.msv_main)
    MaterialSearchView mMsvMain;
    private ArrayList<Integer> mTitles;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;
    private int lastFragmentType;
    private MenuItem item;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//    }

    @Override
    protected void initView() {
        super.initView();

        //初始化标题数据
        initTitle();

        //toolbar设置
        mTbMain.setTitle(mTitles.get(0));//设置toolbar标题
        mTbMain.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(mTbMain);//绑定


        //旋转开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mTbMain, R.string.about, R.string.about);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorWhite));//设置颜色
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        //侧滑图标显示
        mNavigationView.setItemIconTintList(null);


        //获取fragment管理器
        fragmentManager = getSupportFragmentManager();

        //初始化fragment
        initFragment();

        //显示知乎页面
        addZhiFragment();

    }

    private void addZhiFragment() {
        //显示fragment知乎日报页面
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_main, fragments.get(0));
        fragmentTransaction.commit();
    }


    //初始化Fragment
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ZhihuFragment());
        fragments.add(new WechatFragment());
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new V2exFragment());
        fragments.add(new CollectFragment());
        fragments.add(new SettingsFragment());
        fragments.add(new AboutFragment());
    }

    //初始化标题
    private void initTitle() {
        mTitles = new ArrayList<>();
        mTitles.add(R.string.zhihu);
        mTitles.add(R.string.wechat);
        mTitles.add(R.string.gank);
        mTitles.add(R.string.gald);
        mTitles.add(R.string.vtex);
        mTitles.add(R.string.cllect);
        mTitles.add(R.string.settings);
        mTitles.add(R.string.about);
    }


    private void switchFrament(int type) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragments.get(type);

        //判断fragment是否添加
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.fl_main, fragment);
        }


        //隐藏上一个fragment
        Fragment lastFragment = fragments.get(this.lastFragmentType);
        fragmentTransaction.hide(lastFragment);


        //显示新的fragment
        fragmentTransaction.show(fragment);
        lastFragmentType = type;
        fragmentTransaction.commit();

        //判断让搜索之显示到微信精选和干货集中营里
        if (lastFragmentType == FragmentType.TYPE_WECHAT || lastFragmentType == FragmentType.TYPE_GANK){
            item.setVisible(true);//显示
        }else{
            item.setVisible(false);//隐藏
        }


        //改变标题
        mTbMain.setTitle(mTitles.get(type));
    }


    @Override
    protected void initListener() {
        super.initListener();


        //侧滑菜单文字颜色
//        mNavigationView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
        //侧滑菜单图标颜色
        mNavigationView.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));


        //侧滑监听器
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //设置选择监听器
                menuItem.setChecked(true);

                //侧滑监听
                switch (menuItem.getItemId()) {

                    //知乎日报
                    case R.id.zhihu:
                        switchFrament(FragmentType.TYPE_ZHIHU);
                        break;


                    //微信精选
                    case R.id.wechat:
                        switchFrament(FragmentType.TYPE_WECHAT);
                        break;


                    //干货集中营
                    case R.id.gank:
                        switchFrament(FragmentType.TYPE_GANK);
                        break;


                    //稀土掘金
                    case R.id.gold:
                        switchFrament(FragmentType.TYPE_GOLD);
                        break;


                    //
                    case R.id.vtex:
                        switchFrament(FragmentType.TYPE_V2EX);
                        break;


                    //收藏
                    case R.id.collect:
                        switchFrament(FragmentType.TYPE_COLLECT);
                        break;


                    //设置
                    case R.id.setting:
                        switchFrament(FragmentType.TYPE_SETTINGS);
                        break;


                    //关于
                    case R.id.about:
                        switchFrament(FragmentType.TYPE_ABOUT);
                        break;
                }

                //点击后关
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                return false;
            }


        });

        mMsvMain.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
               if (lastFragmentType==FragmentType.TYPE_WECHAT){
                   //发送
                   EventBus.getDefault().post(new WechatSearchbean(query,FragmentType.TYPE_WECHAT));
               }else if (lastFragmentType==FragmentType.TYPE_GANK){

               }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("TAG","搜索框输入内容：:"+newText);
                return false;
            }
        });



        mMsvMain.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {//搜索框显示
                Log.e("TAG","搜索框显示");
            }

            @Override
            public void onSearchViewClosed() {//搜索框关闭
                Log.e("TAG","搜索框关闭");
            }
        });

    }












    //这本是一个选项菜单、、显示搜索的放大镜
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_msv, menu);
        item = menu.findItem(R.id.action_search);
        item.setVisible(false);//隐藏
        mMsvMain.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }
}
