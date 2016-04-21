package com.bigbang.bastolasushil.lab15;

import java.io.Serializable;

/**
 * Created by The BigBang on 31.3.2016.
 */
public class Player implements Serializable{
    private String name;
    private int id;

    public Player (String name,int id){
        this.name=name;
        this.id=id;

    }
    public Player(){

    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }




    public void setName(String name){
        this.name=name;

    }

    public void setId(int id){
        this.id=id;

    }

    public String playerDetail(){
        return "Name: "+this.name+" id: "+this.id;

    }

   @Override
    public boolean  equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Player employee = (Player) object;
            if (this.name == employee.getName() ) {
                result = true;
            }
        }
        return result;
    }


}
