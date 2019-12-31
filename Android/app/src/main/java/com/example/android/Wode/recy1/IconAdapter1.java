package com.example.android.Wode.recy1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

import java.util.List;

public class IconAdapter1 extends RecyclerView.Adapter<IconAdapter1.ViewHolder>{
    private List<Icon1> mIconList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView iconName;
        ViewHolder(View view){
            super(view);
            iconImage = (ImageView) view.findViewById(R.id.icon_image);
            iconName = (TextView) view.findViewById(R.id.icon_name);
        }
    }
    public IconAdapter1(List<Icon1>iconList){
        mIconList = iconList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.icon_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Icon1 icon = mIconList.get(position);
        holder.iconImage.setImageResource(icon.getImageId());
        holder.iconName.setText(icon.getName());
    }

    @Override
    public int getItemCount() {
        return mIconList.size();
    }
}
