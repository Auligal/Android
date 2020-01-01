package com.example.android.cloudvileage;
import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
public class MyLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;
    public MyLinearLayoutManager(Context context) {
        super(context);
    }
    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }
    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();

    }

}
