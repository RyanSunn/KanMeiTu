package com.example.kanmeitu.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.kanmeitu.R;

//图片工具类
public class ImageUtil {

    public static void show(ImageView view ,String data){
        
        RequestOptions options= getCommonRequestOptions();
        Glide.with(view.getContext()).load(data).into(view);
    }

    private static RequestOptions getCommonRequestOptions() {
        RequestOptions options = new RequestOptions();

        //加载前占位图
        options.placeholder(R.drawable.placeholder);
        //加载错误图片
        options.error(R.drawable.error_load);

        //测试，禁用所有缓存
//        options.diskCacheStrategy(DiskCacheStrategy.NONE);
        return options;
    }
}
