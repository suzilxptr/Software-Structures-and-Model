package com.bigbang.bastolasushil.lab15;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Updater{
    private  final static  String url="http://users.metropolia.fi/~peterh/players.xml";
    ListView view;
    CustomAdapter c=new CustomAdapter(this);
    Button add;
    private HandleXML obj;
    AllPlayers all=AllPlayers.getFromXml();



      @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        CustomAdapter adapter = (CustomAdapter) view.getAdapter();
        adapter.notifyDataSetChanged();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Runnable r=null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button player=(Button)findViewById(R.id.add);
        view=(ListView)findViewById(R.id.listView);



            Log.d("000", " called");



        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                view.setAdapter(c);
                CustomAdapter adapter = (CustomAdapter) view.getAdapter();
                adapter.notifyDataSetChanged();


            }
        };


        obj = new HandleXML(url,handler);
        ObserversCollection.getInstance().addObserver(this);
        Thread t=new Thread(r);

    r=new Runnable(){

        @Override
        public void run() {
        try {
            obj.fetchXML();
            Toast.makeText(MainActivity.this, "Parsing data from web", Toast.LENGTH_SHORT).show();
            handler.postDelayed(this, 10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        handler.sendEmptyMessage(0);

    }
};

    t.start();
    handler.postDelayed(r, 10000);

        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity.this, AddPlayer.class);
                startActivityForResult(i1, 1);


            }
        });






    }

    @Override
    public void update() {
        c.notifyDataSetChanged();

    }

}
