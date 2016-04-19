package com.bigbang.bastolasushil.lab15;

import java.util.ArrayList;

/**
 * Created by The BigBang on 31.3.2016.
 */
public class AllPlayers {
    private static AllPlayers fromXml=new AllPlayers();

    private ArrayList<Player> allplayers=new ArrayList<Player>();
    Player p=new Player("Sushil",123);




    public AllPlayers(){
        allplayers=new ArrayList<Player>();

    }

    public void addplayer(Player p){

        allplayers.add(p);

    }

    public ArrayList getPlayers(){

        return allplayers;
    }

    public String allPlayers(){
        StringBuilder s=new StringBuilder();
        for(int i=0; i< allplayers.size(); i++){
            Player p=  allplayers.get(i);
            String detail=p.playerDetail();
            s.append(detail+"\n");


        }
        return s.toString();
    }
    public static AllPlayers getFromXml(){

        return fromXml;
    }


}
