package com.bigbang.bastolasushil.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by The BigBang on 16.3.2016.
 */
public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        final TextView text=(TextView) findViewById(R.id.textView) ;

        Intent i=getIntent();
        String s=i.getStringExtra("name");
        System.out.println("The value is "+ s);
        text.setText(s);


    }


}
