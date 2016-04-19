package com.bigbang.bastolasushil.lab11;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Observer {
    CountProgress c=new CountProgress();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        c.o=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.start);
        final EditText step = (EditText) findViewById(R.id.step);
        final EditText sleep = (EditText) findViewById(R.id.sleep);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView value = (TextView) findViewById(R.id.done);
                value.setText("");

                String[] string = {step.getText().toString(), sleep.getText().toString()};
                c.execute(string);

            }
        });


    }




    @Override
    public void update(Integer i) {
        if (i == 100) {
            TextView value = (TextView) findViewById(R.id.done);
            value.setText("Done");
        }
        TextView value = (TextView) findViewById(R.id.percent);
        value.setText(i + "%");

    }
}


