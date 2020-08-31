package com.example.gadsassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    /*Duration of Wait*/
    private  final int SPLASH_DISPLAY_LENGTH = 3000;
    /* Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //hide() method hides the action bar
       // getActionBar().hide();
      //  getSupportActionBar().hide();
        /*New Handler to start the Main Activity and
         * closes this splash
         * after some time*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //set the opening activity after 3 seconds are over
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}