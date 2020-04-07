package com.example.servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStart, btnStop;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=findViewById(R.id.btnStart);
        btnStop=findViewById(R.id.btnStop);

        intent=new Intent(getApplicationContext(), MusicService.class);
        //intent로 service에 음악데이터를 넘긴다.
        //intent에서 서비스를 지정하고(MusicService.class) 이 서비스가 사용할 모든 데이터를 포함한다.
        //Service는 onStartCommand()에서 이 intent를 받는다.
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart : startService(intent); break;
            case R.id.btnStop : Toast.makeText(getApplicationContext(), "stop", Toast.LENGTH_LONG).show();
            stopService(intent);  break;
            default: Toast.makeText(getApplicationContext(), "???", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        stopService(intent);
        super.onDestroy();

    }
}
