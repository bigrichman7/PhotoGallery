package com.bigrichman.android.photogallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartupReciever extends BroadcastReceiver {

    private static final String TAG = "StartupReciever";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Recieved broadcast intent: " + intent.getAction());

        boolean isOn = QueryPreferences.isAlarmOn(context);
        PollService.setServiceAlarm(context, isOn);
    }
}
