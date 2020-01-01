package com.example.android.Faxian;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

public class GridThreeViewHolder extends RecyclerView.ViewHolder {

    public SquareImageView iv_icon;
    public TextView tv_content;

    public GridThreeViewHolder(View itemView) {
        super(itemView);
        iv_icon = (SquareImageView) itemView.findViewById(R.id.iv_icon);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
    }
}
