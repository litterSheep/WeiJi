package com.ly.weiji;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.ly.weiji.db.MigrationHelper;
import com.ly.weiji.db.greendao.DaoMaster;
import com.ly.weiji.db.greendao.DaoSession;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.umeng.analytics.MobclickAgent;

/**
 * application 代理类
 * Created by ly on 2017/3/2 14:41.
 */

public class App extends Application {

    private static App instance;
    private MigrationHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initLogger();
        initUMeng();
        setDatabase();
    }

    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("WJ")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    private void initUMeng() {
        MobclickAgent.startWithConfigure(new MobclickAgent
                .UMAnalyticsConfig(getApplicationContext(), "59b6492b99f0c7527f0014bc", BuildConfig.FLAVOR));
        //对日志信息进行加密
        MobclickAgent.enableEncrypt(true);
        MobclickAgent.setDebugMode(BuildConfig.DEBUG);
        MobclickAgent.setCatchUncaughtExceptions(true);

        MobclickAgent.onEvent(getApplicationContext(), "test");
        Logger.i(">>>>>>");
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new MigrationHelper(getApplicationContext(), Constants.DB_NAME, null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        if (mDaoSession == null)
            setDatabase();
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

}
