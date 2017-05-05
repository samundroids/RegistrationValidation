package com.frost.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    public static final String V_NAME = "com.frost.register.V_NAME";
    public static final String V_EMAIL = "com.frost.register.V_EMAIL";
    public static final String V_PASS = "com.frost.register.V_PASS";

    private EditText et_Fname, et_EmailSU, et_PassSU;
    private String Fname, EmailSU, PassSU;
    Button btn_submit;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_Fname = (EditText) findViewById(R.id.et_Fname);
        et_EmailSU = (EditText) findViewById(R.id.et_EmailSU);
        et_PassSU = (EditText) findViewById(R.id.et_PassSU);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)

            {
                register(); //called when the button is clicked to validate the input
            }
        });
    }
    public void register()
    {

        initialize(); // initialize the input to string variables
        if(!validate())
        {

            Toast.makeText(this, "Signup Failed", Toast.LENGTH_LONG).show();
        }
        else
        {
            onSignupSuccess();
        }
    }
    public void onSignupSuccess()
    {
        Intent intent = new Intent(this, VerifyMessageActivity.class);
        EditText editText1 = (EditText) findViewById(R.id.et_Fname);
        EditText editText2 = (EditText) findViewById(R.id.et_EmailSU);
        EditText editText3 = (EditText) findViewById(R.id.et_PassSU);

        String vname = editText1.getText().toString();
        String vemail = editText2.getText().toString();
        String vpass = editText3.getText().toString();

        intent.putExtra(V_NAME, vname);
        intent.putExtra(V_EMAIL, vemail);
        intent.putExtra(V_PASS, vpass);

        startActivity(intent);

    }

    public boolean validate()
    {

        boolean valid=true;
        if(Fname.isEmpty()||Fname.length()>32)
        {

            et_Fname.setError("Please enter a valid name");
            valid = false;
        }
        if(EmailSU.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(EmailSU).matches())
        {

            et_EmailSU.setError("Please enter a valid email");
            valid = false;
        }
        if(PassSU.isEmpty())
        {

            et_PassSU.setError("Password field shouldn't be empty");
            valid = false;
        }
        return valid;

    }

    public void initialize()
    {

        Fname = et_Fname.getText().toString().trim();
        EmailSU = et_EmailSU.getText().toString().trim();
        PassSU = et_PassSU.getText().toString().trim();
    }
}
