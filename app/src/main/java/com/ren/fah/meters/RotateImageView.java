package com.ren.fah.meters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by k_sugimoto on 2014/11/19.
 */
public class RotateImageView extends ImageView {
    private int nowDegree = 0;

    public RotateImageView(Context context){
        super(context);
    }

    public RotateImageView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public RotateImageView(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
    }

    public int getNowDegree() {
        return nowDegree;
    }

    public void setNowDegree(int nowDegree) {
        this.nowDegree = nowDegree;
    }
}
