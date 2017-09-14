package com.ly.weiji.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionMenu;
import com.ly.weiji.Constants;
import com.ly.weiji.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by LY on 2017/9/15 0:24
 */

public class HomeFragment extends SupportFragment {

    private FloatingActionMenu floatingActionMenu;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.frg_home, container, false);
        initView(view);
        initFab(view);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

//        if (findChildFragment(FirstHomeFragment.class) == null) {
//            loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
//        }
    }

    private void initView(View view) {

    }

    private void initFab(View view) {

        floatingActionMenu = view.findViewById(R.id.fab_menu_main);
        ContextThemeWrapper context = new ContextThemeWrapper(getContext(), R.style.FABMenuButtonsStyle);
        //根据配置类型生成对应的FloatingActionButton
        for (String category : Constants.MAIN_CATEGORY) {
            final com.github.clans.fab.FloatingActionButton programFab = new com.github.clans.fab.FloatingActionButton(context);
            programFab.setLabelText(category);
            programFab.setImageResource(R.drawable.ic_edit);
            programFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //ToastUtil.showSnakBar(v,programFab.getLabelText());

                    if (Constants.MAIN_CATEGORY[0].equals(programFab.getLabelText())) {//记账

                        start(WriteAccountFragment.newInstance());

                    } else {//写日记

                    }
                }
            });


            floatingActionMenu.addMenuButton(programFab);
        }
        floatingActionMenu.setClosedOnTouchOutside(true);
        floatingActionMenu.setIconAnimated(true);
    }

    @Override
    public boolean onBackPressedSupport() {
        if (floatingActionMenu.isOpened()) {
            floatingActionMenu.close(true);
            return true;
        } else {
            return super.onBackPressedSupport();
        }
    }
}
