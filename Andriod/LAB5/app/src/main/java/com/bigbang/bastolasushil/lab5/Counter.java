package com.bigbang.bastolasushil.lab5;

/**
 * Created by The BigBang on 14.3.2016.
 */
public class Counter {

    private int counter=0;


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        counter=5;
        this.counter = counter;
    }





    public int increaseCount(){
        counter++;
        return counter;

    }
    public int increaseCountlong(){
        counter=counter+9;
        return counter;

    }

    public int decreaseCount(){
        counter=counter-1;
        return counter;
    }

    public int reset(){

        counter=0;
        return counter;
    }
}
