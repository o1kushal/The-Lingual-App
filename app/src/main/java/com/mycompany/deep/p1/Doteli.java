package com.mycompany.deep.p1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by deep on 2/17/15.
 */
public class Doteli extends Activity implements View.OnClickListener {


   String []x={"Doteli","This language is spoken by around 2.5 million people." +
           " Among these 1.8 million people were in Nepal." +
           " It possess official status in Constitution of Nepal.",

           "Description:This language is spoken by around 2.5 million people. Among these 1.8 million" +
                   " people were in Nepal. It possess official status in Constitution of Nepal"};
    String []changable={"Alphabets","Words","Phrases","Practice"};
    Button [] button = new Button[changable.length];
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        TextView [] tv=new TextView[3];

       EditText et =new EditText(this);
        ScrollView scrollView =new ScrollView(this);

        LinearLayout linearLayout =new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(0, 20, 0, 0);
        linearLayout.setBackgroundColor(Color.rgb(100, 140, 140));
        for(int i=0;i<x.length;i++){
            tv[i]=new TextView(this);

            tv[i].setGravity(Gravity.CENTER);
            tv[i].setBackgroundColor(Color.argb(0,0,0,0));
            tv[i].setTextColor(Color.BLUE);
            tv[i].setText(x[i]);
           if(i==0) tv[i].setTextSize(30);
            if(i==1) {
                tv[i].setTextSize(15);
            }
            if(i==3){
              //  tv[i].setPadding(10,10,10,300);
              //  tv[i].setPaddingRelative(10,10,10,300);
            }



         //   tv[3].setPadding(0,0,0,30);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.addView(tv[i]);
        }
        for(int i=0;i<changable.length;i++){
            button[i]=new Button(this);
            button[i].setTextSize(25);

            button[i].setTextColor(Color.WHITE);
            button[i].setBackgroundColor(Color.rgb(100,140,140));
            button[i].setText(changable[i]);
            linearLayout.addView(button[i]);
        }
       // linearLayout.addView(et);
        for(int i=0;i<changable.length;i++){
            button[i].setOnClickListener(this);
            button[i].setId(i);
        }
        scrollView.addView(linearLayout);
        setContentView(scrollView);


    }


    @Override
    public void onClick(View v){
        switch (v.getId()){
            case 0:
                setContentView(R.layout.alphabets);

                break;
            case 1:
                 Intent i =new Intent(Doteli.this,Wordsdis.class);
                 startActivity(i);
                break;
            case 2:
                Intent intent =new Intent(Doteli.this,Wordsdis.class);
                startActivity(intent);

                break;
            case 3:
                Intent i3 =new Intent(Doteli.this,Practice.class);
                startActivity(i3);
                break;

        }

    }
}


