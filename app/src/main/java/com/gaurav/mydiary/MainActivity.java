package com.gaurav.mydiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tname,tphone,temail;
    EditText ename,ephone,eemail;
    Button btnSubmit,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tname = (TextView) findViewById(R.id.tname);
        tphone = (TextView) findViewById(R.id.tphone);
        temail = (TextView) findViewById(R.id.temail);

        ename = (EditText) findViewById(R.id.editText_name);
        ephone = (EditText) findViewById(R.id.editText_phone);
        eemail = (EditText) findViewById(R.id.editText_email);

        btnSubmit = (Button) findViewById(R.id.BtnSubmit);
        btnClear = (Button) findViewById(R.id.BtnClear);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ename.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), ename.getText()+"  Please,Enter Your Name.", Toast.LENGTH_SHORT).show();
                }
                else if(ephone.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "Please, Enter Your Phone No.", Toast.LENGTH_SHORT).show();
                }
                else if(eemail.getText().toString().matches(""))                {
                    Toast.makeText(getApplicationContext(), "Please, Enter Email.", Toast.LENGTH_SHORT).show();
                }
                else if(!Validation.isValidPhoneNumber(ephone.getText())) {
                    Toast.makeText(getApplicationContext(), "Invalid Phone No.", Toast.LENGTH_SHORT).show();
                }
                else if (!Validation.isValidEmail(eemail.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Invalid Email address.", Toast.LENGTH_SHORT).show();
                }
                else{

                    Person gaurav = new Person(ename.getText().toString(), ephone.getText().toString(), eemail.getText().toString());
                    Intent i = new Intent(getApplicationContext(), Display.class);
                    i.putExtra("send_Object", gaurav);
                    clear();
                    startActivity(i);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
    }
    void clear()
    {
        ename.setText("");
        ephone.setText("");
        eemail.setText("");
        ename.requestFocus();
    }

}
class Validation {

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static final boolean isValidPhoneNumber(CharSequence target) {
        if (target.length()!=10) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }
    }

}
