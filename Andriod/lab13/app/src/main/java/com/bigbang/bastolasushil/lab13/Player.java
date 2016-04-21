package com.bigbang.bastolasushil.lab13;

/**
 * Created by The BigBang on 31.3.2016.
 */
public class Player {
    private String name;
    private int id;


    public void setName(String name){
        this.name=name;

    }

    public void setId(int id){
        this.id=id;

    }

    public String playerDetail(){
        return "Name: "+this.name+" id: "+this.id;

    }
}
