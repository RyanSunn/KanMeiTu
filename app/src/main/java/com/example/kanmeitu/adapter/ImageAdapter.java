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
    }

    @Override
    public int getItemCount() {
        return images.size();
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
