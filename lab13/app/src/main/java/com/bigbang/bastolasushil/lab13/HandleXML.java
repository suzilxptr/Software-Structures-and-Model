package com.bigbang.bastolasushil.lab13;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by The BigBang on 31.3.2016.
 */
public class HandleXML {
    public AllPlayers getAllplayers() {
        return allplayers;
    }

    AllPlayers allplayers=new AllPlayers();
    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;
    Thread thread;

        Player p=null;

    public HandleXML(String url) {
        this.urlString=url;
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;


        try {
            event = myParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                String name=null;



                switch (event){

                    case XmlPullParser.START_DOCUMENT:

                        break;
                    case XmlPullParser.START_TAG:

                        name = myParser.getName();

                        if (name.equals( "player")){

                            p = new Player();

                        } else if (p != null){
                            if (name.equals("id")){
                                String id1=myParser.nextText();


                                int id=Integer.parseInt(id1);
                                p.setId(id);
                            } else if (name.equals("name")){
                                p.setName(myParser.nextText());

                                allplayers.addplayer(p);

                            }


                        }

                        break;


                }
                event = myParser.next();
            }

            //System.out.println(allplayers.allPlayers());
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