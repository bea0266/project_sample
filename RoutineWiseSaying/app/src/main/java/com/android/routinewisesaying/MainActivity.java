package com.android.routinewisesaying;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.util.Calendar;
import java.util.Date;

/*
    명언 배열을 10개 저장한다.
    시간에 따라 명언이 바뀌게 한다.(해결)
    => 그러나 처음에 디폴트 값으로 세팅이 되버린다.
    앱을 종료 시에도 정보가 저장되어야 한다.

 */
public class MainActivity extends AppCompatActivity {



    final String[] WISES = {
            "명언 1", "명언 2", "명언 3", "명언 4", "명언 5", "명언 6", "명언 7", "명언 8", "명언 9", "명언 10"
    };

    TextView tvWise;
    TextChangeHandler handler = new TextChangeHandler();
    DateChangeReciver dateReciver = new DateChangeReciver();
    //LocalTime currentTime = LocalTime.now();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_DATE_CHANGED);
        this.registerReceiver(dateReciver, intentFilter);


        tvWise = (TextView) findViewById(R.id.tvWise);


        BackgroundThread thread = new BackgroundThread();
        thread.start();

    }

    class BackgroundThread extends Thread {

        boolean running = false;

        @Override
        public void run() {
            super.run();
            running = true;
            int i = 0;
            while(running) {
                if(i>=10)
                    i = 0;
                while(i<10) {
                Bundle bundle = new Bundle();
                bundle.putString("wise", WISES[i]);

                Message msg = handler.obtainMessage();
                msg.setData(bundle);
                if(dateReciver.getStatus()==true){
                    handler.sendMessage(msg);
                    i++;
                }else {
                    continue;
                }


                dateReciver.changedReset();

            }


            }
        }
    }

    class TextChangeHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            String value = msg.getData().getString("wise");
            tvWise.setText(value);

        }
    }


    @Override
    protected void onDestroy() {
        this.unregisterReceiver(dateReciver);
        super.onDestroy();
    }
}




