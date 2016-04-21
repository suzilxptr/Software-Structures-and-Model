package com.bigbang.bastolasushil.lab17;

/**
 * Created by The BigBang on 7.4.2016.
 */
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class DownloadXmlTask extends AsyncTask<String, Void, String> {
    private Context _context;
    private boolean isDisplayChanged;
    private boolean isPeriodicUpdate;
    private Players players = Players.getInstance();

    public DownloadXmlTask(Context context, boolean isDisplayChanged, boolean isPeriodicUpdate){
        this._context = context;
        this.isDisplayChanged = isDisplayChanged;
        this.isPeriodicUpdate = isPeriodicUpdate;
    }

    public DownloadXmlTask(Context context, boolean isDisplayChanged){
        this._context = context;
        this.isDisplayChanged = isDisplayChanged;
        this.isPeriodicUpdate = true;
    }

    @Override
    protected String doInBackground(String... urls) {
        try {
            return loadXmlFromNetwork(urls[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        if(!isDisplayChanged){
//            return;
//        }
        updateListView();
    }

    // Uploads XML from stackoverflow.com, parses it, and combines it with
// HTML markup. Returns HTML string.
    private String loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {
        InputStream stream = null;
        // Instantiate the parser
        PlayerParser playerParser= new PlayerParser();
        List<Player> entries = null;
        Log.d("task", "loading");
        try {
            stream = downloadUrl(urlString);
            entries = playerParser.parse(stream);
            players.clear();
            for(Player p : entries){
                players.add(p);
            }
            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

        return null;
    }

    // Given a string representation of a URL, sets up a connection and gets
// an input stream.
    private InputStream downloadUrl(String urlString) throws IOException, URISyntaxException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        // Starts the query
        conn.connect();
        return conn.getInputStream();
    }

    private void updateListView(){
        Intent intent = new Intent(_context, DisplayListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("checkbox", isPeriodicUpdate);
        _context.startActivity(intent);
    }
}
