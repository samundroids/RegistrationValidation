package com.frost.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VerifyMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_message);

        Intent intent = getIntent();

        String vname = intent.getStringExtra(MainActivity.V_NAME);
        String vemail = intent.getStringExtra(MainActivity.V_EMAIL);
        String vpass = intent.getStringExtra(MainActivity.V_PASS);

        TextView textView1 = (TextView) findViewById(R.id.tv_newmsg1);
        TextView textView2 = (TextView) findViewById(R.id.tv_newmsg2);
        TextView textView3 = (TextView) findViewById(R.id.tv_newmsg3);

        textView1.setText(vname);
        textView2.setText(vemail);
        textView3.setText(vpass);
    }
}
