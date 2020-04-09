package com.example.servicetest;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    private static final String TAG="MusicService";
    private MediaPlayer mediaPlayer;
    BroadcastReceiver bcr;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //원격 인터페이스 호출의 경우에는 onStartCommand()대신에 onBind()가 동작한다.
        //서비스와 클라이언트 사이의 인터페이스 역할을 한다.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this, R.raw.walk);
        bcr=new MusicBroadcastReceiver();

        Log.d(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //onStartCommand()는 onStart()와 onResume()이 같이 있다고 생각하자.

//        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        Log.d(TAG, "onStartCommand()");

        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_SCREEN_OFF);
        this.registerReceiver(bcr, intentFilter);



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        Log.d(TAG, "onDestroy()");
    }

}
