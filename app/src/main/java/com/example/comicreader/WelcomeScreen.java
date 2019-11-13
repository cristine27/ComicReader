package com.example.comicreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class WelcomeScreen extends AppCompatActivity {
    protected int waktu_delay = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeScreen.this,MainActivity.class);
                startActivity(intent);
                Animatoo.animateDiagonal(WelcomeScreen.this);
                finish();
            }
        },waktu_delay);
    }
}
