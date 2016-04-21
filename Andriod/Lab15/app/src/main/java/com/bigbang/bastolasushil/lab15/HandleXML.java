package com.bigbang.bastolasushil.lab15;

import android.os.Handler;
import android.os.Message;

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
   Handler handler;
    ArrayList<String> names=new ArrayList<String>();
    public AllPlayers getAllplayers() {
        return allplayers;
    }


    Player p=null;

    public HandleXML(String url,Handler h) {
        this.urlString=url;
        this.handler=h;

    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
       // allplayers.getPlayers().clear();



        try {
            event = myParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                String name=null;



                switch (event){

                    case XmlPullParser.START_DOCUMENT:

                        break;
                    case XmlPullParser.START_TAG:

                        name = myParser.getName();
                        int id=0;

                        if (name.equals( "player")){

                            p = new Player(name,id);

                        } else if (p != null){
                            if (name.equals("id")){
                                String id1=myParser.nextText();
                                 id=Integer.parseInt(id1);
                                p.setId(id);
                            }
                            else if (name.equals("name")){
                                p.setName(myParser.nextText());
                                System.out.println("The size is " + allplayers.getPlayers().size());
                                System.out.println("The size of names " + names.size());


                                    if(!names.contains(p.getName())){
                                        names.add(p.getName());
                                        allplayers.addplayer(p);
                                    }


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