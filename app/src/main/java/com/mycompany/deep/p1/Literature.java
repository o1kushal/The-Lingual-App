package com.mycompany.deep.p1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by deep on 2/21/15.
 */
public class Literature extends Activity implements View.OnClickListener{

    EditText editText;

    String sbut[] ={"Send","Save","View"};
    Button[] button = new Button[sbut.length];
    protected void onCreate(Bundle b){
        super.onCreate(b);

        editText  = new EditText(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(Color.WHITE);
      //



        editText.setHint("Enter your Contribution");

     //   LinearLayout.LayoutParams params =

       // editText.setLayoutParams();
        linearLayout.addView(editText);
        for(int i=0;i<sbut.length;i++){
            button[i] = new Button(this);
            button[i].setText(sbut[i]);
            button[i].setTextColor(Color.BLUE);
            button[i].setBackgroundColor(Color.WHITE);
            linearLayout.addView(button[i]);
        }
        for(int i=0;i<sbut.length;i++){
            button[i].setId(i);
            button[i].setOnClickListener(this);
        //
        }
        setContentView(linearLayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case 0:
                String tosave = editText.getText().toString();
                Intent i= new Intent(android.content.Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,new String[]{"pandeydeep9@outlook.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Literature");
                i.setType("plain/Text");
                i.putExtra(Intent.EXTRA_TEXT,tosave);
                startActivity(i);
                UpDatabase up = new UpDatabase(this);
                try {
                    up.open();
                 //   up.delete();
                    up.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                boolean didItWork = true;
                try {
                    tosave = editText.getText().toString();
                    UpDatabase entry = new UpDatabase(Literature.this);
                    entry.open();
                    entry.passdata(tosave);
                    entry.close();
                } catch (Exception e) {
                    didItWork = false;
                } finally {
                    if (didItWork) {
                        Dialog d = new Dialog(this);
                        d.setTitle("Data Saved");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;
            case 2:
                LinearLayout linearLayout = new LinearLayout(this);
                final TextView tv= new TextView(this);
                Button button1 = new Button(this);
                button1.setText("Send");
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                linearLayout.setBackgroundColor(Color.WHITE);

                UpDatabase info = new UpDatabase(this);
                try {
                    info.open();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String dataa =info.getData();
                info.close();
                tv.setText(dataa);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.addView(tv);
                linearLayout.addView(button1);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tosae = tv.getText().toString();
                        Intent i= new Intent(android.content.Intent.ACTION_SEND);
                        i.putExtra(Intent.EXTRA_EMAIL,new String[]{"pandeydeep9@outlook.com"});
                        i.putExtra(Intent.EXTRA_SUBJECT,"Literature");
                        i.setType("plain/Text");
                        i.putExtra(Intent.EXTRA_TEXT,tosae);
                        startActivity(i);

                    }
                });
                setContentView(linearLayout);
        }
    }
}
