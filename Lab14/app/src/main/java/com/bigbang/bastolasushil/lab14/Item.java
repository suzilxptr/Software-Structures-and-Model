package com.bigbang.bastolasushil.lab14;

/**
 * Created by The BigBang on 1.4.2016.
 */
public class Item {
    private String link;
    private String title;
    private String des;


    public void setLink(String link) {
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getInfo(){
        return "Link: "+this.link+" \n Title "+this.title+" \n Description "+this.des+"\n \n";

    }




}
