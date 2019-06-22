package com.e.overridestorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_clickMe;
    TextView tv_ClickCounter;
    int counter = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickerValue", counter);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("clickerValue");
        tv_ClickCounter = findViewById(R.id.tv_ClickCounter);
        tv_ClickCounter.setText(String.valueOf(counter));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("OverrideApp","App Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("OverrideApp","App Stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("OverrideApp","App Paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("OverrideApp","App Resumed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("OverrideApp","App Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("OverrideApp","App Destroyed");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_clickMe = findViewById(R.id.btn_clickMe);
        tv_ClickCounter = findViewById(R.id.tv_ClickCounter);

        btn_clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                tv_ClickCounter.setText(String.valueOf(counter));
            }
        });
    }
}


