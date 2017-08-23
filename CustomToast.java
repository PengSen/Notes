package com.ob.demo.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.ob.demo.R;
import com.ob.demo.util.ScreenUtil;

/**
 * Created by ob on 2017/8/20.
 *
 */

public class CustomToast {
    private static Toast toast;
    private CustomToast(Context context, String text, int duration){
        TextView textView = new TextView(context);
        textView.setBackgroundResource(R.drawable.toast_bg);
        textView.setPadding(ScreenUtil.dip2px(context, 20),ScreenUtil.dip2px(context, 10),ScreenUtil.dip2px(context, 20),ScreenUtil.dip2px(context, 10));
        textView.setText(text);
        textView.setTextColor(ContextCompat.getColor(context, android.R.color.black));
        if(toast == null){
            toast = new Toast(context);
            toast.setDuration(duration);
        }
        toast.setView(textView);
        toast.show();
    }

    public static CustomToast makeText(Context context, String text, int duration) {
        return new CustomToast(context, text, duration);
    }
    public static CustomToast makeText(Context context, int resId, int duration) {
        return new CustomToast(context, context.getString(resId), duration);
    }
    public static CustomToast makeText(Context context, int resId) {//默认是长吐司
        return new CustomToast(context, context.getString(resId), Toast.LENGTH_LONG);
    }
    public static CustomToast makeText(Context context, String text) {
        return new CustomToast(context, text, Toast.LENGTH_LONG);
    }

}
