package com.ly.weiji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.umeng.analytics.MobclickAgent;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by LY on 2017/9/14 22:05
 */
public class BaseActivity extends SupportActivity {
    protected String activityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityName = getClass().getSimpleName();
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

    public void startMyActivity(Class<?> cla) {
        this.startActivity(new Intent(this, cla));
    }

}
