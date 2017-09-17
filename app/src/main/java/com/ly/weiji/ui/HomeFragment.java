package com.ly.weiji.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionMenu;
import com.ly.weiji.Constants;
import com.ly.weiji.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by LY on 2017/9/15 0:24
 */

public class HomeFragment extends SupportFragment implements NavigationView.OnNavigationItemSelectedListener {

    private FloatingActionMenu floatingActionMenu;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

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
        initSlideMenu(view);
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

    private void initSlideMenu(View view) {
        setHasOptionsMenu(true);
        drawerLayout = view.findViewById(R.id.drawer_layout);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        //toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        //toolbar.inflateMenu(R.menu.main);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
                    floatingActionMenu.close(true);
                }
            });


            floatingActionMenu.addMenuButton(programFab);
        }
        floatingActionMenu.setClosedOnTouchOutside(true);
        floatingActionMenu.setIconAnimated(true);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onBackPressedSupport() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else {
            if (floatingActionMenu.isOpened()) {
                floatingActionMenu.close(true);
                return true;
            } else {
                return super.onBackPressedSupport();
            }
        }
    }

}
