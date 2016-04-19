package com.bigbang.bastolasushil.lab13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private  final static  String url="http://users.metropolia.fi/~peterh/players.xml";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button player=(Button)findViewById(R.id.player);
        final TextView all=(TextView)findViewById(R.id.textView);

        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final HandleXML  obj = new HandleXML(url);
                try {
                    obj.fetchXML();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                    String s = obj.allplayers.allPlayers();
                    all.setText(s);
                    System.out.println("The String is:" + s);


            }

        });

    }

}
