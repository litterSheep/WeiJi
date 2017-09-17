package com.ly.weiji.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ly.weiji.R;

/**
 * Created by LY on 2017/9/14 23:58
 */

public class WriteAccountFragment extends BaseSwipeBackFragment {

    public static WriteAccountFragment newInstance() {
        WriteAccountFragment fragment = new WriteAccountFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_write_account, container, false);
        initView(view);
        return attachToSwipeBack(view);
    }

    private void initView(View view) {

    }

}
