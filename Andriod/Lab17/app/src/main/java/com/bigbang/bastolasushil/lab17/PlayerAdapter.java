package com.bigbang.bastolasushil.lab17;

/**
 * Created by The BigBang on 7.4.2016.
 */
import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;


public class PlayerAdapter extends BaseAdapter implements ListAdapter {
    private Context thisContext;
    private Players currentList;

    public PlayerAdapter(Context context, Players playerList) {
        this.thisContext = context;
        this.currentList = playerList;
    }

    @Override
    public int getCount() {
        return currentList.getSize();
    }

    @Override
    public Object getItem(int position) {
        return currentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public int getItemViewType(int position) {
        return 0; // all views are similar...
    }

    @Override
    public int getViewTypeCount() {
        return 1; // ... so, one type only
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return getCount()==0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View targetView = convertView;
        ViewHolder holder;
        Log.d("layout", "getview");

        if (targetView == null) {
            targetView = LayoutInflater.from(thisContext).inflate(R.layout.player_item, null);
            holder = new ViewHolder();
            holder.idText = (TextView) targetView.findViewById(R.id.idTextView);
            holder.nameText = (TextView) targetView.findViewById(R.id.nameTextView);

            targetView.setTag(holder);
        } else {
            holder = (ViewHolder) targetView.getTag();
        }

        Player p = (Player) this.currentList.get(position);
        if (p != null) {
            holder.idText.setText("Id: " + p.getId());
            holder.nameText.setText("Name: " + p.getName());
        }
        return targetView;
    }

    private static class ViewHolder {
        TextView idText, nameText;
    }
}


