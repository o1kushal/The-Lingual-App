package com.mycompany.deep.p1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by deep on 2/17/15.
 */
public class Practice extends Activity {
    ImageView ivpract;
    ImageView image;
    EditText etpract;
    Button bpractice,bimag;
    Bitmap bmp;
    int[] images={R.drawable.namaste,R.drawable.bye,R.drawable.food};
    int idimages=0;
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.practice);
        initialize();
        bimag.setGravity(Gravity.CENTER);
        etpract.setTextColor(Color.WHITE);
        bimag.setBackgroundResource(images[idimages]);
        bpractice.setBackgroundResource(R.drawable.gears);
        bpractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String s=etpract.getText().toString();
                if(s.equals("namaste")||s.equals("नमस्ते")&&idimages==0) {
                  //  bimag.setBackgroundResource(i[1]);
                    idimages=1;
                    bpractice.setBackgroundResource(R.drawable.check);
                }
                if(s.equals("khana")||s.equals("खाना")&&idimages==2) {
                    //  bimag.setBackgroundResource(i[1]);
                    idimages=0;
                    bpractice.setBackgroundResource(R.drawable.check);
                }
                if(s.equals("bye")&&idimages==1) {
                    //  bimag.setBackgroundResource(i[1]);
                    idimages=2;
                    bpractice.setBackgroundResource(R.drawable.check);

                }
              //  if(s.equals("bye")||s.equals("bb")) {
               //     bimag.setBackgroundResource(R.drawable.bye);
               //     bpractice.setBackgroundResource(R.drawable.check);
               //     etpract.setText(null);
               // }

                else {

                    bpractice.setBackgroundResource(R.drawable.check);
                }
                etpract.setText(null);
                bimag.setBackgroundResource(images[idimages]);

                }

        });

    }
    private void initialize()
    {
  //      ivpract =(ImageView) findViewById(R.id.ivpractice);
        etpract =(EditText) findViewById(R.id.etpractice);
        bpractice =(Button) findViewById(R.id.bcheck);
        bimag =(Button) findViewById(R.id.bimage);
    }

}
