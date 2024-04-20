package com.example.kanmeitu.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.kanmeitu.activities.LoginActivity;

//偏好工具类
public class PreferencesUtil {
    private static final String KEY_LOGIN = "Login";
    private static PreferencesUtil instance;
//    private final Context context;
    private final SharedPreferences preferences;

    public PreferencesUtil(Context context) {
//        this.context=context;
        preferences = context.getSharedPreferences("ixuea", Context.MODE_PRIVATE);

    }


    //单例设计模式
    public static PreferencesUtil getInstance(Context context) {
        if (instance==null){
            instance=new PreferencesUtil(context.getApplicationContext());
        }
        return instance;
    }
    //设置是否登录
    public void setLogin(Boolean data){
        preferences.edit().putBoolean(KEY_LOGIN,data).commit();
    }

    //判断是否登录
    public boolean isLogin(){
        return preferences.getBoolean(KEY_LOGIN,false);
    }
}
