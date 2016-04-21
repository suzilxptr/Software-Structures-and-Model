package com.bigbang.bastolasushil.lab19;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by The BigBang on 10.4.2016.
 */
public class DataBaseAdapter  {
    private static HashMap<String, String> amp;
    PlayerSQLiteDb player;
    AllPlayers allplayers=AllPlayers.getFromXml();

    public DataBaseAdapter(Context context){
        player=new PlayerSQLiteDb(context);
        System.out.println("Database Created2");

    }
    public long insertData(String name, String id){
        SQLiteDatabase db=player.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(player.NAME, name);
        values.put(player.ID,id);
        System.out.println("Data added "+name+" "+id);
       long ID= db.insert(player.TABLE_NAME,null,values);
        System.out.println(ID);
        return ID;
    }
    public long addData(ContentValues values){
        long id=player.getWritableDatabase().insert(player.TABLE_NAME,"",values);

        System.out.println("In daPlayers");
        return id;

    }


    public Cursor getPlayers(String id,String[] projection,String selection,String[] selectionArgs,String sortOrder){
        SQLiteQueryBuilder sb=new SQLiteQueryBuilder();
        sb.setTables(player.TABLE_NAME);
        if(id!=null){
            sb.appendWhere("_id"+"="+id);
        }

        if(sortOrder==null || sortOrder==""){
            sortOrder="id";
        }

        Cursor cursor=sb.query(player.getReadableDatabase(),projection,selection,selectionArgs,null,null,sortOrder);
        System.out.println("The names of column"+cursor.getColumnNames().toString());
        System.out.println("In getPlayers");
        //Log.d("cursor value", cursor.getString(cursor.getColumnIndex("Name")));
        return cursor;


    }


    class PlayerSQLiteDb extends SQLiteOpenHelper{
        final static String  DATABASE_NAME="playerdb";
        final static String TABLE_NAME="playerstable";
        final static int DATABASE_VERSION=36;
        final static String UID="_id";
        final static String NAME="Name";
        final static String ID="id";
        final static String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(50), "+ID+" VARCHAR(50));";
        final static String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
        public PlayerSQLiteDb(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            System.out.println("Database Created");
            sqLiteDatabase.execSQL(CREATE_TABLE);


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            System.out.println("ONUPGRADE CALLED");
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);


        }

    }


}
