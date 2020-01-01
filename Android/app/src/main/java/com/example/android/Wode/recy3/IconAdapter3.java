package com.example.android.Wode.recy3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;
import com.example.android.Wode.MusicMenuActivity;
import com.example.android.Wode.WoDeActivity;

import java.util.List;

public class IconAdapter3 extends RecyclerView.Adapter<IconAdapter3.ViewHolder> {
    private List<Icon3> mIconList;
    private Context context;
    @NonNull
    @Override
    public IconAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_item3,parent,false);
        return new ViewHolder(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull IconAdapter3.ViewHolder holder, int position) {
        Icon3 icon = mIconList.get(position);
        holder.imageView.setImageResource(icon.getImage1());
        holder.textView.setText(icon.getStr());
        holder.textView2.setText(icon.getNum());
        holder.imageView2.setImageResource(icon.getImage2());

    }
    public IconAdapter3(List<Icon3> iconList, Context context) {
        this.mIconList = iconList;
        this.context = context;
    }
    @Override
    public int getItemCount() {
        return mIconList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        TextView textView2;
        ImageView imageView2;
        ViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            imageView = itemView.findViewById(R.id.icon_image3);
            textView = itemView.findViewById(R.id.icon_name3);
            textView2 = itemView.findViewById(R.id.icon_num3);
            imageView2 = itemView.findViewById(R.id.icon_image_more3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,MusicMenuActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
