package com.bigbang.bastolasushil.lab17;

/**
 * Created by The BigBang on 7.4.2016.
 */
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class DisplayListActivity extends AppCompatActivity {
    private Players players = Players.getInstance();
    private ListView mListView;
    private Button mAddPlayerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        mListView = (ListView) findViewById(R.id.listView);
        mAddPlayerButton = (Button) findViewById(R.id.addButton);

        Intent intent = getIntent();
        boolean isPooling = intent.getBooleanExtra("checkbox", false);
        Log.d("boolean ispooling",""+ isPooling);
        PlayerAdapter adapter = new PlayerAdapter(this, players);
        mListView.setAdapter(adapter);

        mAddPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayListActivity.this, AddPlayerActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        if(!isPooling){return;}

        Intent updateIntent = new Intent(this, MyAlarmManager.class);
        long scTime = 20000;//20s
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, updateIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+scTime, pendingIntent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        PlayerAdapter adapter = (PlayerAdapter) mListView.getAdapter();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lab13"," in destroy");
        Intent updateIntent = new Intent(this, MyAlarmManager.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, updateIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.cancel(pendingIntent);
    }
}
