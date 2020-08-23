package com.example.onstructor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AdapterSlider adapterSlider;
//    private ArrayList<TextView> pointCount;
    private ViewPager sliderViewPager;
//    private LinearLayout pointCountLayout;
    private Animation startAnim_up, startAnim_down;
    private SeekBarCustom seekBar;
    private TextView cost, textViewButton;

    private ImageView imageArrow;

    private RelativeLayout pointLayout;

    private int numberPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPage = 0;

//        cost = (TextView) findViewById(R.id.cost);
        cost = (TextView) findViewById(R.id.cost);

        startAnim_down = AnimationUtils.loadAnimation(this, R.anim.down_up_main);
        startAnim_up = AnimationUtils.loadAnimation(this, R.anim.up_down_main);
        adapterSlider = new AdapterSlider(this, 2, cost);
        sliderViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        pointLayout = (RelativeLayout) findViewById(R.id.countLayout);
        adapterSlider.notifyDataSetChanged();
        sliderViewPager.setAdapter(adapterSlider);
//        addPointIndicator(0);
        textViewButton = (TextView) findViewById(R.id.textViewButton);

        imageArrow = (ImageView) findViewById(R.id.imageArrow);

        sliderViewPager.startAnimation(startAnim_up);
        pointLayout.startAnimation(startAnim_down);

        textViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (numberPage){
                    case 0:
                        sliderViewPager.setCurrentItem(numberPage + 1);
                }
            }
        });

    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {
            numberPage = position;
            switch (position) {
                case 0:
                    textViewButton.setText(getResources().getString(R.string.next));
                    imageArrow.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    textViewButton.setText(getResources().getString(R.string.pay));
                    imageArrow.setVisibility(View.INVISIBLE);
                    break;
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}