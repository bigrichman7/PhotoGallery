package com.bigrichman.android.photogallery;

import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

public class NotificationReciever extends BroadcastReceiver {

    private static final String TAG = "NotificationReciever";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "recieved result: " + getResultCode());
        if(getResultCode() != Activity.RESULT_OK) {
            //Активность переднего плана отменила рассылку
            return;
        }

        int requestCode = intent.getIntExtra(PollService.REQUEST_CODE, 0);
        Notification notification = (Notification) intent.getParcelableExtra(PollService.NOTIFICATION);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(requestCode, notification);
    }
}
