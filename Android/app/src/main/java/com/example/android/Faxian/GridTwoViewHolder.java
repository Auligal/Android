package com.example.android.Faxian;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

public class GridTwoViewHolder extends RecyclerView.ViewHolder {

    public RectImageView iv_icon;
    public TextView tv_content;

    public GridTwoViewHolder(View itemView) {
        super(itemView);
        iv_icon = (RectImageView) itemView.findViewById(R.id.iv_icon);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
    }
}
