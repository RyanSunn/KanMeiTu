package com.example.kanmeitu.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kanmeitu.utils.PreferencesUtil;

public class BaseActivity extends AppCompatActivity {

    /**
     * 访问修饰符改为protected
     */
    protected PreferencesUtil instance;

    /**
     * 重写了setContentView方法
     * 因为在子类调用了setContentView设置布局
     *
     * @param layoutResID
     */

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        instance = PreferencesUtil.getInstance(this);
    }
}
