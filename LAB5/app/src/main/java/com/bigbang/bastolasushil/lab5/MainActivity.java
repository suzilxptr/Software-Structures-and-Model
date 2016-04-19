package com.bigbang.bastolasushil.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Counter c=new Counter();
    int counter=c.increaseCount();
    int lcounter=c.increaseCountlong();
    //int decrease=c.decreaseCount();
    int reset=c.reset();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button ibutton=(Button)findViewById(R.id.increase);
        ibutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final TextView text = (TextView) findViewById(R.id.count);
                int xValue = Integer.parseInt(text.getText().toString());


                int setValue = xValue + counter;
                String count = Integer.toString(setValue);
                text.setText(count);
            }


        });

        ibutton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                final TextView text = (TextView) findViewById(R.id.count);
                int xValue = Integer.parseInt(text.getText().toString());


                int setValue = xValue + lcounter;
                String count = Integer.toString(setValue);
                text.setText(count);
                return true;

            }
        });
        final Button dbutton=(Button)findViewById(R.id.decrease);
        dbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final TextView text=(TextView) findViewById(R.id.count);
                int xValue = Integer.parseInt(text.getText().toString());
                if (xValue!=0) {
                    int setValue = xValue - counter;
                    String count = Integer.toString(setValue);

                    text.setText(count);
                }
            }



        });
        dbutton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                final TextView text = (TextView) findViewById(R.id.count);
                int xValue = Integer.parseInt(text.getText().toString());

                if (xValue != 0) {
                    int setValue = xValue - lcounter;
                    if (setValue < 0) {
                        setValue = 0;
                    }
                    String count = Integer.toString(setValue);
                    text.setText(count);

                }
                return true;
            }
        });
        final Button rbutton=(Button)findViewById(R.id.reset);
        rbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final TextView text=(TextView) findViewById(R.id.count);
                String count= Integer.toString(reset);
                text.setText(count);

            }



        });
        rbutton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                final TextView text = (TextView) findViewById(R.id.count);
                String count = Integer.toString(reset);
                text.setText(count);
                return true;
            }
        });




    }

}
