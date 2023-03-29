package com.student.greentrail;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private ImageView topBgImgView, bottomBgImgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        topBgImgView = findViewById(R.id.login_bg_top_imageview);
        bottomBgImgView = findViewById(R.id.login_bg_bottom_imageview);


    }
}