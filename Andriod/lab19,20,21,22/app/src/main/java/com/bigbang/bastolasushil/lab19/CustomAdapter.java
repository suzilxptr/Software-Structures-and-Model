package com.bigbang.bastolasushil.lab19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.bigbang.bastolasushil.lab19.AllPlayers.*;

/**
 * Created by The BigBang on 1.4.2016.
 */
public class CustomAdapter extends BaseAdapter implements ListAdapter{

    private ArrayList<Player> playerListView=AllPlayers.getFromXml().getPlayers();

    Context c;



    public CustomAdapter(Context c){
        this.notifyDataSetChanged();

        this.c=c;

    }







    @Override
    public int getCount() {
        System.out.println("DAta in "+playerListView.size());
        return playerListView.size();
    }

    @Override
    public Object getItem(int i) {

        return playerListView.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.customlayout,viewGroup,false);
       TextView v= (TextView) row.findViewById(R.id.each);

        Player p=playerListView.get(i);

        v.setText(p.getName());

        return row;
    }

}
