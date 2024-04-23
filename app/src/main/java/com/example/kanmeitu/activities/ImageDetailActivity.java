package com.example.kanmeitu.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kanmeitu.R;
import com.example.kanmeitu.utils.Constants;
import com.example.kanmeitu.utils.ImageUtil;

public class ImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_detail);
        ImageView imageView = findViewById(R.id.image);


        //获取传递参数
        String uri = getIntent().getStringExtra(Constants.ID);

        ImageUtil.show(imageView,uri);
    }
}