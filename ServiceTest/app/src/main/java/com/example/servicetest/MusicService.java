package com.example.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {


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
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //onStartCommand()는 onStart()와 onResume()이 같이 있다고 생각하자.
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
