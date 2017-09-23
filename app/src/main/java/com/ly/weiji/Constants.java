package com.ly.weiji;

import android.os.Environment;

import java.io.File;

/**
 * Created by ly on 2017/3/2 15:06.
 */

public class Constants {

    public static final String DB_NAME = "recorder.db";

    public static final String[] MAIN_CATEGORY = {"记账", "写日记"};
    public static final int TYPE_IN = 1;//收入
    public static final int TYPE_OUT = 2;//支出

    public static final String BASE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "WeiJi";
    public static final String CRASH_PATH = BASE_PATH + File.separator + "crash";

    public static final String PREFERENCES_FLAG = "isShowDate";
    public static final String PREFERENCES_FLAG_DIALOG = "isShowDialog";
    public static final String PREFERENCES_FLAG_BAR = "isShowBar";

}
