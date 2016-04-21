package com.bigbang.bastolasushil.lab19;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by The BigBang on 31.3.2016.
 */
public class HandleXML implements Serializable {



    AllPlayers allplayers=AllPlayers.getFromXml();
    ArrayList<Player> addedPlayer=new ArrayList<>();
    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;
    Thread thread;
    MainActivity main;
   Handler handler;
    ArrayList<String> names=new ArrayList<String>();
    DataBaseAdapter db;
    String id="";

    public AllPlayers getAllplayers() {
        return allplayers;
    }


    Player p=null;

    public HandleXML(String url,DataBaseAdapter db,MainActivity main) {
        this.main=main;
        this.urlString=url;

        this.db=db;

    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
       // allplayers.getPlayers().clear();



        try {
            event = myParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                String name="";
                String id1="";



                switch (event){

                    case XmlPullParser.START_DOCUMENT:

                        break;
                    case XmlPullParser.START_TAG:

                        name = myParser.getName();

                        ContentValues values=new ContentValues();
                        if (name.equals( "player")){

                            p = new Player(name,0);

                        } else if (p != null){
                            if (name.equals("id")){

                                id=myParser.nextText();
                                System.out.println(id);

                            }
                            else if (name.equals("name")){

                                name=myParser.nextText();
                                p.setName(name);
                                values.put("id", id);
                                values.put("Name", name);

                                Uri uri=main.getContentResolver().insert(main.CONTENT_URI,values);



                            }



                        }

                        break;


                }
                event = myParser.next();
            }


            parsingComplete = false;

        }


        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchXML() throws InterruptedException {
         thread = new Thread(new Runnable(){
            @Override
            public void run() {


                        try {




                            URL url = new URL("http://users.metropolia.fi/~peterh/players.xml");
                            HttpURLConnection conn = (HttpURLConnection)url.openConnection();



                            InputStream stream = conn.getInputStream();

                            xmlFactoryObject = XmlPullParserFactory.newInstance();
                            XmlPullParser myparser = xmlFactoryObject.newPullParser();

                            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                            myparser.setInput(stream, null);

                            parseXMLAndStoreIt(myparser);
                            stream.close();

                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }


                    }


         });

        thread.start();
        thread.join();

    }



}