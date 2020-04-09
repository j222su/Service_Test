package com.example.servicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class MusicBroadcastReceiver extends BroadcastReceiver {

    Vibrator vibrator;
    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            getVibrated();

        }
    }

    private void getVibrated() {
        vibrator=(Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(500);
    }
}
