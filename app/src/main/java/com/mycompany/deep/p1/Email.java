package com.mycompany.deep.p1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by deep on 2/20/15.
 */
public class Email extends Activity {

    String message="jkdsab kan adkofn doaknfc";
    protected void onCreate(Bundle b){
        super.onCreate(b);
        EditText etinputemail = new EditText(this);
        etinputemail.setHint("Enter your Email");
    //    setContentView(etinputemail);
        String emailaddress = "fgdfg";//etinputemail.getText().toString();
        Intent i= new Intent(android.content.Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,"pandeydeep9@outlook.com");
        i.putExtra(Intent.ACTION_SENDTO,"pandeydeep9@outlook.com");
        i.putExtra(Intent.EXTRA_SUBJECT,"Language");
        i.setType("plain/Text");
        i.putExtra(Intent.EXTRA_TEXT,message);
        startActivity(i);

    }
}
