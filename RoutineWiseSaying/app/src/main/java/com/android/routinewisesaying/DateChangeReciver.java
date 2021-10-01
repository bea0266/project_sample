package com.android.routinewisesaying;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class DateChangeReciver extends BroadcastReceiver {
    private boolean changed = false;
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(Intent.ACTION_DATE_CHANGED.equals(action)){

                changed = true;

        }
    }
    public boolean getStatus(){
        return this.changed;
    }
    public void changedReset(){
        this.changed = false;
    }

}
