package com.gaurav.mydiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Display  extends AppCompatActivity {
    TextView tname,tphone,temail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tname = (TextView) findViewById(R.id.t2);
        tphone = (TextView) findViewById(R.id.t4);
        temail = (TextView) findViewById(R.id.t6);


        Intent i = getIntent();
        Person gaurav = (Person) i.getSerializableExtra("send_Object");

        tname.setText(gaurav.getName());
        tphone.setText(gaurav.getPhoneNumber());
        temail.setText(gaurav.getEmailId());
    }
}
