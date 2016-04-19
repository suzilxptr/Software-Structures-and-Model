package com.bigbang.bastolasushil.lab6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by The BigBang on 16.3.2016.
 */
public class Creature implements Serializable {
    private String name;
    private String type;


    public Creature(String name,String type){
        this.name=name;
        this.type=type;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return getName()+" "+getType()+"\n" ;

    }
}
