package com.ly.weiji.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.ly.weiji.R;
import com.ly.weiji.view.CustomTitleBar;


/**
 * Created by ly on 2017/3/3 9:36.
 */
public class BaseTitleActivity extends BaseActivity {

    protected CustomTitleBar topTitleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
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

}
