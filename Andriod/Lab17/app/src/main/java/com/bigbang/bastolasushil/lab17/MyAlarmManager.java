package com.bigbang.bastolasushil.lab17;

/**
 * Created by The BigBang on 7.4.2016.
 */

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by minhcao on 4/2/16.
 */
public class MyAlarmManager extends BroadcastReceiver {
    Context _context;
    private static final String URL = "http://users.metropolia.fi/~duyc/players.xml";

    @Override
    public void onReceive(Context context, Intent intent) {
        _context= context;
        Toast.makeText(_context, "Fetched newest player list!", Toast.LENGTH_LONG).show();
        Log.d("receive", "updated");
        new DownloadXmlTask(_context, false).execute(URL);

        Intent updateIntent = new Intent(_context, MyAlarmManager.class);
        long scTime = 20000;//20s
        PendingIntent pendingIntent = PendingIntent.getBroadcast(_context, 0, updateIntent, 0);
        AlarmManager alarmManager = (AlarmManager) _context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + scTime, pendingIntent);
    }
}
