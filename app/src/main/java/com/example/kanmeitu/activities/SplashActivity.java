package com.example.kanmeitu.activities;

import static java.time.temporal.TemporalAdjusters.next;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kanmeitu.R;
import com.qmuiteam.qmui.util.QMUIActivityLifecycleCallbacks;
import com.qmuiteam.qmui.util.QMUICollapsingTextHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        //沉浸式状态栏，暂时无效
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarDarkMode(this);

        findViewById(R.id.copyright).postDelayed(new Runnable() {
            @Override
            public void run() {
                next();
            }
        },3000);
    }

    private void next() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);


    }
}