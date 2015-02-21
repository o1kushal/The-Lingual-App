package com.mycompany.deep.p1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * Created by deep on 2/17/15.
 */
public class Alphabets extends Activity {


    public void onCreate(Bundle b){
        super.onCreate(b);

        final EditText et =new EditText(this);
        final EditText et1 =new EditText(this);
        final EditText et2 =new EditText(this);
        Button but=new Button(this);
        final String []s=new String[3];
        LinearLayout linearLayout =new LinearLayout(this);
        linearLayout.setBackgroundColor(Color.rgb(255,228,181));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(Color.rgb(192, 192, 192));
        but.setText("Submit");
        linearLayout.addView(et);
        linearLayout.addView(et1);
        linearLayout.addView(et2);
        linearLayout.addView(but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<3;i++){
                    s[0]= et.getText().toString();
                    s[1]= et1.getText().toString();
                    s[2]= et2.getText().toString();
                }
            }
        });
        setContentView(linearLayout);
    }

}