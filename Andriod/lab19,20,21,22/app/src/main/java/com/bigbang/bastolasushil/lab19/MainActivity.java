package com.bigbang.bastolasushil.lab19;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity   implements LoaderManager.LoaderCallbacks<Cursor> {
    private final static String url = "http://users.metropolia.fi/~peterh/players.xml";
    ListView view;
    CustomAdapter c = new CustomAdapter(this);

    Button add;


    private HandleXML obj;
    AllPlayers all = AllPlayers.getFromXml();
    DataBaseAdapter db;
    private SimpleCursorAdapter adapter1;
    public static final String PROVIDER_NAME="com.bigbang.bastolasushil.lab19.DataBaseAdapter";
    public static final Uri CONTENT_URI=Uri.parse("content://"+PROVIDER_NAME+"/playerstable");
    private String[] PROJECTION=new String[]{"_id","Name","id"};
    private String[] GETLIST=new String[]{"Name","id"};
    Calendar cur_cal = Calendar.getInstance();
    XmlService service;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        CustomAdapter adapter = (CustomAdapter) view.getAdapter();
        adapter.notifyDataSetChanged();
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent serviceIntent=new Intent(MainActivity.this,XmlService.class);
        PendingIntent pendingIntent=PendingIntent.getService(MainActivity.this,0,serviceIntent,0);
        AlarmManager myalarm=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        myalarm.setRepeating(AlarmManager.RTC_WAKEUP, cur_cal.getTimeInMillis(),20*1000,pendingIntent);
        adapter1=new SimpleCursorAdapter(getBaseContext(),R.layout.customlayout,null,GETLIST,new int[]{R.id.each,R.id.Name},0);
        view = (ListView) findViewById(R.id.listView);
        view.setAdapter(adapter1);
        getLoaderManager().initLoader(0, null, this);
        obj = new HandleXML(url, db,this);
        try {
            obj.fetchXML();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,CONTENT_URI,PROJECTION,"",null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        adapter1.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter1.swapCursor(null);
    }

    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            XmlService.XmlBinder binder=(XmlService.XmlBinder)iBinder;
            service=binder.getInstance();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
