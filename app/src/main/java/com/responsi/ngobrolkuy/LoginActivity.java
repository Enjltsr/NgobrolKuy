package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView bpakun;
    private TextView login;
    private TextView lupa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bpakun = findViewById(R.id.bpa);
        login = findViewById(R.id.login);
        lupa = findViewById(R.id.lupa);

        lupa.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lupa = new Intent(LoginActivity.this, PulihkanPassword.class);
                startActivity(lupa);
            }
        }));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masuk = new Intent(LoginActivity.this, ProfilePicActivity.class);
                startActivity(masuk);
            }
        });

        bpakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(daftar);
            }
        });
    }
}