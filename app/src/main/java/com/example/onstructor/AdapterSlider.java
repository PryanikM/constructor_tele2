package com.example.onstructor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class AdapterSlider extends PagerAdapter {
    private int count;
    private Context context;
    private LayoutInflater layoutInflater;
    private Animation upToDown;
    private RelativeLayout mainSeekBarLayout;
    private android.widget.SeekBar.OnSeekBarChangeListener listener;
    private View seekBarView;
    private TextView cost;
    private SeekBarCustom seekBar;
    private SelectionOfAddons selectionOfAddons;


    public AdapterSlider(Context context, int count, TextView cost) {
        this.cost = cost;
        this.context = context;
        this.count = count;
//        upToDown = AnimationUtils.loadAnimation(context, R.anim.up_to_down);
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        switch (position) {
            case 0:
                view = layoutInflater.inflate(R.layout.seek_bar_layout, container, false);
                seekBar = new SeekBarCustom(view, cost);
                break;
            case 1:
                view = layoutInflater.inflate(R.layout.selection_of_addons, container, false);
                selectionOfAddons = new SelectionOfAddons(view, cost);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.d("IamHere", "2");
        container.removeView((LinearLayout) object);
    }


}

