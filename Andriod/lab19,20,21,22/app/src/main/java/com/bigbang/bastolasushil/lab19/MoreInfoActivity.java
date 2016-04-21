package com.bigbang.bastolasushil.lab19;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        TextView name=(TextView)findViewById(R.id.playerName);

        Intent getIntent=getIntent();
        String s=getIntent.getStringExtra("Name");
        name.setText(s);



    }

}
