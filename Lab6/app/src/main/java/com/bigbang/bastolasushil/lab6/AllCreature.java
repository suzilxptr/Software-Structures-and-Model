package com.bigbang.bastolasushil.lab6;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by The BigBang on 18.3.2016.
 */
public class AllCreature implements Serializable
{
    private static AllCreature c= new AllCreature();
    private ArrayList<Creature> all=new ArrayList<>();

    public ArrayList<Creature> getAll()
    {
        return all;
    }

    public void setAll(ArrayList<Creature> all)
    {
        this.all = all;
    }

    public void add(Creature c)
    {
        all.add(c);

    }

    public void loadFile(){


    }

    public static AllCreature getCreature(){

        return c;

    }



}

