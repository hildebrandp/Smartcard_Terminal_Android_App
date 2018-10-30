package com.example.hilde.smartcardreader;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hilde on 14.02.2018.
 */

public class service_Smartcard extends Service {

    private final IBinder mBinder = new MyBinder();
    private Timer mTimer = null;
    private Handler mHandler = new Handler();
    private static IsoDep myNFCTag;
    public static final String NOTIFICATION_CLOSE = "CLOSE";

    @Override
    public IBinder onBind(Intent arg0) {
        return mBinder;
    }

    public class MyBinder extends Binder {
        service_Smartcard getService() {
            return service_Smartcard.this;
        }
    }

    @Override
    public void onCreate() {
        myNFCTag = MainActivity.myNFCTag;
    }

    /**
     * Method which starts Timer with interval of 5 seconds
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startTimer(1000);
        return START_STICKY;
    }

    /**
     * Timer Method
     * If dosen´t exists start new Timer
     * else stop old timer and start new
     * @param time interval
     */
    public void startTimer(int time) {
        if( mTimer != null ) {
            mTimer.cancel();
            mTimer = new Timer();
        } else {
            mTimer = new Timer();
        }

        mTimer.scheduleAtFixedRate(new checkConnection(), 1000, time);
        Log.v("App:", "Service running!");
    }

    /**
     * Timer Task which is called in the interval of 5 seconds
     * The Method checks if the Smartcard is connected
     * If Card is disconnected it sends Broadcast
     */
    class checkConnection extends TimerTask
    {
        @Override
        public void run()
        {
            mHandler.post(new Runnable() {
                @Override
                public void run()
                {
                    if ( myNFCTag != null ) {
                        if (!myNFCTag.isConnected()) {
                            Log.v("App:", "Smartcard no connection!");
                            Intent intent = new Intent(NOTIFICATION_CLOSE);
                            intent.putExtra("RESULT", "TRUE");
                            sendBroadcast(intent);
                            mTimer.cancel();
                        }
                    }
                }

            });
        }
    }

}
