package com.bigbang.bastolasushil.lab17;

import java.util.ArrayList;

/**
 * Created by The BigBang on 7.4.2016.
 */
public class Players {

    private static Players instance;
    private static ArrayList<Player> array = new ArrayList();

    public static void add(Player player){
        array.add(player);
    }

    public static Player get(int position){
        return array.get(position);
    }

    public static int getSize(){
        return array.size();
    }

    public static void clear(){
        array.clear();
    }
    @Override
    public String toString() {
        String result = "";
        for(Player p: this.array){
            result=result + p.toString()+"\n";
        }
        return result;
    }

    public static ArrayList<Player> getArray() {
        return array;
    }

    private Players(){

    }
    public static Players getInstance(){
        return instance;
    }
}

