package com.mycompany.deep.p1;

        import android.app.Dialog;
        import android.app.ListActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuInflater;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
        import android.widget.TextView;

/**
 * Created by deep on 2/18/15.
 */
public class Contribute extends Activity implements View.OnClickListener{

    Button bsave,bview;
    EditText etEng,etUni,etDot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddata);
        bsave =(Button) findViewById(R.id.bsavedata);
        bview =(Button) findViewById(R.id.bviewdata);
        etEng =(EditText) findViewById(R.id.eteng);
        etUni=(EditText) findViewById(R.id.etuni);
        etDot =(EditText) findViewById(R.id.etdot);

        bsave.setOnClickListener(this);
        bview.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bsavedata:

                boolean didItWork = true;
                try {
                    String eng = etEng.getText().toString();
                    String uni = etUni.getText().toString();
                    String dot = etDot.getText().toString();

                    Database entry = new Database(Contribute.this);
                    entry.open();
                    entry.passdata(eng, uni, dot);
                    entry.close();
                } catch (Exception e) {
                    didItWork = false;
                } finally {
                    if (didItWork) {
                        Dialog d = new Dialog(this);
                        d.setTitle("Data based");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;
            case R.id.bviewdata:
                Intent intent = new Intent(Contribute.this,DoteliData.class);
                startActivity(intent);

                break;
        }
    }
}



