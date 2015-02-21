package com.mycompany.deep.p1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by deep on 2/18/15.
 */
public class Languages extends Activity implements View.OnClickListener{
    String listb[]= {"Doteli" ,"Add_More"};
    Button [] buttons =new Button[listb.length];

    public void onCreate(Bundle b){
        super.onCreate(b);
        LinearLayout linearLayout =new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.setGravity(Gravity.CENTER);

        linearLayout.setBackgroundColor(Color.rgb(255, 255, 255));

        for(int i=0;i<listb.length;i++){
            buttons[i]=new Button(this);
            buttons[i].setPadding(10,20,20,10);
            buttons[i].setTextSize(30);
            buttons[i].setTextColor(Color.BLUE);
            buttons[i].setBackgroundColor(Color.rgb(255, 255, 255));
            buttons[i].setText(listb[i]);
            linearLayout.addView(buttons[i]);
        }
        for(int i=0;i<listb.length;i++){
            buttons[i].setOnClickListener(this);
            buttons[i].setId(i);
        }
        setContentView(linearLayout);
    }
    public void onClick(View v){
        switch (v.getId()){
       //     case 0:
         //       setContentView(R.layout.alphabets);
                //  Intent i =new Intent(Doteli.this,Alphabets.class);
                //  startActivity(i);
           //oo0     break;
            case 0:
                Intent i1 =new Intent(Languages.this,Doteli.class);
                startActivity(i1);
                break;
            case 1:
                Intent i2 = new Intent(Languages.this,Contributes.class);
                startActivity(i2);
                break;


        }

    }
}
