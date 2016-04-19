package com.bigbang.bastolasushil.lab15;

import java.util.ArrayList;

/**
 * Created by The BigBang on 3.4.2016.
 */
public class ObserversCollection {
    private ArrayList<Updater> observers;
    private static ObserversCollection o=new ObserversCollection();


    private ObserversCollection(){
        this.observers=new ArrayList<>();
    }
    public static ObserversCollection getInstance(){
        return o;
    }
    public void addObserver(Updater o){
        this.observers.add(o);

    }
    public void deleteObserver(Updater o){
        int placeValue=observers.indexOf(o);
        observers.remove(placeValue);

    }
    public void update(){
        for(Updater observer:observers){
            observer.update();
        }
    }



}
