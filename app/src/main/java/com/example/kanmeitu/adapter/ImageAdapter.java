package com.example.kanmeitu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanmeitu.R;
import com.example.kanmeitu.utils.ImageUtil;

import java.util.List;
//图片adapter
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.viewHolder> {

    private final List<String> images;
    private final Context context;
    private final LayoutInflater inflater;
    private OnItemClickListener listener;

    public ImageAdapter(Context context, List<String> images) {
        this.context= context;
        this.images= images;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(inflater.inflate(R.layout.item_image,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.bind(images.get(position));
        if (listener!=null){
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    //设置点击监听器
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public String getData(int position) {
        return images.get(position);
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }

        public void bind(String datas) {
            ImageUtil.show(imageView,datas);
        }
    }
}
