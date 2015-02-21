package com.mycompany.deep.p1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLException;

/**
 * Created by deep on 2/20/15.
 */
public class DoteliData extends Activity {
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.dotelidata);
        final TextView tv = (TextView) findViewById(R.id.tvdatainfo);
        Button button =(Button) findViewById(R.id.buttonSend);
        Database info = new Database(this);
        try {
            info.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String data =info.getData();
        info.close();
        tv.setText(data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tosave = tv.getText().toString();
                Intent i= new Intent(android.content.Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,new String[]{"pandeydeep9@outlook.com"});
                i.putExtra(Intent.EXTRA_CC,"pandeydeep9@gmaskdn.com");
                i.putExtra(Intent.EXTRA_SUBJECT,"Words");
                i.setType("plain/Text");
                i.putExtra(Intent.EXTRA_TEXT,tosave);
                startActivity(i);
                Database up = new Database(DoteliData.this);
                try {
                    up.open();
                 //   up.delete();
                    up.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
