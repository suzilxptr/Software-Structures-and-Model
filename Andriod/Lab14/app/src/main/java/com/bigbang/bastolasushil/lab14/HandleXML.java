package com.bigbang.bastolasushil.lab14;

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

    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;
    Thread thread;
    StringBuilder s=new StringBuilder();

    Item i;

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

                        if (name.equals( "item")){

                            i = new Item();

                        } else if (i != null){
                            if (name.equals("link")){
                                String link=myParser.nextText();

                                i.setLink(link);
                            } else if (name.equals("title")){
                                i.setTitle(myParser.nextText());

                            }
                            else if (name.equals("description")){
                                i.setDes(myParser.nextText());
                                s.append(i.getInfo());
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

                    URL url = new URL("http://yle.fi/uutiset/rss/uutiset.rss?osasto=news");
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
    public String allPlayers(){
        StringBuilder s=new StringBuilder();

        return s.toString();
    }



}