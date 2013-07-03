package com.example.Test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;

public class RemoteService extends Service {

    /**
     * TAG,用于输出Log，在这里，我们把pid，即进程的ID也记录上
     * 这样就可以比较Service的进程和Client的进程是否在同一进程
     */
    private static final String TAG = "RemoteService, PID=" + Process.myPid();

    /**
     * 定义RemoteService的Binder，在这个Binder里面，我们实现了一个
     * 函数，getCount()，用于计算getCount()函数被调用的次数。
     * 这个函数需要到IRemoteService.aidl注册。
     */

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        private int mCount = 0;
        /**
         * 返回函数调用次数，每调用一次，加1
         */
        public int getCount() {
            mCount++;
            Log.d(TAG, TAG + " getCount: " + mCount);
            return mCount;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return mBinder;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onCreate()");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onStart()");
        super.onStart(intent, startId);

        testNotification();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onDestroy()");
        super.onDestroy();
    }

    protected void testNotification() {
        NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification n = new Notification(R.drawable.ic_launcher, "ASINBOW", System.currentTimeMillis());
        n.flags = Notification.FLAG_AUTO_CANCEL;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        //PendingIntent
        PendingIntent contentIntent = PendingIntent.getActivity(
                getApplicationContext(),
                R.string.app_name,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        n.setLatestEventInfo(
                getApplicationContext(),
                "ASINBOW",
                "Content shown!",
                contentIntent);
        nm.notify(R.string.app_name, n);
    }
}
