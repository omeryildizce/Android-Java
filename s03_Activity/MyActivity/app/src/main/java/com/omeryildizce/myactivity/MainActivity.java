package com.omeryildizce.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Takip: ", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Takip: ", "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Takip: ", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Takip: ", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Takip: ", "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Takip: ", "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Takip: ", "onDestroy");

    }
}