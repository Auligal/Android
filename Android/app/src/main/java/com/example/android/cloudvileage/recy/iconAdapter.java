package com.example.android.cloudvileage.recy;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

import java.util.List;
import java.util.Random;

public class iconAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<icon> item;
    private Context context;
    private enum TYPE{
        longitem,
        mediumitem;
    }

    public iconAdapter(List<icon> list,Context context) {
        this.item = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return judgetype(position);
    }
    private int judgetype(int position){
        int randomnum;
        Random random = new Random();
        randomnum = random.nextInt(2);
        if(randomnum==0){
            return TYPE.longitem.ordinal();
        }else{
            return TYPE.mediumitem.ordinal();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==TYPE.longitem.ordinal()){
            return new longitemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.longitem,parent,false));
        }else{
            return new mediumitemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mediumitem,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        icon itemmessage = item.get(position);
        if(holder instanceof longitemViewHolder){
            ((longitemViewHolder) holder).imageView.setImageResource(itemmessage.getCloudvillage_image());
            ((longitemViewHolder) holder).textView.setText(item.get(position).getCloudvillage_title());
            ((longitemViewHolder) holder).imageView1.setImageResource(item.get(position).getCloudvillage_authorimage());
            ((longitemViewHolder) holder).textView1.setText(item.get(position).getCloudvillage_authorname());
            ((longitemViewHolder) holder).textView2.setText(item.get(position).getCloudvillage_clicknum());
        }else{
            ((mediumitemViewHolder) holder).imageView.setImageResource(itemmessage.getCloudvillage_image());
            ((mediumitemViewHolder) holder).textView.setText(item.get(position).getCloudvillage_title());
            ((mediumitemViewHolder) holder).imageView1.setImageResource(item.get(position).getCloudvillage_authorimage());
            ((mediumitemViewHolder) holder).textView1.setText(item.get(position).getCloudvillage_authorname());
            ((mediumitemViewHolder) holder).textView2.setText(item.get(position).getCloudvillage_clicknum());
        }
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
    private static class longitemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        ImageView imageView1;
        TextView textView1;
        TextView textView2;
        public longitemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cloudvillage_image);
            textView = itemView.findViewById(R.id.cloudvillage_title);
            imageView1 = itemView.findViewById(R.id.cloudvillage_authorimage);
            textView1 = itemView.findViewById(R.id.cloudvillage_authorname);
            textView2 = itemView.findViewById(R.id.cloudvillage_clicknum);
        }
    }
    private static class mediumitemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        ImageView imageView1;
        TextView textView1;
        TextView textView2;
        public mediumitemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.medium_cloudvillage_image);
            textView = itemView.findViewById(R.id.medium_cloudvillage_title);
            imageView1 = itemView.findViewById(R.id.medium_cloudvillage_authorimage);
            textView1 = itemView.findViewById(R.id.medium_cloudvillage_authorname);
            textView2 = itemView.findViewById(R.id.medium_cloudvillage_clicknum);
        }
    }
}
