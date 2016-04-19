package com.bigbang.bastolasushil.lab14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigbang.bastolasushil.lab14.R;


public class MainActivity extends AppCompatActivity {
    private  final static  String url="http:\n" +
            "//yle.fi/uutiset/rss/uutiset.rss?osasto=news";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button player=(Button)findViewById(R.id.player);
        final TextView all=(TextView)findViewById(R.id.textView);

        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final HandleXML obj = new HandleXML(url);
                try {
                    obj.fetchXML();
                    all.setText(obj.s.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }




            }

        });

    }

}
