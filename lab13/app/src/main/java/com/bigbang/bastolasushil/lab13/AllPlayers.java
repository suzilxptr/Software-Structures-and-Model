package com.bigbang.bastolasushil.lab13;

import java.util.ArrayList;

/**
 * Created by The BigBang on 31.3.2016.
 */
public class AllPlayers {
    private ArrayList<Player> allplayers=new ArrayList<>();




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

}
