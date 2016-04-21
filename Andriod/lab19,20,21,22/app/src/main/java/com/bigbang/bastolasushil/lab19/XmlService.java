package com.bigbang.bastolasushil.lab19;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class XmlService extends Service {
    public final IBinder binder = new XmlBinder();
    private XmlPullParserFactory xmlFactoryObject;
    public static final String PROVIDER_NAME = "com.bigbang.bastolasushil.lab19.DataBaseAdapter";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/playerstable");
    public volatile boolean parsingComplete = true;
    Thread thread;
    MainActivity main;
    Handler handler;
    Player p;
    int count = 0;
    Context context;


    DataBaseAdapter db;
    String id = "";

    public XmlService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Oncreate", "Oncreate() called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ContentValues values = new ContentValues();
        values.put("id", count++ + "");
        values.put("Name", "Sushil");

        Uri uri = getContentResolver().insert(CONTENT_URI, values);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.images)
                        .setContentTitle("Players Info")
                        .setContentText("Click to view!");

        Intent resultIntent = new Intent(this, MoreInfoActivity.class);
        resultIntent.putExtra("Name", "Sushil" + " " + count);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MoreInfoActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(2, mBuilder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d("onbind", "onbind() called");
        return binder;


    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;

        try {
            event = myParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                String name = "";
                String id1 = "";


                switch (event) {

                    case XmlPullParser.START_DOCUMENT:

                        break;
                    case XmlPullParser.START_TAG:

                        name = myParser.getName();

                        ContentValues values = new ContentValues();
                        if (name.equals("player")) {

                            p = new Player(name, 0);

                        } else if (p != null) {
                            if (name.equals("id")) {

                                id = myParser.nextText();
                                System.out.println(id);

                            } else if (name.equals("name")) {

                                name = myParser.nextText();
                                p.setName(name);
                                values.put("id", id);
                                values.put("Name", name);

                                Uri uri = getContentResolver().insert(CONTENT_URI, values);
                            }
                        }

                        break;


                }
                event = myParser.next();
            }


            parsingComplete = false;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchXML() throws InterruptedException {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://users.metropolia.fi/~peterh/players.xml");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();


                    InputStream stream = conn.getInputStream();

                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser = xmlFactoryObject.newPullParser();

                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(stream, null);

                    parseXMLAndStoreIt(myparser);
                    stream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
    }
    public class XmlBinder extends Binder {
        XmlService getInstance() {
            return XmlService.this;
        }

    }

}
