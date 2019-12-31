package com.example.android.Wode.recy3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

import java.util.List;

public class IconAdapter3 extends RecyclerView.Adapter<IconAdapter3.ViewHolde> {
    private List<Icon3> mIconList;
    @NonNull
    @Override
    public ViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_item3,parent,false);
        return new ViewHolde(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolde holder, int position) {
        Icon3 icon = mIconList.get(position);
        holder.imageView.setImageResource(icon.getImage1());
        holder.textView.setText(icon.getStr());
        holder.textView2.setText(icon.getNum());
        holder.imageView2.setImageResource(icon.getImage2());
    }
    public IconAdapter3(List<Icon3> iconList) {
        mIconList = iconList;
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolde extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        TextView textView2;
        ImageView imageView2;
        public ViewHolde(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.icon_image3);
            textView = itemView.findViewById(R.id.icon_name3);
            textView2 = itemView.findViewById(R.id.icon_num3);
            imageView2 = itemView.findViewById(R.id.icon_image_more3);
        }
    }
}
