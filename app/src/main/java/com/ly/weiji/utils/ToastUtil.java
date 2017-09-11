package com.ly.weiji.utils;

import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.ly.weiji.App;

/**
 * Created by ly on 2017/2/10 15:34.
 */
public class ToastUtil {
    private static Toast toast;

    public static void showToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (toast == null) {
                toast = Toast.makeText(App.getInstance().getApplicationContext(), text, Toast.LENGTH_SHORT);
            } else {
                toast.setText(text);
            }
            toast.show();
        }
    }

    public static void showSnakBar(View view, String text) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
    }


}
