package com.mycompany.deep.p1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by deep on 2/21/15.
 */
public class Splash extends Activity{

    Bitmap gBall;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        gBall = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
        LinearLayout linearLayout =new LinearLayout(this);

        ImageView iv =new ImageView(this);
        iv.setImageBitmap(gBall);

        linearLayout.addView(iv);
        linearLayout.setGravity(Gravity.CENTER);
        setContentView(linearLayout);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent i=new Intent(Splash.this,Menu.class);
                    startActivity(i);
                }
            }
        };timer.start();
        }
    protected void onPause(){
        super.onPause();
        finish();

    }
}
