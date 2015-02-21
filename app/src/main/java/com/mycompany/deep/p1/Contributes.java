package com.mycompany.deep.p1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by deep on 2/21/15.
 */
public class Contributes extends Activity implements View.OnClickListener{
    String lista[]= {"Words","Phrases","Literature"};
    Button[] buttons =new Button[lista.length];

    protected void onCreate(Bundle b){
        super.onCreate(b);
        LinearLayout linearLayout =new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);


        linearLayout.setGravity(Gravity.CENTER);

        linearLayout.setBackgroundColor(Color.WHITE);

        for(int i=0;i<lista.length;i++){
            buttons[i]=new Button(this);
            buttons[i].setPadding(0,20,0,10);
            buttons[i].setTextSize(30);
            buttons[i].setText(lista[i]);
            buttons[i].setWidth(300);
            buttons[i].setTextColor(Color.BLUE);
            buttons[i].setBackgroundColor(Color.WHITE);
            linearLayout.addView(buttons[i]);
        }
        for(int i=0;i<lista.length;i++){
            buttons[i].setOnClickListener(this);
            buttons[i].setId(i);
        }
        setContentView(linearLayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //     case 0:
            //       setContentView(R.layout.alphabets);
            //  Intent i =new Intent(Doteli.this,Alphabets.class);
            //  startActivity(i);
            //oo0     break;
            case 0:
                Intent i =new Intent(Contributes.this,Contribute.class);
                startActivity(i);
                break;
            case 1:
                Intent i2 =new Intent(Contributes.this,Contribute.class);
                startActivity(i2);
                break;
            case 2:
                Intent i3 =new Intent(Contributes.this,Literature.class);
                startActivity(i3);


        }
    }
}
