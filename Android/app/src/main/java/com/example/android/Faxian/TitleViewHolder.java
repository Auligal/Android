package com.example.android.Faxian;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

public class TitleViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_content;

    public TitleViewHolder(View itemView) {
        super(itemView);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
    }
}
