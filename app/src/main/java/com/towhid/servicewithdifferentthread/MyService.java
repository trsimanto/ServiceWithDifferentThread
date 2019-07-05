package com.towhid.servicewithdifferentthread;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.SynchronousQueue;

public class MyService extends Service {
    int a = 0;
    Thread thread;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Services Create", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        a++;
        Toast.makeText(this, "Services Starts : " + a, Toast.LENGTH_SHORT).show();

        thread = new Thread(new MyThreadClass(startId));
        thread.run();


        return START_NOT_STICKY;// super.onStartCommand(intent, flags, startId);  //START_STICKY; ata use korle service auto e on hoea jay jode system off kore day
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Services stop ", Toast.LENGTH_SHORT).show();
        thread.run();
        super.onDestroy();
    }

    //inner class
    final class MyThreadClass implements Runnable {
        int service_id;

        public MyThreadClass(int service_id) {
            this.service_id = service_id;
        }

        @Override
        public void run() {
            if (!Thread.currentThread().isInterrupted()) {
                Log.d("ok", "run: ");
            } else {
                Log.d("ok", "stop");
            }
            // ae kahne code run kore


        }


    }

}
