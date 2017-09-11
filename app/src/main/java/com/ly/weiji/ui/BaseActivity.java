package com.ly.weiji.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.ly.weiji.R;
import com.ly.weiji.view.CustomTitleBar;
import com.umeng.analytics.MobclickAgent;


/**
 * Created by ly on 2017/3/3 9:36.
 */

public class BaseActivity extends AppCompatActivity {

    protected CustomTitleBar topTitleBar;
    private String activityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        activityName = getClass().getSimpleName();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initView();

    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initView();

    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        initView();
    }

    //初始化标题控件
    private void initView() {

        topTitleBar = (CustomTitleBar) findViewById(R.id.top_title);

        if (topTitleBar != null) {
            topTitleBar.setOnLeftClickListener(new CustomTitleBar.OnLeftClickListener() {
                @Override
                public void onLeftClick() {
                    finish();
                }
            });
        }

    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public void startMyActivity(Class<?> cla) {
        this.startActivity(new Intent(this, cla));
    }

    /**
     * 隐藏软键盘
     */
    public void hideSoftKeyboard() {
        //如果打开了软键盘，则隐藏
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //统计页面(仅有Activity的应用中SDK自动调用，不需要单独写。"SplashScreen"为页面名称，可自定义)
        MobclickAgent.onPageStart(activityName);
        //统计时长
        MobclickAgent.onResume(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //（仅有Activity的应用中SDK自动调用，不需要单独写）保证 onPageEnd 在onPause 之前调用,因为 onPause 中会保存信息。"SplashScreen"为页面名称，可自定义
        MobclickAgent.onPageEnd(activityName);
        //统计时长
        MobclickAgent.onPause(this);
    }

}
