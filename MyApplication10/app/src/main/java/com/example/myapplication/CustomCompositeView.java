package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class CustomCompositeView extends LinearLayout {

    public CustomCompositeView(Context context) {
        super(context);
        init(context);
    }

    public CustomCompositeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomCompositeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        // 使用View的inflate方法来加载布局
        View.inflate(context, R.layout.custom_composite_view, this);
        // 初始化你的控件，绑定ViewModel等
    }
}
