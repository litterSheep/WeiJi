package com.ly.weiji.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by LY on 2017/9/14 23:52
 */
public class BaseSwipeBackFragment extends SwipeBackFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getSwipeBackLayout().setEdgeOrientation(SwipeBackLayout.EDGE_ALL); // EDGE_LEFT(默认),EDGE_ALL

        getSwipeBackLayout().setParallaxOffset(0.5f); // （类iOS）滑动退出视觉差，默认0.3

        setSwipeBackEnable(true); // 是否允许滑动

        getSwipeBackLayout().addSwipeListener(new SwipeBackLayout.OnSwipeListener() {
            @Override
            public void onDragStateChange(int state) {
                // Drag state
            }

            @Override
            public void onEdgeTouch(int edgeFlag) {
                // 触摸的边缘flag
            }

            @Override
            public void onDragScrolled(float scrollPercent) {
                // 滑动百分比
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
