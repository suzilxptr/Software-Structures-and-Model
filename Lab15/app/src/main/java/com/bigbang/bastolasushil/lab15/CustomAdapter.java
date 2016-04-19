package com.bigbang.bastolasushil.lab15;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.bigbang.bastolasushil.lab15.AllPlayers.*;

/**
 * Created by The BigBang on 1.4.2016.
 */
public class CustomAdapter extends BaseAdapter implements ListAdapter{

    private ArrayList<Player> playerListView=AllPlayers.getFromXml().getPlayers();

    Context c;
    public void addPlayerp(Player p){
    playerListView.add(p);

}


    public CustomAdapter(Context c){


        this.c=c;

    }



    public  void setPlayerListView(ArrayList<Player> playerListView1) {
       playerListView1 = playerListView;
    }




    @Override
    public int getCount() {

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
        TextView v1=(TextView)row.findViewById(R.id.id);
        Player p=playerListView.get(i);

        v.setText(p.getName());
        v1.setText(p.getId()+"");
        return row;
    }
}
