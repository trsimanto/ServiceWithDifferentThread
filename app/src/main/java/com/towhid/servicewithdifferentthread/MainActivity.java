package com.towhid.servicewithdifferentthread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void servicesOn(View view) {
        startService(new Intent(MainActivity.this,MyService.class));

    }

    public void servicesOff(View view) {
        stopService(new Intent(MainActivity.this,MyService.class));
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();
        releaseInstance();
        super.onDestroy();
    }
}
