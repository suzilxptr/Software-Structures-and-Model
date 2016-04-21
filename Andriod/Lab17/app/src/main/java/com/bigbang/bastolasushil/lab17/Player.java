package com.bigbang.bastolasushil.lab17;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by The BigBang on 7.4.2016.
 */

public class Player implements Parcelable {

    private String id;
    private String name;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Player(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public String toString() {
        return "Id: "+id+" Name: "+name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

