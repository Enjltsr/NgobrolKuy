package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private TextView spakun;
    private TextView regis;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText cpassword;

    public static final String USER_KEY = "username";
    public static final String EMAIL_KEY = "email";
    public static final String PASS_KEY = "password";
    public static final String CPASS_KEY = "cpassword";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        spakun = findViewById(R.id.spa);
        regis = findViewById(R.id.regis);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);


        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final String uname = username.getText().toString();
                    final String emaill = email.getText().toString();
                    final String pass = password.getText().toString();
                    final String cpass = cpassword.getText().toString();

                Intent reg = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(reg);
            }
        });

        spakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginyuk = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginyuk);
            }
        });
    }
}