package com.example.onstructor;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SeekBarCustom extends AppCompatActivity {
    private RelativeLayout forLine, mainLayout, presentTable;

    private TextView presentText;

    private View horizontalLine, verticalLine;

    private ImageView thumb;

    private float dX, dY;

    private View view;

    private ArrayList<TextView> textVertical, textHorizontal;

    private ArrayList<Integer> inputVertical, inputHorizontal;

    //    ArrayList<View> lineVertical, lineHorizontal;
    private ArrayList<ImageView> lineVertical, lineHorizontal;

    private boolean presentIsSelected;

    private Animation presentAnimation, iconAnimation, iconAnimationOut, presentAnimOut;

    private ImageView vk, viber, whats;

    private TextView internetText, minuteText, cost;

    public SeekBarCustom(View view, TextView cost) {
        this.view = view;
        this.cost = cost;

        vk = (ImageView) view.findViewById(R.id.vk_image);
        viber = (ImageView) view.findViewById(R.id.viber_image);
        whats = (ImageView) view.findViewById(R.id.whatsAppImage);


        presentIsSelected = false;

        presentAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.present_anim);
        iconAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.icons_anim);
        iconAnimationOut = AnimationUtils.loadAnimation(view.getContext(), R.anim.icons_anim_out);
        presentAnimOut = AnimationUtils.loadAnimation(view.getContext(), R.anim.present_anim_out);

        internetText = (TextView) view.findViewById(R.id.textInternet);
        minuteText = (TextView) view.findViewById(R.id.textMinutes);

        presentTable = (RelativeLayout) view.findViewById(R.id.presentTable);
        presentText = (TextView) view.findViewById(R.id.presentText);


        forLine = (RelativeLayout) view.findViewById(R.id.forLine);
        mainLayout = (RelativeLayout) view.findViewById(R.id.mainLayout);
        horizontalLine = (View) view.findViewById(R.id.horizontalLine);

        thumb = (ImageView) view.findViewById(R.id.thumb);

        verticalLine = (View) view.findViewById(R.id.verticalLine);

        lineHorizontal = new ArrayList<ImageView>();


        textHorizontal = new ArrayList<TextView>();
        textVertical = new ArrayList<TextView>();

        lineVertical = new ArrayList<ImageView>();

        inputHorizontal = new ArrayList<Integer>(5);
        inputHorizontal.add(100);
        inputHorizontal.add(200);
        inputHorizontal.add(300);
        inputHorizontal.add(400);
        inputHorizontal.add(500);

        inputVertical = new ArrayList<Integer>(5);
        inputVertical.add(5);
        inputVertical.add(10);
        inputVertical.add(15);
        inputVertical.add(30);
        inputVertical.add(40);

        create();

    }


    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables", "SetTextI18n"})
    private void create() {

        cost.setText("0" + " " + view.getResources().getString(R.string.pricePerMonth));

        minuteText.setText("0" + view.getResources().getString(R.string.minutes));
        internetText.setText("0" + view.getResources().getString(R.string.internet));

        for (int i = 0; i < inputVertical.size() + 1; i++) {
            ImageView line = new ImageView(view.getContext());
            line.setBackgroundColor(view.getResources().getColor(R.color.lineColor));
            line.setLayoutParams(new LinearLayout.LayoutParams(view.getResources().getDimensionPixelOffset(R.dimen.lineWight),
                    view.getResources().getDimensionPixelOffset(R.dimen.lineHeight)));
            forLine.addView(line);
            lineVertical.add(line);
        }


        for (int i = 0; i < inputHorizontal.size() + 1; i++) {

            ImageView line = new ImageView(view.getContext());
            line.setBackgroundColor(view.getResources().getColor(R.color.lineColor));
            line.setLayoutParams(new LinearLayout.LayoutParams(view.getResources().getDimensionPixelOffset(R.dimen.lineHeight),
                    view.getResources().getDimensionPixelOffset(R.dimen.lineWight)));
            line.setImageDrawable(view.getResources().getDrawable(R.drawable.dotted_line));
            forLine.addView(line);
            lineHorizontal.add(line);
//            View line = new View(this);
//            line.setBackgroundColor(Color.BLACK);
//            line.setBackground(getResources().getDrawable(R.drawable.dotted_line));
//            line.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.lineWight),
//                    getResources().getDimensionPixelOffset(R.dimen.lineHeight)));
//            line.setRotation(180);
//            forLine.addView(line);
//            lineVertical.add(line);
        }

        for (int i = 0; i < inputHorizontal.size(); i++) {
            TextView temp = new TextView(view.getContext());
            temp.setText(String.format("%s", inputHorizontal.get(i)));
            temp.setTextSize(view.getResources().getDimension(R.dimen.textSize));
            temp.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            mainLayout.addView(temp);
            textHorizontal.add(temp);


            TextView temp1 = new TextView(view.getContext());
            temp1.setText(String.format("%s", inputVertical.get(i)));
            temp1.setTextSize(view.getResources().getDimension(R.dimen.textSize));
            temp1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            mainLayout.addView(temp1);
            textVertical.add(temp1);

        }


        ViewTreeObserver vto = mainLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                for (int i = 0; i < lineVertical.size(); i++) {
//                    lineVertical.get(i).setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.lineWight)
//                            ,verticalLine.getHeight()));
                    lineVertical.get(i).setX((((float) (horizontalLine.getWidth() - view.getResources().getDimension(R.dimen.correct))
                            / (inputVertical.size())) * i));
                    lineVertical.get(i).setY(0);
                    lineHorizontal.get(i).setX(0);
                    lineHorizontal.get(i).setY((((float) verticalLine.getHeight() / inputHorizontal.size())) * i);

                }
                for (int i = 0; i < textHorizontal.size(); i++) {

                    textHorizontal.get(i).setY(horizontalLine.getY() + view.getResources().getDimension(R.dimen.correct));
                    textHorizontal.get(i).setX(horizontalLine.getX() + lineHorizontal.get(1).getX() +
                            view.getResources().getDimension(R.dimen.correctText) + (textHorizontal.get(i).getWidth()) +
                            lineVertical.get(i).getX());


                    textVertical.get(i).setX(horizontalLine.getX() - view.getResources().getDimension(R.dimen.correct) -
                            textVertical.get(i).getWidth());
                    textVertical.get(i).setY(horizontalLine.getY() - lineHorizontal.get(i + 1).getY() -
                            (textVertical.get(i).getHeight() / 2));

                }

            }
        });

        thumb.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        makePos(event.getRawX(), event.getRawY());
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if (checkWin(event.getRawX(), event.getRawY())) {
                            view.animate()
                                    .x(event.getRawX() + dX)
                                    .y(event.getRawY() + dY)
                                    .setDuration(0)
                                    .start();
//                            makePos(event.getRawX(), event.getRawY());
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        makePos(event.getRawX(), event.getRawY());
                        break;
                    default:
//                        makePos(event.getRawX(), event.getRawY());
                        return false;
                }
                return true;
            }
        });

    }

    private boolean checkWin(float x, float y) {
        if (x <= forLine.getX() || x >= (forLine.getX() + forLine.getWidth()) || y < textVertical.get(textVertical.size() - 3).getY() ) {

            return false;
        }
        return true;
    }

    @SuppressLint("SetTextI18n")
    private void makePos(float x, float y) {
//        Log.d("check11", String.format("%s", x) + "     " + String.format("%s", y));
        float tempX = 0;
        float tempY = 0;

        int posX, posY;

        float gapX = (float) horizontalLine.getWidth() / inputHorizontal.size();
        float gapY = (float) verticalLine.getHeight() / inputVertical.size();


        if (Math.round(y / gapY) >= 6) {
//            Log.d("%s", String.format("%s", 1) + "    " + String.format("%s", Math.round(y / gapY) + "   " +  String.format("%s", textVertical.get(Math.round(y / gapY) - 1).getY())));
            tempY = textVertical.get(0).getY();
            posY = 0; //

        } else if (Math.round(y / gapY) <= 1) {
//            Log.d("%s", String.format("%s", 2) + "    " + String.format("%s", Math.round(y / gapY) + "   " + String.format("%s", textVertical.get(Math.round(y / gapY) - 1).getY())));
            tempY = textVertical.get(textVertical.size() - 2).getY();
            posY = textVertical.size() - 2;
        } else {
//            Log.d("%s", String.format("%s", 3) + "    " + String.format("%s", Math.round(y / gapY)) +  "   " + String.format("%s", textVertical.get(Math.round(y / gapY) - 1).getY()));
            tempY = textVertical.get(textVertical.size() - Math.round(y / gapY) + 1).getY();
            posY = textVertical.size() - Math.round(y / gapY) + 1;
        }


        if (Math.round(x / gapX) >= inputHorizontal.size() + 1) {
            tempX = textHorizontal.get(inputHorizontal.size() - 1).getX();
            posX = inputHorizontal.size() - 1;
        } else if (Math.round(x / gapX) > 1) {
            tempX = textHorizontal.get(Math.round(x / gapX) - 2).getX();
            posX = Math.round(x / gapX) - 2;
        } else {
            tempX = textHorizontal.get(0).getX();
            posX = 0;
        }


//        }
        tempX += (float) thumb.getWidth() / 4;
        tempY += (float) thumb.getHeight() / 4;
        Log.d("check11", String.format("%s", tempX) + "     " + String.format("%s", tempY));
        thumb.setX(tempX);
        thumb.setY(tempY);

        internetText.setText(String.format("%s", inputVertical.get(posY)) + " " + view.getResources().getString(R.string.internet));
        minuteText.setText(String.format("%s", inputHorizontal.get(posX)) + " " + view.getResources().getString(R.string.minutes));
        cost.setText(String.format("%s", (Math.round((float) inputHorizontal.get(posX) / 2) + inputVertical.get(posY)) * 2) + " " + view.getResources().getString(R.string.pricePerMonth));
        checkPresent(posX, posY);


    }

    public void checkPresent(int posX, int posY) {
        if ((posX >= 1 && posY >= 2 && (!presentIsSelected)) || (posY >= 2) && (!presentIsSelected)) {
            presentIsSelected = true;
            presentTable.setVisibility(View.VISIBLE);
            presentText.setVisibility(View.VISIBLE);
            presentTable.startAnimation(presentAnimation);

            vk.setVisibility(View.VISIBLE);
            viber.setVisibility(View.VISIBLE);
            whats.setVisibility(View.VISIBLE);

            vk.startAnimation(iconAnimation);
            viber.startAnimation(iconAnimation);
            whats.startAnimation(iconAnimation);

        } else if ((posY < 2 && presentIsSelected)) {
            presentIsSelected = false;
            vk.startAnimation(iconAnimationOut);
            viber.startAnimation(iconAnimationOut);
            whats.startAnimation(iconAnimationOut);

            vk.setVisibility(View.INVISIBLE);
            viber.setVisibility(View.INVISIBLE);
            whats.setVisibility(View.INVISIBLE);

            presentTable.startAnimation(presentAnimOut);
            presentTable.setVisibility(View.INVISIBLE);

        }

    }
}
