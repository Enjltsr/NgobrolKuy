package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import de.hdodenhof.circleimageview.CircleImageView;


public class ProfilePicActivity extends AppCompatActivity {
    private ImageView edit;
    private CircleImageView pp;
    private TextView next;
    private TextView pas;
    Uri imageUri;

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);
        edit = findViewById(R.id.edit);
        pp = findViewById(R.id.profilePic);
        next = findViewById(R.id.next);
        pas = findViewById(R.id.pas);


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tambah = new Intent(ProfilePicActivity.this, LoginActivity.class);
                tambah.putExtra("imageUri", imageUri.toString());
                startActivity(tambah);
            }
        });

        pas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lewat = new Intent(ProfilePicActivity.this, HomeChat.class);
                startActivity(lewat);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         if(resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Input gambar dibatalkan", Toast.LENGTH_SHORT).show();
            return;
        }else if(requestCode == GALLERY_REQUEST_CODE){
            if(data != null){
                try {
                    imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),
                            imageUri);
                    pp.setImageBitmap(bitmap);
                    CardView next = findViewById(R.id.nxt);
                    next.setVisibility(View.VISIBLE);
                    pas.setVisibility(View.GONE);
                }
                catch (IOException e){
                    Toast.makeText(this, "Tidak bisa memuat gambar", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}