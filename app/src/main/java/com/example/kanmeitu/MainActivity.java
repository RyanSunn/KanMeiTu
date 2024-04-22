package com.example.kanmeitu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanmeitu.activities.BaseActivity;
import com.example.kanmeitu.activities.LoginActivity;
import com.example.kanmeitu.adapter.ImageAdapter;
import com.example.kanmeitu.utils.PreferencesUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        findViewById(R.id.Logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清除登录数据
                instance.setLogin(false);

                //退出到登陆界面,当然也可根据业务不跳转
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

                //关闭本界面
                finish();
            }
        });

        //初始化RecyclerView
        RecyclerView listView = findViewById(R.id.list);
        listView.setHasFixedSize(true);

        //显示2列，我们这里实现的是每个图片的宽高都是一样
        //最好的效果其实是根据图片高度和宽度来缩放
        //因为每一张图片大小不一样
        //但这样实现涉及到的知识点很多

        //这里使用了GridLayoutManager
        //他会显示类似9宫格布局效果
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        listView.setLayoutManager(layoutManager);

        //添加测试数据
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            datas.add(String.format("https://dev-courses-quick.oss-cn-beijing.aliyuncs.com/%d.jpg",i));
        }
        ImageAdapter adapter = new ImageAdapter(this, datas);
        listView.setAdapter(adapter);

    }

}