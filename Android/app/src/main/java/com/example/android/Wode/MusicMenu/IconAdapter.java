package com.example.android.Wode.MusicMenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.Bofang.BofangActivity;
import com.example.android.R;

import java.util.List;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.HolderView> {
    List<Icon> list;
    private Context context;
    public IconAdapter(List<Icon> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_item4,parent,false);
        return new HolderView(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, final int position) {
        Icon icon = list.get(position);
        holder.no.setText(String.valueOf(icon.getNum()));
        holder.name.setText(icon.getName());
        holder.author.setText(icon.getSingername());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BofangActivity.class);
                intent.putExtra("music",String.valueOf(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class HolderView extends RecyclerView.ViewHolder{
        TextView no;
        TextView name;
        TextView author;

        public HolderView(@NonNull View itemView, final Context context) {
            super(itemView);
            no = itemView.findViewById(R.id.music_no);
            name = itemView.findViewById(R.id.music_name);
            author = itemView.findViewById(R.id.music_author);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, BofangActivity.class);
//                    context.startActivity(intent);
//                }
//            });
        }
    }
}
