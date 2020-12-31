package com.ly.weiji.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ly.weiji.R;
import com.orhanobut.logger.Logger;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by LY on 2017/9/14 23:58
 */

public class WriteAccountFragment extends BaseSwipeBackFragment implements View.OnClickListener {

    private ImageView iv_close, iv_type;
    private TextView tv_date, tv_save;
    private EditText et_num, et_remark;
    private ViewPager viewPager;
    private MagicIndicator magicIndicatorType, magicIndicatorBottom;

    private static final String[] CHANNELS = new String[]{"支出", "收入"};
    private List<String> mDataList = Arrays.asList(CHANNELS);

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
        iv_close = view.findViewById(R.id.iv_write_close);
        iv_type = view.findViewById(R.id.iv_type_icon);
        et_num = view.findViewById(R.id.et_write_num);
        tv_date = view.findViewById(R.id.tv_write_date);
        tv_save = view.findViewById(R.id.tv_write_save);
        et_remark = view.findViewById(R.id.et_remark);
        viewPager = view.findViewById(R.id.vp_write_type);
        magicIndicatorType = view.findViewById(R.id.indicator_write_type);
        magicIndicatorBottom = view.findViewById(R.id.indicator_write_bottom);

        et_num.setSelection(et_num.length());
        iv_close.setOnClickListener(this);
        iv_type.setOnClickListener(this);
        tv_date.setOnClickListener(this);
        tv_save.setOnClickListener(this);

        viewPager.setAdapter(new ExamplePagerAdapter(mDataList));

        magicIndicatorType.setBackgroundResource(R.drawable.type_indicator_stroke);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setText(mDataList.get(index));
                clipPagerTitleView.setTextColor(Color.WHITE);
                clipPagerTitleView.setTextSize(UIUtil.dip2px(context, 14));
                clipPagerTitleView.setClipColor(getResources().getColor(R.color.mainColor));
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index);
                    }
                });
                return clipPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                float navigatorHeight = context.getResources().getDimension(R.dimen.indicator_h);
                float borderWidth = UIUtil.dip2px(context, 1);
                float lineHeight = navigatorHeight - 2 * borderWidth;
                indicator.setLineHeight(lineHeight);
                indicator.setRoundRadius(getResources().getDimension(R.dimen.indicator_corners));
                indicator.setYOffset(borderWidth);
                indicator.setColors(Color.parseColor("#ffffff"));
                return indicator;
            }
        });
        magicIndicatorType.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicatorType, viewPager);

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_write_close:

                pop();
                break;
            case R.id.tv_write_date:

                break;
            case R.id.tv_write_save:

                break;
            case R.id.iv_type_icon:
                if (viewPager.getVisibility() == View.GONE) {
                    viewPager.setVisibility(View.VISIBLE);
                } else {
                    viewPager.setVisibility(View.GONE);
                }
                break;
        }
    }
}
