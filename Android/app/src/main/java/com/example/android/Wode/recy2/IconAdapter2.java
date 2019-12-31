package com.example.android.Wode.recy2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

import java.util.List;

public class IconAdapter2 extends RecyclerView.Adapter<IconAdapter2.ViewHolder>{
    private List<Icon2> mIconList;
    @NonNull
    @Override
    public IconAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_item2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconAdapter2.ViewHolder holder, int position) {
        Icon2 icon = mIconList.get(position);
        holder.imageView.setImageResource(icon.getImageId());
        holder.textView1.setText(icon.getName());
        holder.textView2.setText(icon.getNum());
    }

    @Override
    public int getItemCount() {
        return mIconList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.icon_image2);
            textView1 = itemView.findViewById(R.id.icon_name2);
            textView2 = itemView.findViewById(R.id.icon_num2);
        }
    }

    public IconAdapter2(List<Icon2> iconList) {
        mIconList = iconList;
    }
}
