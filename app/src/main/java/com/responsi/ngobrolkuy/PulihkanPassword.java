package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PulihkanPassword extends AppCompatActivity {
    private TextView submit;
    private ImageView backk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulihkan_password);

        submit = findViewById(R.id.submit);
        backk=findViewById(R.id.imageViewback);

        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent balik = new Intent(PulihkanPassword.this, LoginActivity.class);
                startActivity(balik);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submit = new Intent(PulihkanPassword.this, CekEmail.class);
                startActivity(submit);
            }
        });


    }
}