package com.mycompany.deep.p1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by deep on 2/19/15.
 */
public class Wordsdis extends Activity implements View.OnClickListener{




    // String []x=obj.get_content_name();
 //   String []changable={"sdskf","sjdfsbf"};
    Button[] button = new Button[5];

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        TextView tv=new TextView(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Color.BLACK);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.setBackgroundColor(Color.rgb(100,140,140));



        Database info = new Database(this);
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

        setContentView(linearLayout);

    }

    @Override
    public void onClick(View v) {

    }
}
