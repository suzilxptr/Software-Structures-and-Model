package com.bigbang.bastolasushil.lab19;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import java.net.URI;

/**
 * Created by The BigBang on 13.4.2016.
 */
public class PlayersContentProvider extends ContentProvider {
    int count1=0;
    private static DataBaseAdapter db;

    private static SQLiteDatabase database;
    public static final String PROVIDER_NAME="com.bigbang.bastolasushil.lab19.DataBaseAdapter";
    public static final Uri CONTENT_URI=Uri.parse("content://"+PROVIDER_NAME+"playerstable");
    private static final UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);
     static final int PLAYERS=1;
    static final int PLAYERS_ID=2;
    private String[] PROJECTION=new String[]{"_id","Name","id"};
    static{
     matcher.addURI(PROVIDER_NAME,"playerstable",PLAYERS);
        matcher.addURI(PROVIDER_NAME,"playerstable",PLAYERS_ID);


    }

    @Override
    public boolean onCreate() {
        Context context=getContext();
        db=new DataBaseAdapter(context);
        database=db.player.getWritableDatabase();
        System.out.println("Database Created1");
        if (database==null)return  false;
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
       String id=null;

        count++;


        SQLiteQueryBuilder sb=new SQLiteQueryBuilder();
        sb.setTables(db.player.TABLE_NAME);

        switch(matcher.match(uri)){
            case PLAYERS_ID:

            default:break;
        }

        Cursor cursor=sb.query(database,PROJECTION,"",strings1,s1,null,null);
        int columnIndex=cursor.getColumnIndex("Name");
        System.out.println("In provider"+ columnIndex);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);


        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {

        switch(matcher.match(uri)){
            case PLAYERS:
                return "vnd.android.cursor.dir/vnd.com.bigbang.bastolasushil.lab19.players";
            case PLAYERS_ID:
                return "vnd.android.cursor.item/vnd.com.bigbang.bastolasushil.lab19.players";

        }
        System.out.println(matcher.match(uri));

        return "";
    }
    int count=0;

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.d("count", count++ + "");

        try{
            System.out.println("In insert");
            long id=db.addData(contentValues);
            Uri returnURi= ContentUris.withAppendedId(CONTENT_URI,id);
            getContext().getContentResolver().notifyChange(uri, null);
            return returnURi;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
