package com.bigbang.bastolasushil.lab19;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by The BigBang on 5.4.2016.
 */
public class AddPlayer extends AppCompatActivity {
    private ArrayList<Player> playerListView=AllPlayers.getFromXml().getPlayers();
    static MainActivity s=null;
    EditText player;
    Button add;
    private int count=16;
    Player p=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        player=(EditText)findViewById(R.id.player);
        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name = player.getText().toString();

                p = new Player(name,playerListView.size()+1);
                p.setName(name);
                p.setId(playerListView.size()+1);
                Intent i = getIntent();
                AddPlayer.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        playerListView.add(p);

                    }
                });
                Intent back=new Intent(AddPlayer.this,MainActivity.class);
               finish();





            }

        });

    }


}



