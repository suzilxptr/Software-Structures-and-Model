package com.bigbang.bastolasushil.lab22;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String MY_VAR="kEY";

    int value;

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("Restart","called");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Destory","called");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("onStart", "called");
        SharedPreferences store=getSharedPreferences(MY_VAR, Context.MODE_PRIVATE);

        final TextView text = (TextView) findViewById(R.id.count);

        int xValue=store.getInt("counter", 0);
        String count = Integer.toString(xValue);
        text.setText(count);

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Resume","called");


    }

    @Override
    protected void onStop(){
        super.onStop();
        SharedPreferences store=getSharedPreferences(MY_VAR, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = store.edit();
        final TextView text = (TextView) findViewById(R.id.count);
        int xValue = Integer.parseInt(text.getText().toString());
        edit.putInt("counter", Counter.setCount(xValue));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView text = (TextView) findViewById(R.id.count);



            final Button ibutton=(Button)findViewById(R.id.increase);
                ibutton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                SharedPreferences store=getSharedPreferences(MY_VAR, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = store.edit();

                int xValue=store.getInt("counter", 0);
                        System.out.println("The x value is: " + xValue);
                edit.putInt("counter", Counter.setCount(xValue));
                        edit.commit();
                        System.out.println("The  counter is: " + Counter.setCount(xValue));
                value = store.getInt("counter", 0);
                        System.out.println("The  value is: "+ value);




                String count = Integer.toString(Counter.setCount(xValue));
                text.setText(count);
            }


        });

        ibutton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                SharedPreferences store=getSharedPreferences(MY_VAR, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = store.edit();

                int xValue=store.getInt("counter", 0);
                System.out.println("The x value is: "+ xValue);
                edit.putInt("counter", Counter.setCountadd(xValue));
                edit.commit();
                System.out.println("The  counter is: " + Counter.setCountadd(xValue));
                value = store.getInt("counter",0);
                System.out.println("The  value is: "+ value);

                String count = Integer.toString(value);
                text.setText(count);
                return true;
            }
        });
        final Button dbutton=(Button)findViewById(R.id.decrease);
        dbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SharedPreferences store=getSharedPreferences(MY_VAR, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = store.edit();

                int xValue=store.getInt("counter", 0);
                System.out.println("The x value is: "+ xValue);
                if (xValue>0) {
                    edit.putInt("counter", Counter.setCountlow1(xValue));
                    edit.commit();
                    System.out.println("The  counter is: " + Counter.setCountlow1(xValue));
                    value= store.getInt("counter", 0);

                    String count = Integer.toString(value);
                    text.setText(count);
                }
            }



        });
        dbutton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                SharedPreferences store = getSharedPreferences(MY_VAR, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = store.edit();
                final TextView text = (TextView) findViewById(R.id.count);
                int xValue = store.getInt("counter", 0);


                if (xValue >0) {


                    edit.putInt("counter", Counter.setCountsub(xValue));
                    edit.commit();
                    value = store.getInt("counter", 0);

                    if (value < 0) {
                        value = 0;
                        edit.putInt("counter", value);
                        edit.commit();
                    }
                    String count = Integer.toString(value);
                    text.setText(count);
                }
                return true;
            }
        });
        final Button rbutton=(Button)findViewById(R.id.reset);
        rbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences store = getSharedPreferences(MY_VAR, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = store.edit();
                final TextView text = (TextView) findViewById(R.id.count);


                int xValue = store.getInt("counter", 0);


                edit.putInt("counter", Counter.counterReset(xValue));
                edit.commit();
                int value=store.getInt("counter",0);
                edit.commit();
                String count = Integer.toString(value);
                text.setText(count);


            }


        });





    }

}
