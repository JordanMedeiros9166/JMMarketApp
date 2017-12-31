package com.example.jordan.jmmarketapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Jordan on 12/30/2017.
 *
 * Firebase receive push notifications and return to main activity
 *
 */

public class MyMsgManager {
    private Context cntxt;
    public static final int MSG_ID = 555;
    public MyMsgManager(Context cntxt){
        this.cntxt = cntxt;
    }
    public void showNotificationMsg(String from, String notification, Intent intent){
        PendingIntent pendIntent = PendingIntent.getActivity(
              cntxt,MSG_ID,intent,PendingIntent.FLAG_UPDATE_CURRENT
        );
        NotificationCompat.Builder builder = new NotificationCompat.Builder(cntxt);
        Notification MyNotification = builder.setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(pendIntent)
                .setContentTitle(from)
                .setContentText(notification)
                .setLargeIcon(BitmapFactory.decodeResource(cntxt.getResources(),R.mipmap.ic_launcher))
                .build();

        MyNotification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notManager = (NotificationManager) cntxt.getSystemService(Context.NOTIFICATION_SERVICE);
        notManager.notify(MSG_ID, MyNotification);


    }
}
