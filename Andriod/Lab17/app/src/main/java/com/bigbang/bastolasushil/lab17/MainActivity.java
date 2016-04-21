package com.bigbang.bastolasushil.lab17;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


import com.bigbang.bastolasushil.lab17.R;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "http://users.metropolia.fi/~peterh/players.xml";
    private Players players = Players.getInstance();
    private Button mStartButton;
    private TextView mMessageText;
    private Context thisContext;
    private boolean mNoMore = false;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartButton = (Button) findViewById(R.id.startButton);
        mMessageText = (TextView) findViewById(R.id.messageText);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);

        thisContext = this;
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mNoMore == true){
                    updateListView();
                    return;
                }
                mNoMore = true;
                new DownloadXmlTask(MainActivity.this, true, mCheckBox.isChecked()).execute(URL);
                mMessageText.setText("Parsing...");
            }
        });
    }

    private void updateListView(){
        Intent intent = new Intent(MainActivity.this, DisplayListActivity.class);
        intent.putExtra("checkbox", mCheckBox.isChecked());
        startActivity(intent);
    }
}

