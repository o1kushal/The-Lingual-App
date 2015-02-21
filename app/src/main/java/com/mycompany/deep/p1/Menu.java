package com.mycompany.deep.p1;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;

/**
 * Created by deep on 2/17/15.
 */
public class Menu extends Activity implements View.OnClickListener {


    String lista[]= {"Languages","Contribute","Translate","Preferences","AboutUs"};
    String bimage[]={"lang"};
    Bitmap bitmaplang,bitmapcont,bitmaptrans;
    Button [] buttons =new Button[lista.length];

    protected void onCreate(Bundle b){
        super.onCreate(b);
        bitmaplang = BitmapFactory.decodeResource(getResources(), R.drawable.lang);
        bitmapcont = BitmapFactory.decodeResource(getResources(), R.drawable.cont);
        bitmaptrans = BitmapFactory.decodeResource(getResources(), R.drawable.trans);
        HorizontalScrollView horizontalScrollView  =new HorizontalScrollView(this);
        LinearLayout linearLayout =new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);


        linearLayout.setGravity(Gravity.CENTER);

        linearLayout.setBackgroundColor(Color.rgb(40,120,120));

        for(int i=0;i<lista.length;i++){
            buttons[i]=new Button(this);

           // buttons[i].setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT,RadioGroup.LayoutParams.WRAP_CONTENT));


          //  buttons[i].setTextSize(30);
          //  buttons[i].setText(lista[i]);
            buttons[i].setWidth(linearLayout.getWidth());
          //  buttons[i].setBackgroundColor(Color.rgb(0, 191, 255));
            linearLayout.addView(buttons[i]);
        }
        buttons[0].setBackgroundResource(R.drawable.lang);
        buttons[1].setBackgroundResource(R.drawable.cont);
        buttons[2].setBackgroundResource(R.drawable.trans);
        for(int i=0;i<lista.length;i++){

            buttons[i].setOnClickListener(this);
            buttons[i].setId(i);
        }
        horizontalScrollView.addView(linearLayout);
        setContentView(horizontalScrollView);
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
                Intent i =new Intent(Menu.this,Languages.class);
                startActivity(i);
                break;
            case 1:
                Intent i2 =new Intent(Menu.this,Contributes.class);
                startActivity(i2);
                break;
            case 2:
                Intent i3 =new Intent(Menu.this,Contributes.class);
                startActivity(i3);


        }
    }
}
