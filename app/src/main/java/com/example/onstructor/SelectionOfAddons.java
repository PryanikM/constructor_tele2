package com.example.onstructor;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SelectionOfAddons extends AppCompatActivity {
    private View view;
    private TextView cost;

    private TextView costSMS1, costSMS2, costSMS3, quantitySMS1, quantitySMS2, quantitySMS3;

    private ImageView sms1, sms2, sms3;

    private ArrayList<Integer> costSMS, quantitySMS;


    public SelectionOfAddons(View view, TextView cost){
        this.view = view;
        this.cost = cost;

        sms1 = (ImageView) view.findViewById(R.id.SMS1);
        sms2 = (ImageView) view.findViewById(R.id.SMS2);
        sms3 = (ImageView) view.findViewById(R.id.SMSinfinity);

        costSMS1 = (TextView) view.findViewById(R.id.costSMS1);
        costSMS2 = (TextView) view.findViewById(R.id.costSMS2);
        costSMS3 = (TextView) view.findViewById(R.id.costSMS3);

        quantitySMS1 = (TextView) view.findViewById(R.id.quantitySMS1);
        quantitySMS2 = (TextView) view.findViewById(R.id.quantitySMS2);
        quantitySMS3 = (TextView) view.findViewById(R.id.quantitySMS3);

        costSMS = new ArrayList<Integer>();
        costSMS.add(50);
        costSMS.add(75);
        costSMS.add(100);

        quantitySMS = new ArrayList<Integer>();
        quantitySMS.add(100);
        quantitySMS.add(300);


        startFirstWin();


    }

    @SuppressLint("SetTextI18n")
    public void startFirstWin(){
        costSMS1.setText("+" + String.format("%s", costSMS.get(0)) + view.getResources().getString(R.string.currensy));
        costSMS2.setText(String.format("+" +"%s", costSMS.get(1)) + view.getResources().getString(R.string.currensy));
        costSMS3.setText(String.format("+" +"%s", costSMS.get(2)) + view.getResources().getString(R.string.currensy));

        quantitySMS1.setText(String.format("%s", quantitySMS.get(0)));
        quantitySMS2.setText(String.format("%s", quantitySMS.get(1)));

        sms1.setColorFilter(Color.GRAY);
        sms2.setColorFilter(Color.GRAY);
        sms3.setColorFilter(Color.GRAY);



    }

}
