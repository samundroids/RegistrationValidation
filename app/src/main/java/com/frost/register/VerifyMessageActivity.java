package com.frost.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerifyMessageActivity extends AppCompatActivity {

    Button btn_verify_page_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_message);

        btn_verify_page_back = (Button) findViewById(R.id.btn_verify_page_back);

        btn_verify_page_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_back = new Intent(getApplicationContext(), MainActivity.class);

                //This will prevent MainActivity from being destroyed and recreated.
                // We add "FLAG_ACTIVITY_SINGLE_TOP" to the Intent to go back to the MainActivity
                intent_back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent_back);
            }
        });

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
